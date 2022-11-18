import java.util.Iterator;

public class ListQuizzer {
    private LinkedNode<MultipleChoiceQuestion> head; // contains the first node in the list
    private ListingMode listingMode; // the mode the ListQuizzer is in
    private int size; // size of the list
    private LinkedNode<MultipleChoiceQuestion> tail; // contains the last node in the list
    /**
     * Constructs an empty ListQuizzer object with no elements in it.
     * <p>
     * Sets listingMode to ALL by default.
     */
    public ListQuizzer() {
        listingMode = ListingMode.ALL;
        size = 0;
    }
    /**
     * Checks whether or not this ListQuizzer is empty.
     * @return true if there are no elements in this ListQuizzer, false otherwise
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    /**
     * Returns the count of how many elements are in this ListQuizzer.
     * @return the size of this list
     */
    public int size() {
        return size;
    }
    /**
     * Switches the listing mode for this ListQuizzer to the specified mode.
     * @param listingMode the mode to switch to
     */
    public void switchMode(ListingMode listingMode) {
        this.listingMode = listingMode;
    }
    /**
     * Adds a node to this ListQuizzer at a specified index.
     * @param index the index to add the node at
     * @param question the MultipleChoiceQuestion the node will contain
     * @throws NullPointerException if the MultipleChoiceQuestion passed in is null
     * @throws IndexOutOfBoundsException if the index passed in is either negative or greater than the size of the ListQuizzer
     */
    public void add(int index, MultipleChoiceQuestion question) throws NullPointerException, IndexOutOfBoundsException {
        // handle any bad input
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("The index you want to add this question at is invalid. Please only use indices between 0 and the size of the ListQuizzer (inclusive)");
        }
        if (question == null) {
            throw new NullPointerException("The question you tried to add is null");
        }
        // handle adding a node
        if (index == 0) {
            LinkedNode<MultipleChoiceQuestion> toAdd = new LinkedNode<MultipleChoiceQuestion>(question, head);
            this.head = toAdd;
        }
        else if (index == this.size()) {
            LinkedNode<MultipleChoiceQuestion> toAdd = new LinkedNode<MultipleChoiceQuestion>(question);
            this.tail.setNext(toAdd);
            this.tail = toAdd;
        }
    }
    /**
     * Adds a node the the head of the ListQuizzer
     * @param question the MultipleChoiceQuestion to use to create the node
     * @throws NullPointerException if the passed question is null
     */
    public void addFirst(MultipleChoiceQuestion question) throws NullPointerException {
        if (question == null) {
            throw new NullPointerException("The question you tried to add is null");
        }
        else if (this.size == 0) {
            this.head = new LinkedNode<MultipleChoiceQuestion>(question, this.head);
            this.tail = this.head;
        }
        else {
            this.head = new LinkedNode<MultipleChoiceQuestion>(question, this.head);
        }
    }
    /**
     * Adds a node to the tail of the ListQuizzer
     * @param question the question to use to create the node
     * @throws NullPointerException if the passed question is null
     */
    public void addLast(MultipleChoiceQuestion question) throws NullPointerException {
        if (question == null) {
            throw new NullPointerException("The question you tried to add is null");
        }
        else if (this.size == 0) {
            this.head = new LinkedNode<MultipleChoiceQuestion>(question, this.head);
            this.tail = this.head;
        }
        else {
            this.tail.setNext(new LinkedNode<MultipleChoiceQuestion>(question));
            this.tail = this.tail.getNext();
        }
    }
    /**
     * Returns the head of this ListQuizzer.
     * @return the head of this listQuizzer
     */
    public LinkedNode<MultipleChoiceQuestion> getFirst() {
        return head;
    }
    /**
     * Returns the tail of this ListQuizzer.
     * @return the tail of this ListQuizzer
     */
    public LinkedNode<MultipleChoiceQuestion> getLast() {
        return tail;
    }




}
