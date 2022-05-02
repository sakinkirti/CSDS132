/**
 * class to define DNA
 * @author Sakin Kirti
 */
public class DNA extends DoubleLinkedList<DNA.Base> implements Comparable {
  
  /**
   * main method
   */
  public static void main(String[] args) {
    
    // initialize 2 DNA strands
    DNA strand1 = new DNA();
    DNA strand2 = new DNA();
    
    // get the strands from args
    try {
      strand1 = string2DNA(args[0]);
    } catch(IllegalArgumentException e) {
      System.out.println("Strand 1 is invalid");
    }
    try {
      strand2 = string2DNA(args[1]);
    } catch(IllegalArgumentException e) {
      System.out.println("Strand 2 is invalid");
    }
    
    // determine the greater overlap between strand 1 and 2
    // store the number of bases that overlap
    int numOverlapFor = 0;
    int numOverlapBack = 0;
    // store the length to iterate through
    int iterLength = Math.min(strand1.getLength(), strand2.getLength());
    
    // iterate for overlap through the length of the shorter strand
    for(int overlap = 1; overlap <= iterLength; overlap++) {
      // if strand currently overlaps store the overlap value
      if(overlaps(strand1, strand2, overlap))
        numOverlapFor = overlap;
      // if reverse relationship overlaps store the overlap value
      if(overlaps(strand2, strand1, overlap))
        numOverlapBack = overlap;
    }
    
    // splice the first strand onto the second if forward overlap is greater
    if(numOverlapFor >= numOverlapBack) {
      strand1.splice(strand2, numOverlapFor);
      System.out.println(strand1.toString());
    }
    // splice the second strand onto the first is backward overlap is greater
    else if(numOverlapBack > numOverlapFor) {
      strand2.splice(strand1, numOverlapBack);
      System.out.println(strand2.toString());
    }
  }
  
  /**
   * create a DNA strand given in input of bases from the user
   * @param s - a string representing bases
   * @return a DNA strand represented by the bases
   * @throws IllegalArgumentException
   */
  public static DNA string2DNA(String s) throws IllegalArgumentException {
    
    // check that the length is not 0
    if(s.length() == 0) 
      throw new IllegalArgumentException();
    
    // create a new DNA strand to append bases to
    DNA representativeStrand = new DNA();
    
    // iterate through the string and add the base that 
    // represents the character at that position
    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == 'A')
        representativeStrand.addToBack(Base.A);
      else if(s.charAt(i) == 'T')
        representativeStrand.addToBack(Base.T);
      else if(s.charAt(i) == 'G')
        representativeStrand.addToBack(Base.G);
      else if(s.charAt(i) == 'C')
        representativeStrand.addToBack(Base.C);
      else
        throw new IllegalArgumentException();
    }
    
    // return the DNA strand
    return representativeStrand;
  }
  
  /**
   * splices a DNA strand
   * @param strand - the strand to split and attach
   * @return the new DNA strand
   */
  public void splice(DNA dna, int numBases) {
    
    // check to make sure num bases is within the cleaving range
    if(numBases >= dna.getLength())
      this.append(new DNA());
    else {
      for(int i = 0; i < numBases; i++)
        dna.removeFromFront();
      
      // append the remaining bases to the end of this strand
      this.append(dna);
    }
  }
  
  /**
   * checks to see if there is an overlap of n bases 
   * between the end of dna1 and the start of dna2
   * @param dna1 - the first dna strand
   * @param dna2 - the second dna strand
   * @param n - the number of bases to check overlap
   * @return boolean true or false
   */
  public static boolean overlaps(DNA dna1, DNA dna2, int n) {
    
    // first check that both are long enough
    if(dna1.getLength() < n || dna2.getLength() < n)
      return false;
    
    // if so, find the nth base from the back of dna1
    DLNode<DNA.Base> nodeptr = dna1.getBack();
    DLNode<DNA.Base> nodeptr2 = dna2.getFront();
    // iterate through dna1 from back to get the nth node from back
    for(int i = 1; i < n; i++) {
      nodeptr = nodeptr.getPrevious();
    }
    
    // check if nodeptr and nodeptr2 point to the same base
    // if so, advance to the next base
    // if not, return false
    while(nodeptr != null) {
      if(nodeptr.getElement() == nodeptr2.getElement()) {
        nodeptr = nodeptr.getNext();
        nodeptr2 = nodeptr2.getNext();
      }
      else {
        return false;
      }
    }
    // if it goes through the whole loop, all bases are same
    return true;
  }
  
  /**
   * creates a string representation of DNA
   * overrides toString of Object
   * @return String - representation of the DNA
   */
  public String toString() {
    
    // create a StringBuilder to hold the DNA string
    StringBuilder baseString = new StringBuilder();
    
    // iterate through the strand
    for(Base base : this) {
      String letter = base.toString();
      baseString.append(letter);
    }
    
    // return the string of the nucleotides
    return baseString.toString();
  }
  
  /**
   * orders DNA strands based on length and alphabet
   * @param dna - a DNA strand to compare this to
   * @return an integer that compares the two - 0 if exactly same, 
   *                                            1 if this is longer or if this comes before strand alphabetically, 
   *                                           -1 if this is shorter or if this comes after strand alphabetically
   * @throws IllegalArgumentException
   * Overrides method of Camparable interface
   */
  @Override
  public int compareTo(Object dna) throws IllegalArgumentException {
    
    // cast as DNA
    DNA strand;
    if(dna instanceof DNA)
      strand = (DNA)dna;
    else
      throw new IllegalArgumentException();
    
    // create a nodeptr and count the nodes
    DLNode<DNA.Base> nodeptrThis = this.getFront();
    DLNode<DNA.Base> nodeptrStrand = strand.getFront();
    int alphaOrder = 0;
    boolean completed = false;
    
    while(nodeptrThis != null && nodeptrStrand != null) {
      
      // alphabetically compare
      if(nodeptrThis.getElement().toString().charAt(0) - nodeptrStrand.getElement().toString().charAt(0) > 0 && !completed) {
        alphaOrder = -1;
        completed = true;
      }
      else if(nodeptrThis.getElement().toString().charAt(0) - nodeptrStrand.getElement().toString().charAt(0) < 0 && !completed) {
        alphaOrder = 1;
        completed = true;
      }
      else if(nodeptrThis.getElement().toString().charAt(0) - nodeptrStrand.getElement().toString().charAt(0) == 0 && !completed)
        alphaOrder = 0;
      
      // iterate nodepointers
      nodeptrThis = nodeptrThis.getNext();
      nodeptrStrand = nodeptrStrand.getNext();
    }
    
    // if lengths are different, return the difference
    if(nodeptrThis == null && nodeptrStrand != null)
      return -1;
    else if(nodeptrThis != null && nodeptrStrand == null)
      return 1;
    // if lengths are the same (both nodeptrs point to null), return alphabetical difference
    else
      return alphaOrder;
  }
  
  /**
   * enum type that represents each of the bases
   */
  enum Base {
    A, C, T, G;
  }
  
}