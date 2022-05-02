import java.util.NoSuchElementException;

public class LinkedList<T> {

    // field to hold the first node
    private LLNode<T> firstNode;
    // field to store the length of the linked list
    private int length;

    /**
     * constructor for linked list
     * creates an empty list
     */
    public LinkedList() {
        firstNode = null;
    }

    /**
     * getter method for first node
     * @return the firstNode
     */
    protected LLNode<T> getFirstNode() {
        return this.firstNode;
    }

    /**
     * setter method for first node
     * @param node - the new first node
     */
    protected void setFirstNode(LLNode<T> node) {
        this.firstNode = node;
    }

    /**
     * getter to get the length of the linked list
     * @return the length
     */
    public int getLength() {
        return this.length;
    }

    /**
     * method to add a new value to the front of a linked list
     * @param e - the next element
     */
    public void addToFront(T e) {
        setFirstNode(new LLNode<T>(e, firstNode));
        // increment the length
        this.length++;
    }

    /**
     * method to add to the back of a list
     * @param e - the new element
     */
    public void addToEnd(T e) {
        // if the list is empty, adding to the back is the same as adding to the front
        if(isEmpty())
            addToFront(e);
        // otherwise, loop through the list to find the back, then add
        else {
            LLNode<T> nodePointer = getFirstNode();
            while(nodePointer.getNext() != null) {
                nodePointer = nodePointer.getNext();
            }
            nodePointer.setNext(new LLNode<T>(e, null));
        }
        // increment the length by 1
        this.length++;
    }

    /**
     * method to remove a value from the front of a linked list
     * @return element that is removed
     */
    public T removeFromFront() {
        if( !isEmpty() ) {
            // save the first node and set the second node to the first node
            T node = getFirstNode().getElement();
            setFirstNode(firstNode.getNext());
            // decrement the length
            this.length--;
            return node;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    /**
     * method to check if the linked list is empty
     * @ return true/false
     */
    public boolean isEmpty() {
        return (getFirstNode() == null);
    }

}
