import java.util.Scanner;
/**
 * Solution class for code-eval.
 */
public final class Solution {
	 /**
	 * Constructs the object.
	 */
	static boolean b = false;
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
		 // code to read the test cases input file
		Scanner s = new Scanner(System.in);
		// check if there is one more line to process
		while (s.hasNext()) {
			// read the line
			String line = s.nextLine();
			 // split the line using space
			String[] tokens = line.split(" ");
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
		final int five = 5;
		if (q == 0) {
			System.out.println("Quiz does not have questions");
				b = true;
		} else {
		for (int i = 0; i < q; i++) {
			String sen = scan.nextLine();
			String[] list1 = sen.split(":");
			String[] list2 = list1[1].split(",");
			if (list2.length < 2) {
				b = true;
System.out.println("trick question  does not have enough answer choices");
				return;
			}
			// String [] list3 = {list2[0], list2[1], list2[2], list2[three]};
			if (list1.length < five) {
				b = true;
				System.out.println("Error! Malformed question");
				return;
			}
			if (Integer.parseInt(list1[2]) > four) {
				b = true;
System.out.println("Error! Correct answer choice number is out of range for question text 1");
				return;
			}
			if (Integer.parseInt(list1[three]) < 0) {
				b = true;
System.out.println("Invalid max marks for " + list1[0]);
				return;
			}
			if (Integer.parseInt(list1[four]) > 0) {
				b = true;
System.out.println("Invalid penalty for " + list1[0]);
				return;
			}
			if (list1[0].equals("")) {
				b = true;
				System.out.println("Error! Malformed question");
                return;
			}

			x = list1.length + list2.length;
 quiz.addQuestion(new Question(list1[0], list2, Integer.parseInt(list1[2]),
	Integer.parseInt(list1[three]), Integer.parseInt(list1[four])));
		}
		System.out.println(q + " are added to the quiz");

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


		// store the user respone in the question object
		final int four = 4;
		if (b) {
			return;
		} else {
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
		if (b) {
			return;
		} else {
			quiz.showReport();
		}
	}
}
