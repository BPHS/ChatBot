
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

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
    //private String category;
    private String triviaQuestion;
    private int category;
    private final int MOVIES = 1;
    private final int MATH = 2;
    private final int HISTORY = 3;
    public boolean isCorrect;
    public String correctAnswer;
    public String correctHistoryAnswer;
    int randomMovieLine;
    int randomHistoryLine;
    
    File file=new File("TriviaBotMovieQuestions.txt");
    ArrayList<String> movieQuestions=new ArrayList<String>();
    
    File answersFile=new File("TriviaBotMovieAnswers.txt");
    ArrayList<String> movieAnswers=new ArrayList<String>();
    
    File historyFile=new File("TriviaBotHistoryQuestion.txt");
    ArrayList<String> historyQuestions=new ArrayList<String>();
    
    File historyAnswersFile=new File("TriviaBotHistoryAnswers.txt");
    ArrayList<String> historyAnswers=new ArrayList<String>();
    
    public void setHistoryLineIndex(){
        try{
            Scanner scanner=new Scanner(historyFile);
            while(scanner.hasNextLine()){
                String hisLine=scanner.nextLine();
                historyQuestions.add(hisLine);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        Random random=new Random();
        randomHistoryLine=random.nextInt(historyQuestions.size());
    }
    public String setHistoryAnswer(){
        try{
            Scanner scanner=new Scanner(historyAnswersFile);
            while(scanner.hasNextLine()){
                String hisAnswerLine=scanner.nextLine();
                historyAnswers.add(hisAnswerLine);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        correctHistoryAnswer=historyAnswers.get(randomHistoryLine);
        return correctHistoryAnswer;
    }
    
    
    public void setMovieLineIndex(){
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
            randomMovieLine=random.nextInt(movieQuestions.size());
    }
    public String setMovieAnswer(){
        try{
            Scanner scanner=new Scanner(answersFile);
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                movieAnswers.add(line);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        correctAnswer=movieAnswers.get(randomMovieLine);
        return correctAnswer;
    }
    
 
    
    
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
            question=movieQuestions.get(randomMovieLine);
        } else if (category == MATH) {
            
            question = "What is 2 + 2 * 3 / 2 = ";
            
        } //else if (category == HISTORY) {
            
            //question=historyQuestions.get(randomHistoryLine);
            
        //}
        else {
            question = "Sorry I do not support that category yet. Pick another one :)";
        }

        return question;
    }
    
    public void setCategory(int category){
        this.category=category;
    }
    public int getCategory(){
        return category;
    }


    // TODO: needs to be built, this is a stub only to simulate game play.
    public boolean isCorrect(String answer) {
        if (category==MOVIES) {
            if(answer.equalsIgnoreCase(correctAnswer)){
               isCorrect=true;
            }
            else{
                isCorrect=false;
            }
        }else if(category==HISTORY){
            if(answer.equalsIgnoreCase(correctHistoryAnswer)){
                isCorrect=true;
            } else{
                isCorrect=false;
            }
        }
        /*else{
            if(answer.equalsIgnoreCase(correctMathAnswer)){
                isCorrect=true;
            }
            else{
                isCorrect=false;
            }
        }
        */
        System.out.println("Your answer: "+answer);
        System.out.println("Correct answer: "+correctAnswer);
        return isCorrect;
    }
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
    System.out.println(correctResponse);
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
        System.out.println (incorrectResponse);
        
    }
}


