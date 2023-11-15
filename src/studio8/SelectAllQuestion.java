package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {

	
	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		//Hint: 1 point per choice
		//FIXME
		super(prompt, answer, choices.length, choices);

	}
	
	public int checkAnswer(String givenAnswer) {
		//FIXME Should return partial credit (if earned)!
		int credits = super.getPoints();
		
//		for(int i = 0; i < givenAnswer.length(); i++) {
//			if(givenAnswer.charAt(i) != '1' || givenAnswer.charAt(i) != '3') {
//				credits --;
//			}
//		}
		
		if(givenAnswer.contains("1") == false) {
			credits --;	
		}
		if(givenAnswer.contains("3") == false) {
			credits --;
		}
		if(givenAnswer.contains("2") == true) {
			credits --;
		}
		if(givenAnswer.contains("4") == true) {
			credits --;
		}
		
		return credits;
	}
	
	public static void main(String[] args) {
		String[] choices = {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);
		selectAll.displayPrompt();
		System.out.println(selectAll.checkAnswer("hi")); //no credit
		System.out.println(selectAll.checkAnswer("13")); //full credit
		System.out.println(selectAll.checkAnswer("31")); //full credit
		System.out.println(selectAll.checkAnswer("1")); //3 points
		System.out.println(selectAll.checkAnswer("3")); //3 points -1 for no 1
		System.out.println(selectAll.checkAnswer("23")); //2 points -1 for 2, -1 for no 1
		System.out.println(selectAll.checkAnswer("34")); //2 points -1 for 4, -1 for no 1
		System.out.println(selectAll.checkAnswer("4")); //1 point -1 for 4, -1 for no 1, -1 for no 3
		System.out.println(selectAll.checkAnswer("124")); //1 point
		System.out.println(selectAll.checkAnswer("24")); //0 points
		
	}
}
