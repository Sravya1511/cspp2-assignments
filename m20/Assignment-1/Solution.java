import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
	/**
	 * { var_description }.
	 */
	private String questiontext;
	/**
	 * { var_description }.
	 */
	private String[] choices;
	/**
	 * { var_description }.
	 */
	private int correctAnswer;
	/**
	 * { var_description }.
	 */
	private int maxMarks;
	/**
	 * { var_description }.
	 */
	private int penalty;
	/**
	 * { var_description }.
	 */
	private String response;
	/**
	 * Constructs the object.
	 */
	Question() {

	}
	/**
	 * Constructs the object.
	 *
	 * @param      question1       The question 1
	 * @param      choices1        The choices 1
	 * @param      correctAnswer1  The correct answer 1
	 * @param      maxMarks1       The maximum marks 1
	 * @param      penalty1        The penalty 1
	 */
	Question(final String question1, final String[] choices1,
		final int correctAnswer1, final int maxMarks1, final int penalty1) {
		this.questiontext = question1;
		this.choices = choices1;
		this.correctAnswer = correctAnswer1;
		this.maxMarks = maxMarks1;
		this.penalty = penalty1;
	}
	/**
	 * { function_description }.
	 *
	 * @param      choice  The choice
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean evaluateResponse(final String choice) {
		return false;
	}
	/**
	 * Gets the correct answer.
	 *
	 * @return     The correct answer.
	 */
	public int getCorrectAnswer() {
		return this.correctAnswer;
	}
	/**
	 * Gets the question text.
	 *
	 * @return     The question text.
	 */
	public String getQuestionText() {
		return this.questiontext;
	}
	/**
	 * Gets the choice.
	 *
	 * @return     The choice.
	 */
	public String[] getChoice() {
		return this.choices;
	}
	/**
	 * Gets the maximum marks.
	 *
	 * @return     The maximum marks.
	 */
	public int getMaxMarks() {
		return this.maxMarks;
	}
	/**
	 * Gets the penalty.
	 *
	 * @return     The penalty.
	 */
	public int getPenalty() {
		return this.penalty;
	}
	/**
	 * Sets the response.
	 *
	 * @param      answer  The answer
	 */
	public void setResponse(final String answer) {
		 response = answer;
	}
	/**
	 * Gets the response.
	 *
	 * @return     The response.
	 */
	public String getResponse() {
		return this.response;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String s = "";
		return s;
	}
}
/**
 * Class for quiz.
 */
class Quiz {
	/**
	 * { var_description }.
	 */
	private final int onehundred = 100;
	/**
	 * { var_description }.
	 */
	private Question[] questions;
	/**
	 * { var_description }.
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	Quiz() {
		questions = new Question[onehundred];
		size = 0;

	}
	/**
	 * Adds a question.
	 *
	 * @param      q     The question
	 */
	public void addQuestion(final Question q) {
		questions[size++] = q;

	}
	/**
	 * Gets the question.
	 *
	 * @param      index  The index
	 *
	 * @return     The question.
	 */
	public Question getQuestion(int i) {
		return this.questions[i];

	}

	public void printQuestion(int i) {
		System.out.println(questions[i].getQuestionText()+ "("+questions[i].getMaxMarks()+")");
		for(int j = 0; j<questions[i].getChoice().length-1; j++) {
			System.out.print(questions[i].getChoice()[j]+"	");
		}
		System.out.print(questions[i].getChoice()[questions[i].getChoice().length-1]);
		System.out.println("");
		System.out.println("");
	}
	/**
	 * Shows the report.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public void showReport() {
	   int total = 0;
		for(int i = 0; i<size; i++) {
			System.out.println(questions[i].getQuestionText());
			String[] list = questions[i].getResponse().split(" ");
			// System.out.println(questions[i].getCorrectAnswer());
			// System.out.println(Integer.parseInt(list[1]));

			if(questions[i].getCorrectAnswer() == (Integer.parseInt(list[1]))) {
				System.out.println(" Correct Answer! - Marks Awarded: "+questions[i].getMaxMarks());
				total += questions[i].getMaxMarks();
			}
			else {
				System.out.println(" Wrong Answer! - Penalty: "+questions[i].getPenalty());
				total += questions[i].getPenalty();
			}
		}
		System.out.println("Total Score: "+total);
	}
}

/**
 * Solution class for code-eval.
 */
public final class Solution {
	 /**
	 * Constructs the object.
	 */
	static boolean b = false;
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
	 * @param      scan       The scan
	 * @param      quiz       The quiz
	 * @param      q          The question count
	 *
	 */
	public static void loadQuestions(final Scanner scan,
		final Quiz quiz, final int q) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		int x = 0;
		final int three = 3;
		final int four = 4;
		final int nine = 9;
		if (q == 0) {
			System.out.println("Quiz does not have questions");
				b = true;
		} else {
		for (int i = 0; i < q; i++) {
			String sen = scan.nextLine();
			String[] list1 = sen.split(":");
			String[] list2 = list1[1].split(",");
			if(list2.length < 2) {
				b = true;
				System.out.println("trick question  does not have enough answer choices");
				return;
			}
			String [] list3 = {list2[0], list2[1], list2[2], list2[three]};
			if(list1.length < 5) {
				b = true;
				System.out.println("Error! Malformed question");
				return;
			}
			if(Integer.parseInt(list1[2]) > 4) {
				b = true;
				System.out.println("Error! Correct answer choice number is out of range for question text 1");
				return;
			}

			x = list1.length + list2.length;
 quiz.addQuestion(new Question(list1[0], list2, Integer.parseInt(list1[2]),
	Integer.parseInt(list1[three]), Integer.parseInt(list1[four])));
		}

		if (x == nine) {
		System.out.println(q+ " are added to the quiz");
		} else {
			System.out.println("Error! Malformed question");
		}
	}

	}
	/**
	 * Starts a quiz.
	 *
	 * @param      scan  The scan
	 * @param      quiz  The quiz
	 * @param      q     The answer count
	 */
	public static void startQuiz(final Scanner scan,
		final Quiz quiz, final int q) {
		// write your code here to display the quiz questions on the console.
		// read the user responses from the console using scanner object.
		// store the user respone in the question object
		final int four = 4;
		if(b == true) {
			return;
		}
		else {
		for (int i = 0; i < q; i++) {
			quiz.printQuestion(i);
			String m = scan.nextLine();
			quiz.getQuestion(i).setResponse(m);
		}
	   }
	}
	/**
	 * Displays the score report.
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report using quiz object.
		if(b == true) {
			return;
		}
		else {
			quiz.showReport();
		}
	}
}

