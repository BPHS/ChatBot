import java.io.*;
import java.util.*;
import java.io.IOException;

public class Questions{
    
    public static void main (String args[]){
       /* private String question;
        private String correctAnswer;
        private String userAnswer;
        */
        /*java.io.File MovieQuestionsText=new java.io.File("TriviaBotMovieQuestions.txt");
    
        try{
            Scanner input=new Scanner(MovieQuestionsText);
            while(input.hasNext()){
                int questionsReadIn=input.nextLine();
                int movieQuestionPicker[]=new int[questionsReadIn];
                for(i=0;i<movieQuestionPicker.length; i++){
                    
                }
                    
                }
                
        }
        catch(FileNotFoundException e){
            System.err.format("error. file not found");
        }
        */
        // Read in the file into a list of strings
        try{
            BufferedReader reader = new BufferedReader(new FileReader("TriviaBotMovieQuestions.txt"));
            List<String> lines = new ArrayList<String>();

            String line = reader.readLine();

            while( line != null ) {
                lines.add(line);
                line = reader.readLine();
            }

            // Choose a random one from the list
            Random r = new Random();
            String randomString = lines.get(r.nextInt(lines.size()));
            System.out.println(randomString);
        }
        catch(IOException ioe){
            System.out.println(ioe.toString());
        }
            
    }
}