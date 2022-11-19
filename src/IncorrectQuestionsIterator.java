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
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IncorrectQuestionsIterator implements Iterator <MultipleChoiceQuestion> {
    private LinkedNode<MultipleChoiceQuestion> next; // contains the node with the next incorrect question
    /**
     * Constructs an IncorrectQuestionsIterator to iterate through all the incorrect questions in the list
     * @param startNode the node to start from
     */
    public IncorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
        next = startNode;
    }
    /**
     * Checks if there are any more nodes with incorrect questions
     */
    public boolean hasNext() {
        LinkedNode<MultipleChoiceQuestion> currNode = next; // we use this value to traverse the nodes without changing the value of next
        while (currNode != null) { // while there are still nodes to check 
            if (!currNode.getData().isCorrect()) {  // if there is an incorrect question return true
                return true;
            }
            else {
                currNode = currNode.getNext(); // otherwise move to next node
            }
        }
        return false;
    }
    /**
     * Returns the next incorrect question from the list
     */
    public MultipleChoiceQuestion next() {
        if (!hasNext()) { // if there are no more incorrect questions then throw an exception
            throw new NoSuchElementException("There are no more nodes with incorrect questions in the list");
        }
        while (next.getData().isCorrect()) { // cycle through the list until an incorrect question is found
            next = next.getNext();
        }
        MultipleChoiceQuestion data = next.getData(); // get data from the incorrect question
        next = next.getNext(); // iterate so we don't get stuck on this node
        return data;
    }
}
