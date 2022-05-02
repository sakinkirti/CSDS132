public class LLNode<T> {

    // field to hold the element
    private T element;
    // field to hold the next node
    private LLNode<T> next;

    /**
     * constructor to create an LLNode
     * @param e - the element
     * @param n - the next node
     */
    public LLNode(T e, LLNode<T> n) {
        this.element = e;
        this.next = n;
    }

    /**
     * method to get the element
     * @return the value stored in element
     */
    public T getElement() {
        return this.element;
    }

    /**
     * method to set the element
     * @param e - the new element
     */
    public void setElement(T e) {
        this.element = e;
    }

    /**
     * method to get the next node
     * @return the next node
     */
    public LLNode<T> getNext() {
        return this.next;
    }

    /**
     * method to set the next node
     * @param n - the next node
     */
    public void setNext(LLNode<T> n) {
        this.next = n;
    }
}
