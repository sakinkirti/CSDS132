import junit.framework.TestCase;
import java.util.NoSuchElementException;

/** A JUnit test case class.
  * Every method starting with the word "test" will be called when running
  * the test with JUnit.
  * @author Sakin Kirti
  * @since 12/1/2021
  */
public class DNATester extends TestCase {
  
  /* ---------------------- */
  /* METHOD TESTING FOR DNA */
  /* ---------------------- */
  
  /**
   * tests the string2DNA method
   * takes a string and returns a DNA object that represents the string
   */
  public void testString2DNA() {
    // test none
    try { DNA.string2DNA(""); } 
    catch(IllegalArgumentException e) { assertEquals(1, 1); }
    // test one
    DNA x = new DNA();
    x.addToBack(DNA.Base.A);
    assertEquals(x, DNA.string2DNA("A"));
    try { DNA.string2DNA(" "); }
    catch(IllegalArgumentException e) { assertEquals(1, 1); }
    try { DNA.string2DNA("g"); }
    catch(IllegalArgumentException e) { assertEquals(1, 1); }
    // test many, test first, middle, last with wrong characters
    DNA a = DNA.string2DNA("ATGCGCATCATCG");
    DNA b = DNA.string2DNA("ATGCGCATCATCG");
    assertEquals(true, a.equals(b));
    try { DNA.string2DNA("hTGCGCATCATCG"); }
    catch(IllegalArgumentException e) { assertEquals(1, 1); }
    try { DNA.string2DNA("ATGCGC TCATCG"); }
    catch(IllegalArgumentException e) { assertEquals(1, 1); }
    try { DNA.string2DNA("ATGCGCATCAT,"); }
    catch(IllegalArgumentException e) { assertEquals(1, 1); }
  }
  
  /**
   * tests the splice method
   */
  public void testSplice() {
    // test none
    DNA a = DNA.string2DNA("ATGCGTAC");
    DNA b = DNA.string2DNA("ATGCGTAC");
    a.splice(b, 0);
    assertEquals(true, a.equals(DNA.string2DNA("ATGCGTACATGCGTAC")));
    // test one
    DNA c = DNA.string2DNA("ATGCGTAC");
    DNA d = DNA.string2DNA("ATGCGTAC");
    c.splice(d, 1);
    assertEquals(true, c.equals(DNA.string2DNA("ATGCGTACTGCGTAC")));
    // test many
    DNA e = DNA.string2DNA("ATGCGTAC");
    DNA f = DNA.string2DNA("ATGCGTAC");
    e.splice(f, 3);
    assertEquals(true, e.equals(DNA.string2DNA("ATGCGTACCGTAC")));
    DNA g = DNA.string2DNA("ATGCGTAC");
    DNA h = DNA.string2DNA("ATGCGTAC");
    g.splice(h, 7);
    assertEquals(true, g.equals(DNA.string2DNA("ATGCGTACC")));
    // test last
    DNA i = DNA.string2DNA("ATGCGTAC");
    DNA j = DNA.string2DNA("ATGCGTAC");
    i.splice(j, 8);
    assertEquals(true, i.equals(DNA.string2DNA("ATGCGTAC")));
  }
  
  /**
   * tests the overlaps method
   * This is a static method, so it takes two DNA objects and an integer
   * and returns whether the DNA objects overlap with the number of bases
   */
  public void testOverlaps() {
    // test none
    assertEquals(false, DNA.overlaps(DNA.string2DNA("ATGCA"), DNA.string2DNA("GCTAC"), 0));
    // test one
    assertEquals(false, DNA.overlaps(DNA.string2DNA("AGTC"), DNA.string2DNA("TGA"), 1));
    assertEquals(true, DNA.overlaps(DNA.string2DNA("TGA"), DNA.string2DNA("AGTC"), 1));
    assertEquals(false, DNA.overlaps(DNA.string2DNA("GTCA"), DNA.string2DNA("TAC"), 1));
    // test many, test first and last
    assertEquals(true, DNA.overlaps(DNA.string2DNA("ATA"), DNA.string2DNA("ATA"), 3));
    assertEquals(true, DNA.overlaps(DNA.string2DNA("ATGA"), DNA.string2DNA("ATGAGCTACG"), 4));
    assertEquals(true, DNA.overlaps(DNA.string2DNA("AGCTACGTACGGC"), DNA.string2DNA("ACGGCATCGAAGC"), 5));
    assertEquals(true, DNA.overlaps(DNA.string2DNA("ACGGCATCGAAGC"), DNA.string2DNA("AGCTACGTACGGC"), 3));
  }
  
  /**
   * tests the toString method
   * returns a string representation of the DNA strand
   * only needs test none, one, many
   */
  public void testToString() {
    // test none
    assertEquals("", new DNA().toString());
    // test one
    assertEquals("A", DNA.string2DNA("A").toString());
    // test many
    assertEquals("ATGCCGTACGTGCA", DNA.string2DNA("ATGCCGTACGTGCA").toString());
    assertEquals("GTCGTACGTACAGTCAGATACGATACAGTAA", DNA.string2DNA("GTCGTACGTACAGTCAGATACGATACAGTAA").toString());
  }
  
  /**
   * tests the compareTo method
   * should return -1 is this is shorter than another DNA, 1 if this is longer
   * if they are exactly equal lengths, should return -1 if this comes after another DNA alphabetically, 
   *     or 1 if this comes before another DNA alphabetically
   * 0 will only be returned if this DNA is exactly the same as another DNA
   * loops and conditionals, test with test first, middle, last and test none, one, many
   */
  public void testCompareTo() {
    // test length
    assertEquals(-1, DNA.string2DNA("ATGC").compareTo(DNA.string2DNA("AGCTAGC")));
    assertEquals(1, DNA.string2DNA("ATGCGCTACGACTC").compareTo(DNA.string2DNA("AGCTAGC")));
    // test none
    assertEquals(1, DNA.string2DNA("ATCG").compareTo(new DNA()));
    assertEquals(-1, new DNA().compareTo(DNA.string2DNA("ATCG")));
    assertEquals(0, new DNA().compareTo(new DNA()));
    // test one
    assertEquals(1, DNA.string2DNA("A").compareTo(DNA.string2DNA("G")));
    assertEquals(-1, DNA.string2DNA("T").compareTo(DNA.string2DNA("G")));
    // test many
    assertEquals(1, DNA.string2DNA("ATGC").compareTo(DNA.string2DNA("CATG")));
    assertEquals(-1, DNA.string2DNA("CATG").compareTo(DNA.string2DNA("ATGC")));
    // test two that are the same
    assertEquals(0, DNA.string2DNA("CTCCAGTAAAGTTGTTTATA").compareTo(DNA.string2DNA("CTCCAGTAAAGTTGTTTATA")));
  }
  
}
