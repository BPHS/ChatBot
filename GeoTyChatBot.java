
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


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
            //File file=new File()
            //FileReader fr=new FileReader("TriviaBotMovieQuestions.txt");
            //try{
              //  BufferedReader reader = new BufferedReader(new FileReader("TriviaBotMovieQuestions.txt"));
            //}
            //catch(FileNotFoundException e){
              //  System.out.println(e.getMessage());
            //}
            /*BufferedReader reader = new BufferedReader(new FileReader("TriviaBotMovieQuestions.txt"));
            try{
                
                ArrayList<String> lines = new ArrayList<String>();

                String line = reader.readLine();

                while( line != null ) {
                    lines.add(line);
                    line = reader.readLine();
                }

                // Choose a random one from the list
                Random r = new Random();
                String randomString = lines.get(r.nextInt(lines.size()));
            }
            catch(FileNotFoundException e){
                System.out.println(e.toString());
            }
            catch(IOException e){
                
            }
            
            ArrayList<String> sentences = new ArrayList<String>();
            String temp;
            int numLines=0;
            JFileChooser chooser = new JFileChooser();

            File infile = null;

            FileReader reader = null;

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                infile = chooser.getSelectedFile();
                try{
                    reader = new FileReader(infile);
                }
                catch(FileNotFoundException e){
                    System.out.println(e.toString());
                }
            }
            try{
                Scanner input = new Scanner(infile);
                while (input.hasNextLine()){
                temp = input.nextLine();
                sentences.add(temp);
                numLines++;
            }
            }
            catch(FileNotFoundException e){
                System.out.println(e.toString());
            }
            Random r = new Random();
            System.out.println(sentences.get(r.nextInt(sentences.size())));
            */
            File file=new File("TriviaBotMovieQuestions.txt");
            ArrayList<String> movieQuestions=new ArrayList<String>(); 
            try{
                Scanner scanner=new Scanner(file);
                while(scanner.hasNextLine()){
                    String line=scanner.nextLine();
                    movieQuestions.add(line);
                }
            }
            catch(FileNotFoundException e){
                System.out.println(e.toString());
            }
            Random random=new Random();
            int randomLine=random.nextInt(movieQuestions.size());
            question=movieQuestions.get(randomLine);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
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
    //       denote the user was correct to make this fun.
    //EDIT: (GEORGE): Mr. Eipp, I think this will work
    //      to choose a random message to be displayed when the user
    //      guesses the right answer. The only problem is that I
    //      don't know where/how to assign the right answer to each
    //      problem. I'm assuming it will use alot of indexOf's, but
    //      still really dumbfounded. 
    //TODO:  Assign the right answer to the questions in order 
    //      to test the below methods.
    //      (george)
    public void showMessageCorrect() {
        String correctResponse;
        String[] strCorrect = new String[6]; //declaring array of six items
 
              strCorrect[0] ="You are amazing, this a correct!!";
 
              strCorrect[1] ="No way, you got it right!";
 
              strCorrect[2] ="Alright, that was an easy one, next one will be harder!";
              
              strCorrect[3] ="I can't believe you got that!";
              
              strCorrect[4] ="How'd you know??";
              
              strCorrect[5] ="Correct!!";
 
        Random randomCorrectResponse=new Random();
        correctResponse=strCorrect[randomCorrectResponse.nextInt(strCorrect.length)];
    System.out.println(strCorrect);
    }
    
    // TODO: make this a cool message too...
    //       this should have many different fun messages that 
    //       denote the user was incorrect to make this fun
    
    // Didnt edit because we are doing seperate docs for answers and Questions
    public void showMessageInCorrect() {
        String incorrectResponse;
        String [] strIncorrect = new String [6];
        
        strIncorrect [0] = "Not even close!";
        
        strIncorrect [1] = "That wasn't actually your answer was it?";
        
        strIncorrect [2] = "You should take a break! You seem to be struggling";
        
        strIncorrect [3] = "We should start betting! I'd be rich!!!";
        
        strIncorrect [4] = "Awful... just awful";
        
        strIncorrect [5] = "*Yawnn* you being wrong is getting old";
        
        Random randomIncorrectResponse = new Random ();
        incorrectResponse = strIncorrect[randomIncorrectResponse.nextInt(strIncorrect.length)];
        System.out.println (strIncorrect);
    }
}


