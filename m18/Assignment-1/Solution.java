import java.util.Scanner;
// import java.util.*;

/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
        // static int[] responses;
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s,
        final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        int x = 0;
        final int three = 3;
        final int four = 4;
        final int nine = 9;
        if (questionCount == 0) {
            System.out.println("Quiz does not have questions");
        } else {
        for (int i = 0; i < questionCount; i++) {
            String sen = s.nextLine();
            String[] list1 = sen.split(":");
            String[] list2 = list1[1].split(",");
            x = list1.length + list2.length;
 quiz.addQuestion(new Questions(list1[0], list2[0],
    list2[1], list2[2], list2[three], Integer.parseInt(list1[2]),
    Integer.parseInt(list1[three]), Integer.parseInt(list1[four])));
        }
        if (x == nine) {
        System.out.println(questionCount + " are added to the quiz");
        } else {
            System.out.println("Error! Malformed question");
        }
    }

    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
public static void startQuiz(final Scanner s,
    final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        // responses  = new int[answerCount];


        // System.out.println(quiz.question);
        final int four = 4;
        for (int i = 0; i < four; i++) {
            quiz.printQuestions(i);
            String m = s.nextLine();
            quiz.addresponse(m);
        }
    }

    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report

      quiz.scoreReport();
    }
}
