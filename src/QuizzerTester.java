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
import java.util.Arrays;
import java.util.NoSuchElementException;

import java.util.Iterator;

public class QuizzerTester {
    
    /**
     * This method runs the other methods in this class
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("runAllTests(): " + runAllTests());
    }
    /**
     * This method runs all the tests in this class
     * @return true if all tests return true, false otherwise
     */
    public static boolean runAllTests() {
        
        return (testMultipleChoiceQuestion() && testLinkedNode() && testAddFirst() && testAddLast() && testAdd() 
            && testGet() && testRemove() && testRemoveFirst() && testRemoveLast() && testQuizQuestionsIterator()
            && testCorrectQuestionsIterator() && testIncorrectQuestionsIterator()); // default return statement
    }
    /**
     * This method tests whether or not the MultipleChoiceQuestion constructor works as intended
     * @return true if everything works as intended, false otherwise
     */
    public static boolean testMultipleChoiceQuestion() {
        // first, test cases with bad arguments
        try {
            MultipleChoiceQuestion answerIndexBad = new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
                "a1", "a2", "a3"
            }, 4, 1);
            return false;
        }
        catch (IndexOutOfBoundsException e) { }
        catch (Exception e) {
            System.out.println(e.getMessage() + " (in testMultipleChoiceQuestion answerIndexBad test)");
            return false;
        }
        try {
            MultipleChoiceQuestion badPossiblePoints = new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
                "a1", "a2", "a3"
            }, 1, 0);
            return false;
        }
        catch (IllegalArgumentException e) { }
        catch (Exception e) {
            System.out.println(e.getMessage() + " (in testMultipleChoiceQuestion pointsPossibleBad test)");
            return false;
        }

        // test if the MultipleChoiceQuestion is created correctly
        MultipleChoiceQuestion testDataInput = new MultipleChoiceQuestion("test3", "testQ3", new String[]{
            "a1", "a2", "a3"
        }, 2, 5);

        if (!testDataInput.getTitle().equals("test3")) {
            return false;
        }
        if (!testDataInput.getQuestion().equals("testQ3")) {
            return false;
        }

        String s = "";
        String[] answers = new String[]{"a1", "a2", "a3"};
        for (int i = 1; i <= 3; i++) {
            s += i + ". " + answers[i-1] + "\n";
        }
        s = s.trim();

        if (!testDataInput.getAnswers().equals(s)) {
            System.out.println(testDataInput.getAnswers());
            System.out.println(s);
            return false;
        }
        if (testDataInput.getCorrectAnswerIndex() != 2) {
            return false;
        }
        if (testDataInput.getPointsPossible() != 5) {
            return false;
        }
        if (testDataInput.getStudentAnswerIndex() != -1) {
            return false;
        }
        
       
        
        String questionText = "QUESTION TITLE: " + "\"" + "test3" + "\"" + "\n" + "Question:\n"
        + "testQ3" + "\n" + "Available Answers:\n" + s;
        questionText = questionText.trim();

        if (!testDataInput.toString().equals(questionText)) {
            return false;
        }


        MultipleChoiceQuestion testEquals = new MultipleChoiceQuestion("test3", "testQ3", new String[]{
            "a1", "a2", "a3"
        }, 2, 5);

        if (!testDataInput.equals(testEquals)) {
            return false;
        }
        return true;
        
    }
    /**
     * This method tests the functionality of the LinkedNode class.
     * @return true if the class works as expected, false otherwise
     */
    public static boolean testLinkedNode() {
        try {
            LinkedNode<String> noDataTest1 = new LinkedNode<String>(null);
            return false;
        }
        catch (NullPointerException e) { }
        catch (Exception e) {
            return false;
        }

        try {
            LinkedNode<String> noDataTest2 = new LinkedNode<String>(null, new LinkedNode<String>("efe"));
            return false;
        }
        catch (NullPointerException e) { }
        catch (Exception e) {
            return false;
        }



        LinkedNode<String> noNextTest = new LinkedNode<String>("test with no next node");
        if (!noNextTest.toString().equals(noNextTest.getData().toString())) {
            System.out.println("Linked node with no next node returns incorrect toString output");
            return false;
        }
        if (!noNextTest.getData().equals("test with no next node")) {
            System.out.println("LinkedNode does not return correctly when getData is called");
            return false;
        }
        if (noNextTest.getNext() != null) {
            System.out.println("node with no next node does not return null when getNext is called");
            return false;
        }
        noNextTest.setNext(new LinkedNode<String>("this is another test node"));
        if (!noNextTest.getNext().getData().equals("this is another test node")) {
            System.out.println("LinkedNode setNext is not working as expected");
            return false;
        }
        

        return true;
    }
    /**
     * Tests the functionality of ListQuizzer's addFirst method.
     * @return true if the addFirst method works as intended, false otherwise
     */
    public static boolean testAddFirst() {
        ListQuizzer test = new ListQuizzer();

        try {
            test.addFirst(null);
            return false;
        }
        catch (NullPointerException e) { }
        catch (Exception e) {
            return false;
        }
        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
            "a1", "a2", "a3"
        }, 2, 1));

        test.addFirst(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        if (!test.getFirst().getTitle().equals("TestCase2")) {
            return false;
        }
        else if (test.getFirst().getTitle().equals("TestCase2")) {
            return true;
        }
        return false;
    }    
    /**
     * Tests the functionality of ListQuizzer's addLast method.
     * @return true if the method works as intended, false otherwise.
     */
    public static boolean testAddLast() {
        ListQuizzer test = new ListQuizzer();

        try {
            test.addLast(null);
            return false;
        }
        catch (NullPointerException e) { }
        catch (Exception e) {
            return false;
        }

        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        if (!test.getLast().getTitle().equals("TestCase2")) {
            return false;
        }
        else if (test.getLast().getTitle().equals("TestCase2")) {
            return true;
        }
        return false;
    }
    /**
     * Tests the functionality of ListQuizzer's get method
     * @return true if the method works as intended, false otherwise
     */
    public static boolean testGet() {
        ListQuizzer test = new ListQuizzer();

        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase3", "TestQ3", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        if (!test.get(0).getTitle().equals("TestCase1")) {
            System.out.println("e");
            return false;
        }
        else if (!test.get(2).getTitle().equals("TestCase3")) {
            return false;
        }
        return true;
    }
    /**
     * Tests the functionality of ListQuizzer's add method
     * @return true if the method works as intended, false otherwise
     */
    public static boolean testAdd() {
        ListQuizzer test = new ListQuizzer();

        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase3", "TestQ3", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));


        try {
            test.add(0, null);
            return false;
        }
        catch (NullPointerException e) { }
        catch (Exception e) {
            return false;
        }

        try {
            test.add(3132323, new MultipleChoiceQuestion("TestCase5", "TestQ5", new String[]{
                "a1", "a2", "a3"
            }, 1, 2));
            return false;
        }
        catch (IndexOutOfBoundsException e) { }
        catch (Exception e) {
            return false;
        }

        test.add(1, new MultipleChoiceQuestion("TestCase4", "TestQ4", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        if (!test.get(1).getTitle().equals("TestCase4")) {
            return false;
        }
        return true;
    }
    /**
     * Tests the functionality of the remove method in the ListQuizzer class
     * @return true if the method works as intended, false otherwise
     */
    public static boolean testRemove() {
        ListQuizzer test = new ListQuizzer();

        try {
            test.remove(0);
            return false;
        }
        catch (IndexOutOfBoundsException e) {
        }
        catch (Exception e) {
            return false;
        }
        // add nodes to the list
        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase3", "TestQ3", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.add(1, new MultipleChoiceQuestion("TestCase4", "TestQ4", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

       
        // remove node
        
        try {
            test.remove(2133123123);
            return false;
        }
        catch (IndexOutOfBoundsException e) { }
        catch (Exception e) {
            return false;
        } 

        

        test.remove(1);
    

        // test if everything worked correctly
        if (test.size() != 3) {
            System.out.println(test.size());
            return false;
        }
        if (!test.get(1).getTitle().equals("TestCase2")) {
            return false;
        }
        return true;
    }
    /**
     * Tests the functionality of the removeFirst method in ListQuizzer
     * @return true if the method works as intended, false otherwise
     */
    public static boolean testRemoveFirst() {
        ListQuizzer test = new ListQuizzer();

        try {
            test.removeFirst();
            return false;
        }
        catch (NoSuchElementException e) { }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        // add nodes to the list
        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase3", "TestQ3", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.add(1, new MultipleChoiceQuestion("TestCase4", "TestQ4", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

       

        // remove the first node
        test.removeFirst();

        // check if it was done correctly
        if (test.size() != 3) {
            System.out.println(test.size());
            return false;
        }
        if (!test.get(0).getTitle().equals("TestCase4")) {
            return false;
        }
        return true;
    }
    /**
     * Tests the functionality of the removeLast method in ListQuizzer
     * @return true if the method works as intended, false otherwise
     */
    public static boolean testRemoveLast() {
        ListQuizzer test = new ListQuizzer();

        try {
            test.removeLast();
            return false;
        }
        catch (NoSuchElementException e) { }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        // add nodes to the list
        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase3", "TestQ3", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.add(1, new MultipleChoiceQuestion("TestCase4", "TestQ4", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

       

        // remove the first node
        test.removeLast();

        // check if it was done correctly
        if (test.size() != 3) {
            System.out.println(test.size());
            return false;
        }
        if (!test.getLast().getTitle().equals("TestCase2")) {
            return false;
        }
        return true;
    }
    /**
     * This method test the functionality of the QuizQuestionsIterator.
     * @return true if the method works as intended, false otherwise
     */
    public static boolean testQuizQuestionsIterator() {
        ListQuizzer test = new ListQuizzer();

        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] { // add elements to the list
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase3", "TestQ3", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase4", "TestQ4", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));


        Iterator<MultipleChoiceQuestion> testIter = test.iterator(); // create an iterator

        MultipleChoiceQuestion[] list = new MultipleChoiceQuestion[]{ // create an array to compare the iterator results with
            new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
                "a1", "a2", "a3"
            }, 2, 1),
            new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
                "a1", "a2", "a3"
            }, 1, 2),
            new MultipleChoiceQuestion("TestCase3", "TestQ3", new String[]{
                "a1", "a2", "a3"
            }, 1, 2),
            new MultipleChoiceQuestion("TestCase4", "TestQ4", new String[]{
                "a1", "a2", "a3"
            }, 1, 2)
        };

        boolean returnsCorrectly = true;

        for (int i = 0; i < list.length; i++) {
            if (!list[i].equals(testIter.next()))
            {
                returnsCorrectly = false;
            }
        }

        return returnsCorrectly;
    }
    /**
     * this method checks the functionality of the CorrectQuestionsIterator
     * @return true if it works as intended, false otherwise
     */
    public static boolean testCorrectQuestionsIterator() {
        ListQuizzer test = new ListQuizzer();

        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] { // add elements to the list
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase3", "TestQ3", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase4", "TestQ4", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.switchMode(ListingMode.CORRECT); // switch listing mode
        Iterator<MultipleChoiceQuestion> testIter = test.iterator(); // create an iterator

        if (testIter.hasNext()) {
            return false;
        }
        return true;
    }
    /**
     * this method checks the functionality of the IncorrectQuestionsIterator
     * @return true if it works as intended, false otherwise
     */
    public static boolean testIncorrectQuestionsIterator() {
        ListQuizzer test = new ListQuizzer();

        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] { // add elements to the list
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase3", "TestQ3", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.addLast(new MultipleChoiceQuestion("TestCase4", "TestQ4", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        test.switchMode(ListingMode.INCORRECT); // switch listing mode
        Iterator<MultipleChoiceQuestion> testIter = test.iterator(); // create an iterator

        if (!testIter.hasNext()) { // if no incorrect questions are found, return false
            return false;
        }
        return true;
    }


}
