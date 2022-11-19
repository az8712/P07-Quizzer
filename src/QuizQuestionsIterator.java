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

public class QuizQuestionsIterator implements Iterator<MultipleChoiceQuestion> {
    private LinkedNode<MultipleChoiceQuestion> next; // refers to the next node in the list

    /**
     * constructs a new QuizQuestionsIterator
     * @param startNode the node to start iteration from
     */
    public QuizQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
        next = startNode;
    }
    /**
     * checks if there is a next node
     * @return true if there is, false otherwise
     */
    public boolean hasNext() {
        return next != null; // if there is no next node, return false
    }   
    /**
     * Returns the next MultipleChoiceQuestion
     * @return the next MultipleChoiceQuestion
     */
    public MultipleChoiceQuestion next() {   
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot continue iterating through the list as there are no more questions");
        }
        MultipleChoiceQuestion data = next.getData(); // get data from the next question
        next = next.getNext(); // go to the next question
        return data;
    }
}
