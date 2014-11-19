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
		
		System.out.println (bot.getGreeting());
		Scanner scanner = new Scanner (System.in);
		String statement = scanner.nextLine();
		
		while (!statement.equals("Bye")) {
			System.out.println (bot.getResponse(statement));
			statement = scanner.nextLine();
		}
		while (statement.equals("Bye")) {
			System.out.println ("See you later!");
		}
	}
	
}