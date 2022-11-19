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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListQuizzer implements Iterable<MultipleChoiceQuestion> {
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
            size++;
        }
        else if (index == this.size()) {
            LinkedNode<MultipleChoiceQuestion> toAdd = new LinkedNode<MultipleChoiceQuestion>(question);
            this.tail.setNext(toAdd);
            this.tail = toAdd;
            size++;
        }
        else {
            this.getNode(index-1).setNext(new LinkedNode<MultipleChoiceQuestion>(question, this.getNode(index-1).getNext()));
            size++;
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
        size++;
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
        size++;
    }
    /**
     * Returns the head of this ListQuizzer.
     * @return the head of this listQuizzer
     */
    public MultipleChoiceQuestion getFirst() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty");
        }
        return head.getData();
    }
    /**
     * Returns the tail of this ListQuizzer.
     * @return the tail of this ListQuizzer
     */
    public MultipleChoiceQuestion getLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty");
        }
        return tail.getData();
    }
    /**
     * Returns the MultipleChoiceQuestion at a specific index.
     * @param index the index of the question to return
     * @return The question at the specified index
     * @throws IndexOutOfBoundsException if index is negative or greater than or equal to the size of the ListQuizzer
     */
    public MultipleChoiceQuestion get(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size) { // handles bad input
            throw new IndexOutOfBoundsException("The index you passed into get was out of bounds");
        } 
        if (index == 0) { // returns head if the index is 0
            return head.getData();
        }
        else if (index == (size - 1)) { // returns the tail if the index passed is the last index
            return tail.getData();
        }
        else { // otherwise, loop through the nodes to return the correct one
            LinkedNode<MultipleChoiceQuestion> outputNode = head;
            for (int i = 0; i < index; i++) {
                outputNode = outputNode.getNext();
            }
            return outputNode.getData();
        }
    }
    /**
     * Removes the node at the specified index.
     * @param index the index of the node to be removed
     * @return the MultipleChoiceQuestion contained within the node to be removed
     * @throws IndexOutOfBoundsException if the passed index is negative or greater than or equal to the size of the list
     */
    public MultipleChoiceQuestion remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index to remove is out of bounds");
        }
        else if (index == 0 && size > 1) { // handles removing the head
            MultipleChoiceQuestion data = head.getData();
            head = head.getNext();
            size--;
            return data;
        }
        else if (index == 0 && size == 1) {
            MultipleChoiceQuestion data = head.getData();
            head = null;
            tail = null;
            size --;
            return data;
        }
        else if (index == (size - 1)) { // handles removing the tail
            MultipleChoiceQuestion data = tail.getData();
            tail = this.getNode(size - 2);
            tail.setNext(null);
            size--;
            return data;
        }
        else { // handles removing anything else
            MultipleChoiceQuestion data = this.getNode(index).getData();
            this.getNode(index-1).setNext(this.getNode(index).getNext());
            size--;
            return data;
        }
    }
    /**
     * Removes the first node in the list
     * @return the MultipleChoiceQuestion contained within the node to be removed
     * @throws NoSuchElementException if the list is empty
     */
    public MultipleChoiceQuestion removeFirst() throws NoSuchElementException{
        if (size <= 0) {
            throw new NoSuchElementException("The list is empty");
        }
        else {
            return this.remove(0);
        }
        
    }
    /**
     * Removes the last node in the list
     * @return the MultipleChoiceQuestion contained within the node to be removed
     * @throws NoSuchElementException if the list is empty
     */
    public MultipleChoiceQuestion removeLast() throws NoSuchElementException{
        if (size <= 0) {
            throw new NoSuchElementException("The list is empty");
        }
        else {
            return this.remove(size-1);
        }
        
    }
    /**
     * This methos calculates the score of the correctly answered questions in this ListQuizzer.
     * @return the int score of the correctly answered questions 
     */
    public int calculateScore() {
        int score = 0;
        for (int i = 0; i < size; i++) {
            if (this.get(i).isCorrect()) {
                score += this.get(i).getPointsPossible();
            }
        }
        return score;
    }
    /**
     * This method returns the number of possible points in this ListQuizzer
     * @return
     */
    public int calculateTotalPoints() {
        int possPoints = 0;
        for (int i = 0; i < size; i++) {
            possPoints += this.get(i).getPointsPossible();
        }
        return possPoints;
    }
    /**
     * Returns a deep copy of this ListQuizzer object
     * @return a ListQuizzer object that is a deep copy of this one
     */
    public ListQuizzer copy() {
        ListQuizzer output = new ListQuizzer();
        for (int i = 0; i < size; i++) {
            output.addLast(this.get(i).copy());
        }
        return output;
    }
    /**
     * Checks if a specified question is in the list
     * @param question the question to check for
     * @return true if the question is found, false otherwise
     */
    public boolean contains(MultipleChoiceQuestion question) {
        for (int i = 0; i < size; i++) {
            if (this.get(i).equals(question)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Clears the ListQuizzer.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

   private LinkedNode<MultipleChoiceQuestion> getNode(int index) {
        if (index < 0 || index >= size) { // handles bad input
            throw new IndexOutOfBoundsException("The index you passed into get was out of bounds");
        } 
        if (index == 0) { // returns head if the index is 0
            return head;
        }
        else if (index == (size - 1)) { // returns the tail if the index passed is the last index
            return tail;
        }
        else { // otherwise, loop through the nodes to return the correct one
            LinkedNode<MultipleChoiceQuestion> outputNode = head;
            for (int i = 0; i < index; i++) {
                outputNode = outputNode.getNext();
            }
            return outputNode;
        }
   }

   /**
   * Loads MultipleChoiceQuestions from a file
   * 
   * @author Jeff and Mouna
   * 
   * @param file file to read
   * @return the number of added MultipleChoiceQuestions to this list
   * @throws FileNotFoundException if the file is not found
   */
  public int loadQuestions(File file) throws FileNotFoundException {
    int loadedCount = 0; // count of loaded multiple choice questions
    int answerCount = 0; // count of possible answers per question
    int indexCorrectAnswer = 0; // index of the correct answer
    int points = 0; // possible points for a multiple choice question
    // try to read the file
    Scanner reader = null; // scanner to read the file line by line
    int lineNumber = 0; // number of the last read line

    try {
      reader = new Scanner(file);
      // parse the file lines - while loop to read parts of each multiple choice question
      while (reader.hasNextLine()) { // no more lines to read
        // read title
        String title = reader.nextLine();
        lineNumber++;

        // read question stem
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String question = reader.nextLine();
        lineNumber++;

        // read possible answers count
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String count = reader.nextLine();
        lineNumber++;
        // check the validity of count
        try {
          answerCount = Integer.parseInt(count.trim());
          if (answerCount <= 0 || answerCount > 10) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // count invalid - print an error message and return
          System.out
              .println("Syntax error! A positive integer less or equal to 10 is expected at line "
                  + lineNumber + (". Load questions operation interrupted!"));
          return loadedCount;
        }
        // valid count -> create the answerList array
        String[] answerList = new String[answerCount];
        int index = 0;
        while (index < answerCount && reader.hasNextLine()) {
          String answer = reader.nextLine();
          lineNumber++;
          answerList[index] = answer;
          index++;
        }

        // read index of the correct answer
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String line = reader.nextLine();
        lineNumber++;
        try { // check the validity of the index of the correct answer
          indexCorrectAnswer = Integer.parseInt(line.trim());
          if (indexCorrectAnswer < 0 || indexCorrectAnswer >= answerCount) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // indexCorrectAnswer invalid - print error and return
          System.out.println("Syntax error! A positive integer less than " + answerCount
              + " is expected at line " + lineNumber + (". Load questions operation interrupted!"));
          return loadedCount;
        }
        // valid index of the correct answer -> read possible points
        // read points
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        line = reader.nextLine();

        lineNumber++;
        try { // check the validity of the index of the correct answer
          points = Integer.parseInt(line.trim());

          if (points < 0) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // invalid points - print error message and return
          System.out.println("Syntax error! A positive integer for possible points "
              + " is expected at line " + lineNumber + (". Load questions operation interrupted!"));

          return loadedCount;
        }
          // create and add quizQuestion
          MultipleChoiceQuestion quizQuestion =
              new MultipleChoiceQuestion(title, question, answerList, indexCorrectAnswer, points);

          this.addLast(quizQuestion);
          loadedCount += 1;
          System.out.println("Question " + loadedCount + " loaded!");

      }
    } finally {
      if (reader != null)
        reader.close();
    }

    return loadedCount;
  }


  /**
   * Allows a user to take this quiz. The quiz should be taken on a deep copy of this ListQuizzer.
   * This method should not make any changes to the contents of this ListQuizzer.
   * 
   * @author Jeff and Mouna
   * 
   * @return the instance of ListQuizzer taken by the user. It should include the user's responses.
   */
  public ListQuizzer takeQuiz() {

    ListQuizzer copy = this.copy();
    copy.switchMode(ListingMode.ALL);
    Scanner input = new Scanner(System.in);
    for (MultipleChoiceQuestion question : copy) {
      System.out.println(question);
      System.out.print("Enter your answer: ");
      int entry = input.nextInt();
      question.setStudentAnswerIndex(entry - 1);
      if (question.isCorrect()) {
        System.out.println("Correct!");
      } else {
        System.out.println("Incorrect!");
      }
    }
    int correctPoints = copy.calculateScore();
    int totalPoints = copy.calculateTotalPoints();
    System.out.println("Your Score: " + correctPoints);
    System.out.println("Percentage: " + correctPoints / totalPoints);
    input.close();
    return copy;
  }

  /**
   * Returns true if o is a ListQuizzer which has the exact same contents as this ListQuizzer
   * 
   * @author Mouna
   *
   * @param o an object to compare with
   * @return true if o is instanceof ListQuizzer with the exact same contents as this ListQuizzer
   */
  @Override 
  public boolean equals(Object o) {
    if(o instanceof ListQuizzer) {
      ListQuizzer other = (ListQuizzer)o;
      if(this.size()!= other.size())
        return false;
      this.switchMode(ListingMode.ALL);
      other.switchMode(ListingMode.ALL);
      Iterator<MultipleChoiceQuestion> iterator = this.iterator();
      Iterator<MultipleChoiceQuestion> otherIterator = other.iterator();
      while(iterator.hasNext()) {
        if(!iterator.next().equals(otherIterator.next()))
          return false;
      }
      return true;
    }
    return false;
  }
  /**
   * Returns an iterator with the correct properties.
   */
  public Iterator<MultipleChoiceQuestion> iterator() {
    if (listingMode == ListingMode.ALL) {
        return new QuizQuestionsIterator(head);
    }
    else if (listingMode == ListingMode.CORRECT) {
        return new CorrectQuestionsIterator(head);
    }
    else {
        return new IncorrectQuestionsIterator(head);
    }
  }
    

}
