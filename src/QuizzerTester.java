import java.util.Arrays;

public class QuizzerTester {
    
    public static void main(String[] args) {
        System.out.println("testMultipleChoiceQuestion(): " + testMultipleChoiceQuestion());
        System.out.println("testLinkedNode(): " + testLinkedNode());
        System.out.println("testAddFirst(): " + testAddFirst());
        System.out.println("testAddLast(): " + testAddLast());
    }

    public static boolean runAllTests() {
        
        return false; // default return statement
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

    public static boolean testLinkedNode() {
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

        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
            "a1", "a2", "a3"
        }, 2, 1));

        test.addFirst(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        if (!test.getFirst().getData().getTitle().equals("TestCase2")) {
            return false;
        }
        else if (test.getFirst().getData().getTitle().equals("TestCase2")) {
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

        test.addFirst(new MultipleChoiceQuestion("TestCase1", "TestQ1", new String[] {
            "a1", "a2", "a3"
        }, 2, 1));

        test.addLast(new MultipleChoiceQuestion("TestCase2", "TestQ2", new String[]{
            "a1", "a2", "a3"
        }, 1, 2));

        if (!test.getLast().getData().getTitle().equals("TestCase2")) {
            return false;
        }
        else if (test.getLast().getData().getTitle().equals("TestCase2")) {
            return true;
        }
        return false;
    }
}
