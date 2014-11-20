import java.util.Scanner;

/**
 * Class to run geo+tyler chatbot
 * Brought to you by geo and tyler
 * 
 */
public class GeoTyChatBotTester {

	/**
	 * Create a ChatBot, give it user input, and print its replies.
	 */
	public static void main(String[] args) {
		
		GeoTyChatBot TriviaBot = new GeoTyChatBot ();
		Scanner scanner = new Scanner (System.in);
		
		String answer=TriviaBot.getIntro();
		
		
		while (answer.equalsIgnoreCase("yes")){
        	System.out.println ("What type of trivia would you like to do?");
        	System.out.println ("Movie,History, or Math");
            answer = scanner.nextLine ();
	
		}
	}
}