import java.util.*;
import java.io.*;

/**
 * Class to run geo+tyler chatbot
 * Brought to you by geo and tyler
 * with a guiding hand of Billy 
 * Eipp (THE MAN, THE MYTH, THE LEGEND)
 */
public class GeoTyChatBotTester {
	
	private static final String BAR = "************************************";
	/**
	 * Create a ChatBot, give it user input, and print its replies.
	 */
	public static void main(String[] args) {
	    
/**integers to keep track of the users score
 */
 
		int totalCorrect = 0;
		int questionsAsked = 0;
		
/**create an instance of the triviabot object
 */
 
		GeoTyChatBot triviaBot = new GeoTyChatBot ();
		
/**A scanner to allow user input
 */
 
		Scanner scanner = new Scanner (System.in);
		
/**Create a string which holds the value of the getIntro method.
 *(Whether or not the user thinks they can beat the trivia bot)
 */
 
		String runProgram = triviaBot.getIntro();

/**A while loop to run the trivia bot while the user's answer to keep going is yes
 */
 
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
        	
/**Set the category equal to user choice
 */
 
        	try {
            	category=scanner.nextInt();
        	}
        	catch (Exception e) {
        		System.out.println(e.toString());
        	}

/**Call all methods in trivia bot object, to establish category, indexs, and
 * questions/answers
 */
 
            triviaBot.setCategory(category);
            triviaBot.setMovieLineIndex();
            triviaBot.setMovieAnswer();
            triviaBot.setHistoryLineIndex();
            triviaBot.setHistoryAnswer();
            triviaBot.setMathLineIndex();
            triviaBot.setMathAnswer();

/**Call the askTriviaQuestion method, while passing in the category,
 * to ask the user a question based around the category.
 */
 
            System.out.print(triviaBot.askTriviaQuestion(category)+"\n");

/**Set the users input equal to their answer
 */
 
            try {
            	Scanner in = new Scanner(System.in);
            	answer = in.nextLine();
            } catch (Exception e) {
            	System.out.println(e.toString());
            }

/**Check to see if the users answer is correct, 
 * by calling the isCorrect method, and passing in the user's
 * answer. If right, calls correctMessage method and increases the user's
 * number correct, as well as questions asked. If wrong, will 
 * call the inCorrect message method, and increase number 
 * of questions asked.
 */
 
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
            
/**Prints out a banner, as well as a statement showing the user's
 * total correct against the total number of questions
 * asked.
 */
 
            System.out.println(BAR);
            System.out.print("So far I have asked you " + questionsAsked + " questions.");
            System.out.println(" You have answered " + totalCorrect + " questions correctly!");
            System.out.println(BAR);
            System.out.println();

/**Calls the runAgain method, to see if the user wants to
 * contnue playing the bot. If answer is no, the user will be shown their score.
 */
           
            runProgram = triviaBot.runAgain();
            }
            if(runProgram.equalsIgnoreCase("no") || runProgram.equalsIgnoreCase("n")){
                System.out.println("Your final score is: "+(((double)totalCorrect)/((double)questionsAsked))*100 +"%");
		    
	    }
	}
}