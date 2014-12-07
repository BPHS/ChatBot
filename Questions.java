import java.io.*;
import java.util.*;

public class Questions{
    
    public static void main (String args[]){
       /* private String question;
        private String correctAnswer;
        private String userAnswer;
        */
        java.io.File MovieQuestionsText=new java.io.File("TriviaBotMovieQuestions.txt");
    
        try{
            Scanner input=new Scanner(MovieQuestionsText);
            while(input.hasNext()){
                String num=input.nextLine();
                System.out.println(num);
            }
        }
        catch(FileNotFoundException e){
            System.err.format("error. file not found");
        }
    }
}