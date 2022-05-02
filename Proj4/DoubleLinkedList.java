import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

/**
 * @author Sakin Kirti
 * A doubly linked list
 * can be traversed both forwards and backwards
 */
public class DoubleLinkedList<T> implements Iterable<T> {
  /** a reference to the first node of the double linked list */
  private DLNode<T> front;
  
  /** a reference to the last node of a double linked list */
  private DLNode<T> back;
  
  /** Create an empty double linked list. */
  public DoubleLinkedList() {
    front = back = null;
  }
  
  /**
   * Returns true if the list is empty.
   * @return  true if the list has no nodes
   */
  public boolean isEmpty() {
    return (getFront() == null);
  }
  
  /**
   * Returns the reference to the first node of the linked list.
   * @return the first node of the linked list
   */
  protected DLNode<T> getFront() {
    return front;
  }
  
  /**
   * Sets the first node of the linked list.
   * @param node  the node that will be the head of the linked list.
   */
  protected void setFront(DLNode<T> node) {
    this.front = node;
  }
  
  /**
   * Returns the reference to the last node of the linked list.
   * @return the last node of the linked list
   */
  protected DLNode<T> getBack() {
    return back;
  }
  
  /**
   * Sets the last node of the linked list.
   * @param node the node that will be the last node of the linked list
   */
  protected void setBack(DLNode<T> node) {
    this.back = node;
  }
  
  /*--------------------*/
  /* ADDITIONAL METHODS */
  /*--------------------*/
  
  /**
   * get the length of the list
   * @return the length of the list
   */
  public int getLength() {
    
    // create a nodeptr and count the nodes
    DLNode<T> nodeptr = this.getFront();
    int length = 0;
    
    while(nodeptr != null) {
      length++;
      nodeptr = nodeptr.getNext();
    }
    
    return length;
  }
  
  /**
   * Add an element to the head of the linked list.
   * @param element  the element to add to the front of the linked list
   */
  public void addToFront(T element) {
    DLNode<T> node = new DLNode<T> (element, null, this.getFront());
    if (isEmpty()) {
      this.setBack(node);
    }
    this.setFront(node);
  }
  
  /**
   * Add an element to the tail of the linked list.
   * @param element  the element to add to the tail of the linked list
   */
  public void addToBack(T element) {
    DLNode<T> node = new DLNode<T> (element, this.getBack(), null);
    
    if(isEmpty()) {
      this.setFront(node);
    }
    this.setBack(node);
  }
  
  /**
   * Remove and return the element at the front of the linked list.
   * @return the element that was at the front of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */
  public T removeFromFront() throws NoSuchElementException {
    if(isEmpty())
      throw new NoSuchElementException();
    else {
      T element = this.getFront().getElement();
      this.setFront( this.getFront().getNext() );
      
      if(this.getFront() == null)
        this.setBack(null);
      
      return element;
    }
  }
  
  /**
   * Remove and return the element at the back of the linked list.
   * @return the element that was at the back of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */
  public T removeFromBack() throws NoSuchElementException {
    if(isEmpty())
      throw new NoSuchElementException();
    else {
      T element = this.getBack().getElement();
      this.setBack( this.getBack().getPrevious() );
      
      if(this.getBack() == null)
        this.setFront(null);
      
      return element;
    }
  }
  
  /**
   * overrides the equals method of Object
   * two LinkedLists are equal if all elements are the same and in the same order
   * @return true or false
   * @param list - the linked list to compare to this list
   * @throws IllegalArgumentException
   */
  @Override
  public boolean equals(Object l) throws IllegalArgumentException {
    
    // make sure that l is a DoubleLinkedList
    DoubleLinkedList list;
    if(l instanceof DoubleLinkedList)
      list = (DoubleLinkedList)l;
    else
      throw new IllegalArgumentException();
    
    // iterate until one of the lists is null, if each element is equal, return true
    DLNode nodeptr1 = this.getFront();
    DLNode nodeptr2 = list.getFront();
    
    while(nodeptr1 != null || nodeptr2 != null) {
      if(nodeptr1.getElement() != nodeptr2.getElement())
        return false;
      
      nodeptr1 = nodeptr1.getNext();
      nodeptr2 = nodeptr2.getNext();
    }
    
    // check if both are null, if so, end of list is the same
    return (nodeptr1 == null && nodeptr2 == null);
    
  }
  
  /**
   * append method
   * appends a Double Linked List to the end of this double linked list
   * @param node - the node of the linked list to append
   * @return none
   */
  public void append(DoubleLinkedList<T> list) {
    
    // sets the front of list to the back of this list
    if(list.getLength() != 0 && this.getLength() != 0) {
      list.getFront().setPrevious(this.getBack());
      this.getBack().setNext(list.getFront());
    }
    else if(this.getLength() == 0) {
      this.setFront(list.getFront());
      this.setBack(list.getBack());
    }
  }
  
  /**
   * Returns an interator for the linked list that starts at the head of the list and runs to the tail.
   * @return the iterator that runs through the list from the head to the tail
   */
  @Override
  public ListIterator<T> iterator() {
    // returns a newly generated anonymous class containing the necessary methods for an iterator
    return new ListIterator<T>() {
      
      // stores current node
      DLNode<T> current = DoubleLinkedList.this.getFront();
      
      /**
       * adds an element to the back of a double linked list
       * @param element - the element to add
       */
      public void add(T element) {
        DoubleLinkedList.this.addToBack(element);
      }
      
      /**
       * checks whether the element's next is a value or null
       * @return a boolean value
       */
      public boolean hasNext() {
        return current != null;
      }
      
      /**
       * get's the next value
       * @return element - the element stored
       */
      public T next() {
        T element = current.getElement();
        current = current.getNext();
        return element;
      }
      
      /**
       * checks whether the element's previous is a value or null
       * @return a boolean value
       */
      public boolean hasPrevious() {
        return current != null;
      }
      
      /**
       * get's the previous value
       * @return element - the element stored
       */
      public T previous() {
        T element = current.getElement();
        current = current.getPrevious();
        return element;
      }
      
      /**
       * replaces the last element from next or previous with element
       * @param element - the element to store
       */
      public void set(T element) {
        
      }
      
      /**
       * remove, previousIndex, and nextIndex not supported by this list iterator
       * @throws UnsupportedOperationException
       */
      public void remove() { throw new UnsupportedOperationException(); }
      public int previousIndex() { throw new UnsupportedOperationException(); }
      public int nextIndex() { throw new UnsupportedOperationException(); }
    };
  }
  
}
