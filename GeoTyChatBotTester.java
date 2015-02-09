import java.util.*;
import java.io.*;

/**
 * Class to run geo+tyler chatbot
 * Brought to you by geo and tyler
 * 
 */
public class GeoTyChatBotTester {
	
	private static final String BAR = "************************************";
	/**
	 * Create a ChatBot, give it user input, and print its replies.
	 */
	public static void main(String[] args) {
	    
		
		int totalCorrect = 0;
		int questionsAsked = 0;
		
		GeoTyChatBot triviaBot = new GeoTyChatBot ();
		Scanner scanner = new Scanner (System.in);
		
		String runProgram = triviaBot.getIntro();
		
		while (runProgram.equalsIgnoreCase("yes") || runProgram.equalsIgnoreCase("y")){
			int category = -1; // nothing selected yet
			String answer = "";
        	System.out.println (BAR);
        	System.out.println ("What type of trivia would you like?");
        	System.out.println ("\t\t1. Movies");
        	System.out.println ("\t\t2. Math");
        	System.out.println ("\t\t3. History");
        	System.out.println (BAR);
        	System.out.print("Please select 1, 2, or 3: ");
        	try {
            	category=scanner.nextInt();
        	}
        	catch (Exception e) {
        		System.out.println(e.toString());
        	}
            triviaBot.setCategory(category);
            triviaBot.setMovieLineIndex();
            triviaBot.setMovieAnswer();
            triviaBot.setHistoryLineIndex();
            triviaBot.setHistoryAnswer();
            triviaBot.setMathLineIndex();
            triviaBot.setMathAnswer();
            System.out.print(triviaBot.askTriviaQuestion(category)+"\n");
            try {
            	Scanner in = new Scanner(System.in);
            	answer = in.nextLine();
            } catch (Exception e) {
            	System.out.println(e.toString());
            }
            
            if (triviaBot.isCorrect(answer)) {
            	totalCorrect++;
            	questionsAsked++;
            	System.out.println();
            	triviaBot.showMessageCorrect();
            } else {
            	questionsAsked++;
            	System.out.println();
            	triviaBot.showMessageInCorrect();
            }
            
            System.out.println(BAR);
            System.out.print("So far I have asked you " + questionsAsked + " questions.");
            System.out.println(" You have answered " + totalCorrect + " questions correctly!");
            System.out.println(BAR);
            System.out.println();
           
            runProgram = triviaBot.runAgain();
            
	
		}
	}
}