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
     
     /**
      * Get greeting of the bot
      */
     
     public String getIntro(){
         return "Hi there! You seem bored, let's talk!";
     }
     
     /**
      * Set statements(responses) for various keywords
      * 
      * @param statement The sentence input by the user
      * @return A response based on the present keywords
      */
      
      public String getResponse(String statement) {
        String response="";
        
        
      }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     private String getRandomResponse () {
         final int number_of_responses = 10;
         double r = Math.random();
         int whichResponse = (int)(r * number_of_responses);
         String response = "";
         
         if (whichResponse == 0) {
             response = "That cool, tell me more";
         }
         
         return response;
     }
}
