import java.util.Arrays;

public class QuizzerTester {
    
    public static void main(String[] args) {
        System.out.println(testMultipleChoiceQuestion());
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
}
