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

public class CorrectQuestionsIterator implements Iterator<MultipleChoiceQuestion> {
    
    private LinkedNode<MultipleChoiceQuestion> next; // contains next node
    /**
     * Constructs an CorrectQuestionsIterator to iterate through all the incorrect questions in the list
     * @param startNode the node to start from
     */
    public CorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
        next = startNode;
    }
    /**
     * Checks if there are any more correct questions in the list
     */
    public boolean hasNext() {
        LinkedNode<MultipleChoiceQuestion> currNode = next; // we use this value to traverse the nodes without changing the value of next
        while (currNode != null) { // while there are still nodes left to check
            if ((currNode.getData().isCorrect())) { // if there is a correct question, return true
                return true;
            }
            else { // otherwise, move to the next node
                currNode = currNode.getNext();
            }
        }

        return false;   
    }
    /**
     * Returns the next correct mutliple choice question.
     */
    public MultipleChoiceQuestion next() throws NoSuchElementException {
        
        if (!hasNext()) { // if there are no more correct questions, throw an exception
            throw new NoSuchElementException("There are no more nodes with correct questions in this list");
        }
        while (!next.getData().isCorrect()) { // cycle through the incorrect questions
            next = next.getNext();
        }
        MultipleChoiceQuestion data = next.getData(); // get the data from the next correct question
        next = next.getNext(); // iterate
        return data;
    }
}
