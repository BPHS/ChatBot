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
		GeoTyChatBot bot = new GeoTyChatBot();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye")) {
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}
	
}