
class Quiz {
	Questions[] questions;
	String [] responses;
	int sizeres;
	int size;

	Quiz() {
		questions = new Questions[20];
		size = 0;
		sizeres = 0;
		responses = new String[4];

	}

	void addQuestion(Questions q) {
		questions[size++] = q;
	}

	// Questions getQuiz(Questions q) {
	// 	return q;
	// }
	void printQuestions(int i) {
		// if(questions[i]!=null)
			System.out.println(questions[i].question+ "("+questions[i].marks+")");
		System.out.println(questions[i].option1+"	"+questions[i].option2+"	"+questions[i].option3+"	"+questions[i].option4);
	    System.out.println("");
	}

	void addresponse(String m) {

		responses[sizeres++] = m;
	}

	void scoreReport() {
		int total = 0;
		for(int i = 0; i<size; i++) {
			System.out.println(questions[i].question);
			String[] list = responses[i].split(" ");
			if(list[1].equals("a")) {
				if(questions[i].optioncorrect == 1) {
				System.out.println(" Correct Answer! - Marks Awarded: "+questions[i].marks);
				total += questions[i].marks;
			    }
			}
			if(list[1].equals("b")) {
				if(questions[i].optioncorrect == 2) {
				System.out.println(" Correct Answer! - Marks Awarded: "+questions[i].marks);
				total += questions[i].marks;
			    }
			}
			if(list[1].equals("c")) {
				if(questions[i].optioncorrect == 3) {
				System.out.println(" Correct Answer! - Marks Awarded: "+questions[i].marks);
				total += questions[i].marks;
			    }
			}
			if(list[1].equals("d")) {
				if(questions[i].optioncorrect == 4) {
				System.out.println(" Correct Answer! - Marks Awarded: "+questions[i].marks);
				total += questions[i].marks;
			    }
			}

			else if(questions[i].optioncorrect == (Integer.parseInt(list[1]))) {
				System.out.println(" Correct Answer! - Marks Awarded: "+questions[i].marks);
				total += questions[i].marks;
			}
			else {
				System.out.println(" Wrong Answer! - Penalty: "+questions[i].penalty);
				total += questions[i].penalty;
			}
		}
        System.out.println("Total Score: "+total);
	}

}

class Questions {
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	int optioncorrect;
	int marks;
	int penalty;

	Questions(String q, String a, String b, String c, String d, int r, int m, int p) {
		this.question = q;
		this.option1 = a;
		this.option2 = b;
		this.option3 = c;
		this.option4 = d;
		this.optioncorrect = r;
		this.marks = m;
		this.penalty = p;
	}


}
