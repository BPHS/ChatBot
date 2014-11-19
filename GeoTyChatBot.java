import java.util.*;
import java.io.*;

/** 
 * George and tyler created this simple chat bot,
 * in hopes that one day it will grow to be something
 * really big. Or until we start building games.
 * 
 * A simple code that will use a slew of else if statements
 * to set a response of the chatbot. Scanner will
 * be located in the tester. Have fun!
 * 
 */
 
 public class GeoTyChatBot{
     Scanner scanner = new Scanner (System.in);
     
     /**
      * Get greeting of the bot
      * @return answer ; the response of the user
      */
     
     public String getIntro(){
        System.out.print ("Hi there, my name is Trivia Bot. Think you can beat me in a");
        System.out.println (" game of trivia?(Yes/No)");
        String answer=scanner.nextLine();
        return answer;
     }
}
    
    

      // public String getResponse(String statement) {
        //String response="";
        
        
      //}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /* private String getRandomResponse () {
         final int number_of_responses = 10;
         double r = Math.random();
         int whichResponse = (int)(r * number_of_responses);
         String response = "";
         
         if (whichResponse == 0) {
             response = "That cool, tell me more";
         }
         
         return response;
     }
}*/

