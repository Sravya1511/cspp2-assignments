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
		if(this.choices[this.correctAnswer-1].equals(choice)){
			return true;
		}
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
	   boolean b = false;
		for(int i = 0; i<size; i++) {
			System.out.println(questions[i].getQuestionText());
			String[] list = questions[i].getResponse().split(" ");
			// System.out.println(questions[i].getCorrectAnswer());
			// System.out.println(Integer.parseInt(list[1]));

			if(!questions[i].evaluateResponse(questions[i].getResponse())){
				System.out.println(" Wrong Answer! - Penalty: "+questions[i].getPenalty());
				total += questions[i].getPenalty();

			}
			else {
				System.out.println(" Correct Answer! - Marks Awarded: "+questions[i].getMaxMarks());
				total += questions[i].getMaxMarks();

			}
		}
		System.out.println("Total Score: "+total);
	}
}
