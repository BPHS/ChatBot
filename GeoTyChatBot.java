
import java.io.*;
import java.util.*;


/** 
 * George and tyler created this simple chat bot,
 * in hopes that one day it will grow to be something
 * really big. Or until we start building games.
 * 
 * A code that will ask the user trivia questions based on
 * three different categories (math, history, movies). If
 * user gets wrong answer, bot will give a second try. If
 * still wrong after 2nd attempt, the bot will then provide answer.
 * 
 */
 
 public class GeoTyChatBot{

    Scanner scanner=new Scanner(System.in);
    private String answer;
    private String response;
    
    /**
     Scanner scanner = new Scanner (System.in);
     
     /**

      * Get greeting of the bot
      * @return answer ; the response of the user
      */
     

    public String getIntro(){
        System.out.println("Hi there, my name is Trivia Bot. Think you can beat me in a" +
                "game of trivia?(Yes/No)");
        answer=scanner.nextLine();
        return answer;
    }
    
    
    public String getResponse(String statement) {
            String response="";
            
            
            
            
            
            
            
            
            
    
        return response;
    }

      // public String getResponse(String statement) {
        //String response="";
        
        
      //}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

     /*private String getRandomResponse () {

   

         final int number_of_responses = 10;
         double r = Math.random();
         int whichResponse = (int)(r * number_of_responses);
         String response = "";
         
         if (whichResponse == 0) {
             response = "That cool, tell me more";
         }
         
         return response;
     }

     */

}


