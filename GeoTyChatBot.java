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
        if(statement.indexOf(" no ")>=0){
            response="Aw, don't be so negative!";
        }
        else if(statement.indexOf(" mother ") >=0
        ||statement.indexOf(" brother ") >=0
        ||statement.indexOf(" sister ") >=0
        ||statement.indexOf(" father ") >=0
        ||statement.indexOf(" dad ") >=0
        ||statement.indexOf(" mom ") >=0
        ||statement.indexOf(" aunt ") >=0
        ||statement.indexOf(" uncle ") >=0
        ||statement.indexOf(" cousin ") >=0) {
            response="Your family seems interesting. Tell me more about them";
        }
        else if(statement.indexOf(" dog ") >=0
        ||statement.indexOf(" cat ") >=0
        ||statement.indexOf(" hamster ") >=0
        ||statement.indexOf(" bunny ") >=0
        ||statement.indexOf(" fish ") >=0
        ||statement.indexOf(" snake ") >=0){
            response="Oh, is that your pet?"
                if(response=="no"){
                    System.out.println("Do you have any pets?");
                }
                else if(response=="yes"){
                    System.out.println("Tell me about your pets then!");
                }
        }
        else if(statement.indexOf(" pet ") >=0
        ||statement.indexOf(" pets ") >=0){
            response="Do you like your pet(s)?";
        }
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     private String getRandomResponse () {
         final int number_of_responses = 10;
         double r = Math.random();
         int whichResponse = (int)(r * number_of_responses);
         String response = "";
         
         if (whichResponse == 0) {
             response = "That cool, tell me more";
         }
    
