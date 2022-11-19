//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P07 Quizzer
// Course:   CS 300 Fall 2022
//
// Author:   Zaid Ahmed
// Email:    zahmed8@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x__ Write-up states that pair programming is allowed for this assignment.
//   _x__ We have both read and understand the course Pair Programming Policy.
//   _x__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////
public class LinkedNode<T> {
    private T data; // contains the data for this LinkedNode
    private LinkedNode<T> next; // contains the data for the next LinkedNode in the list

    /**
     * Constructs a LinkedNode with no next node in the list.
     * @param data data carried by this linked node
     */
    public LinkedNode(T data) {
        if (data == null) {
            throw new NullPointerException("null data");
        }
        this.data = data;
        next = null;
    }
    /**
     * Constructs a LinkedNode with a reference to the next LinkedNode in the list
     * @param data data carried by this linked node
     * @param next reference to the next linked node in the list
     */
    public LinkedNode(T data, LinkedNode<T> next) {
        if (data == null) {
            throw new NullPointerException("null data");
        }
        this.data = data;
        this.next = next;
    }
    /**
     * Returns the data associated with this node.
     * @return the data associated with this node
     */
    public T getData() {
        return data;
    }
    /**
     * Returns a reference to the next node in the list.
     * @return the reference to the next node in the list.
     */
    public LinkedNode<T> getNext() {
        return next;
    }
    /**
     * Sets this node's reference to the next node to a given reference of a node
     * @param next the reference to replace this node's existing next node reference with
     */
    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }
    /**
     * Returns a string representation of the LinkedNode as follows:
     * <p>
     * data.toString() if the node does not have a next node
     * <p>
     * data.toString() + "->" if the node does have a next node
     */
    @Override
    public String toString() {
        if (next != null) {
            return data.toString() + "->";
        }
        else {
            return data.toString();
        }
    }

}
