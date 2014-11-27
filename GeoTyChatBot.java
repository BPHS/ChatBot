
//import java.io.*;
import java.util.Scanner;
import java.util.Random;


/** 
 * George and tyler created this simple chat bot,
 * in hopes that one day it will grow to be something
 * really big. Or until we start building games.
 * 
 * This program will ask the user trivia questions based on
 * three different categories (math, history, movies). If the
 * user gets wrong answer, bot will give a second try. If
 * still wrong after 2nd attempt, the bot will then provide answer.
 * 
 * The bot will also keep a running tally of how many questions were
 * asked and how many questions were answered correctly.
 * 
 */
 
 public class GeoTyChatBot{

    Scanner scanner=new Scanner(System.in);
    private String answer;
    private String response;
    private String category;
    private String triviaQuestion;
    private final int MOVIES = 1;
    private final int MATH = 2;
    private final int HISTORY = 3;
     /**

      * Get greeting of the bot
      * @return answer ; the response of the user
      */
     
    public String getIntro(){
        System.out.print("Hi there, my name is Trivia Bot!\nThink you can beat me in a" +
                "game of trivia? (Yes/No): ");
        try {
            answer=scanner.nextLine();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return answer;
    }
    
    public String runAgain() {
        String answer = "";
        System.out.print("Would you like to try your luck in another game? (Yes or No): ");
        try {
            answer=scanner.nextLine();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return answer;
    }
    
    //TODO: move the questions into an array that can be selected from randomly
    //      this needs to be in sync with the answer key
    public String askTriviaQuestion(int category){
        String question = "";
        if (category == MOVIES) {
                    question = "Who was the lead actor in Rocky 4?";
            
        } else if (category == MATH) {
            
            question = "What is 2 + 2 * 3 / 2 = ";
            
        } else if (category == HISTORY) {
            
            question = "Who was the first name of the first president of the United States: ";
            
        }
        else {
            question = "Sorry I do not support that category yet. Pick another one :)";
        }

        return question;
    }


    // TODO: needs to be built, this is a stub only to simulate game play.
    public boolean isCorrect(String answer) {
        Random random = new Random();
        int r = random.nextInt();
        if (r % 2 == 0)
            return true;
        else
            return false;
    }

    // TODO: make this a cool message
    //       this should have many different fun messages that 
    //       denote the user was correct to make this fun
    public void showMessageCorrect() {
        System.out.println("You are amazing, this a correct!!");
    }
    
    // TODO: make this a cool message too...
    //       this should have many different fun messages that 
    //       denote the user was incorrect to make this fun
    
    // Didnt edit because we are doing seperate docs for answers and Questions
    public void showMessageInCorrect() {
        
        
    }
}


