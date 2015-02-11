
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
//Establish a scanner that will allow input from the keyboard
    Scanner scanner=new Scanner(System.in);
    
/*Member data
 *
*/
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
    public String correctMathAnswer;
    int randomMathLine;
    int randomMovieLine;
    int randomHistoryLine;

/**Create a new File, which will conisist of a text file that
 * either holds a set of questions for a specific category,
 * or a set of answers for a specific category. This file will
 * be read later, and added into a String ArrayList, which will
 * be populated with each line from the text file. Therefore, each
 * new index on the array list will be a different question from
 * the file. Also, since the line that a question is on matches
 * the line that the answer is on in the answer text, it will
 * allow for easy matching
 */

    File file=new File("TriviaBotMovieQuestions.txt");
    ArrayList<String> movieQuestions=new ArrayList<String>();
    
    File answersFile=new File("TriviaBotMovieAnswers.txt");
    ArrayList<String> movieAnswers=new ArrayList<String>();
    
    File historyFile=new File("TriviaBotHistoryQuestion.txt");
    ArrayList<String> historyQuestions=new ArrayList<String>();
    
    File historyAnswersFile=new File("TriviaBotHistoryAnswers.txt");
    ArrayList<String> historyAnswers=new ArrayList<String>();
    
    File mathFile=new File("TriviaBotMathQuestions.txt");
    ArrayList<String> mathQuestions=new ArrayList<String>();
    
    File mathAnswersFile=new File("TriviaBotMathAnswers.txt");
    ArrayList<String> mathAnswers=new ArrayList<String>();
    
/**A method to read the math question file,and populate an
 * array list with the lines in the file. Also will
 * randomly select a number between zero and the
 * math question file's size-1(or length), which will then
 * be used to pick a question/answer.
 */
 
    public void setMathLineIndex(){
        try{
            Scanner scanner=new Scanner(mathFile);
            while(scanner.hasNextLine()){
                String mathLine=scanner.nextLine();
                mathQuestions.add(mathLine);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        Random random=new Random();
        randomMathLine=random.nextInt(mathQuestions.size()-1);
    }

/**A method to set the math answer. Similarily to the math line
 * index method, the method reads the math answers text file, and 
 * populates an array list with the lines. The answer is then matched
 * to the question, by using the randomMathLine index(Since the question
 * and answer occur at the same index).
 * 
 * @return correctMathAnswer A string answer that is the correct
 * response to the math question asked.
 */
    
    public String setMathAnswer(){
        try{
            Scanner scanner=new Scanner(mathAnswersFile);
            while(scanner.hasNextLine()){
                String mathAnswersLine=scanner.nextLine();
                mathAnswers.add(mathAnswersLine);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        correctMathAnswer=mathAnswers.get(randomMathLine);
        return correctMathAnswer;
    }

/**A method to read the history question file,and populate an
 * array list with the lines in the file. Also will
 * randomly select a number between zero and the
 * math question file's size-1(or length), which will then
 * be used to pick a question/answer.
 */
 
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
        randomHistoryLine=random.nextInt(historyQuestions.size()-1);
    }
    
/**A method to set the history answer. Similarily to the history line
 * index method, the method reads the history answers text file, and 
 * populates an array list with the lines. The answer is then matched
 * to the question, by using the randomHistoryLine index(Since the question
 * and answer occur at the same index).
 * 
 * @return correctHistoryAnswer A string answer that is the correct
 * response to the history question asked.
 */
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
    
/**A method to read the movie question file,and populate an
 * array list with the lines in the file. Also will
 * randomly select a number between zero and the
 * math question file's size-1(or length), which will then
 * be used to pick a question/answer.
 */
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
            randomMovieLine=random.nextInt(movieQuestions.size()-1);
    }
    
/**A method to set the movie answer. Similarily to the movie line
 * index method, the method reads the movie answers text file, and 
 * populates an array list with the lines. The answer is then matched
 * to the question, by using the randomHistoryLine index(Since the question
 * and answer occur at the same index).
 * 
 * @return correctMovieAnswer A string answer that is the correct
 * response to the movie question asked.
 */
 
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
    
 
    
    
/**Get greeting of the bot
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
/**A method to test if the user wants to run 
 * the program again
 * 
 * @return answer The answer decides if the program will be run 
 * again. If the answer equals some form of yes, or y, it will 
 * run again. Any form of no, or n, will end the program.
 */

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
    
/**A method to ask the user a trivia question, depending on
 * the category chosen by the user.
 * 
 * @param category The category of trivia chosen by the user.
 * They are given the option of 1, 2, or 3, which correlate to
 * MOVIE, MATH, and HISTORY, respectiely. All three are final integers
 * movie categories are stored as final integers, hence the bold.
 * 
 * @return question The question that will be asked to the user. The
 * right category for the question is established via if statements,
 * where a random question is pulled by taking a random line from the
 * array list of questions.
 */
    public String askTriviaQuestion(int category){
        String question = "";
        if (category == MOVIES) {
            question=movieQuestions.get(randomMovieLine);
        } else if (category == MATH) {
            question=mathQuestions.get(randomMathLine);
        } else if (category == HISTORY) {
            question=historyQuestions.get(randomHistoryLine);
        }
        else {
            question = "Sorry I do not support that category yet. Pick another one :)";
        }

        return question;
    }
    
/**A method to set the category.
 * 
 * @param category The category chosen by the user
 */
 
    public void setCategory(int category){
        this.category=category;
    }

/**A method to return the category chosen by the
 * user.
 * 
 * @return category The category chosen by the user
 */
 
    public int getCategory(){
        return category;
    }


/**A method to test whether or not the answer entered by the 
 * user matches the correct answer. The answr must exactly match
 * the answer found in the answer file, otherwise the user will 
 * be marked incorrect. Capitalization does not matter.
 * 
 * @param answer The answer entered by the used
 * 
 * @return isCorrect A boolean which tells if the user is correct
 * or incorrect. If true, the user is correct. If false, the user
 * was incorrect.
 */
 
    public boolean isCorrect(String answer) {
        if (category==MOVIES) {
            if(answer.equalsIgnoreCase(correctAnswer)){
               isCorrect=true;
            }
            else{
                isCorrect=false;
                System.out.println("Correct answer: "+correctAnswer);
            }
        }else if(category==HISTORY){
            if(answer.equalsIgnoreCase(correctHistoryAnswer)){
                isCorrect=true;
            } else{
                isCorrect=false;
                System.out.println("Correct answer: "+correctHistoryAnswer);
            }
        }
        else{
            if(answer.equalsIgnoreCase(correctMathAnswer)){
                isCorrect=true;
            }
            else{
                isCorrect=false;
                System.out.println("Correct answer: "+correctMathAnswer);
            }
        }
        
        System.out.println("Your answer: "+answer);
        return isCorrect;
    }
    
/**A method to show a correct message, upon a right answer.
 * The method will only be called upon a correct answer. The answers
 * are purposely witty, and are ment to antagonize the user.
 */
 
    public void showMessageCorrect() {
        String correctResponse;
        String[] strCorrect = new String[21]; //declaring array of twenty items
 
              strCorrect[0] ="You are amazing, this a correct!!";
              strCorrect[1] ="No way, you got it right";
              strCorrect[2] ="Alright, that was an easy one, next one will be harder!";
              strCorrect[3] ="I can't believe you got that!";
              strCorrect[4] ="How'd you know??";
              strCorrect[5] ="Correct!!";
              strCorrect[6] ="Wow! How'd you get that one??";
              strCorrect[7] ="Alright, quit cheating..";
              strCorrect[8] ="Watch out, valedictorian over here!";
              strCorrect[9] ="What, do you think you're smart or something?";
              strCorrect[10] ="Big deal, you got one right...";
              strCorrect[11] ="Ok, Ok, that question was too easy...";
              strCorrect[12] ="Even a blind squirrel finds a nut once in a while...";
              strCorrect[13] ="That's right!!";
              strCorrect[14] ="You're getting pretty good at this!";
              strCorrect[15] ="You're lucky I'm taking it easy on you...";
              strCorrect[16] ="Ok, no more Mr. Nice TriviaBot!!";
              strCorrect[17] ="You'll never get the next one...";
              strCorrect[18] ="Way to go!";
              strCorrect[19] ="Big whoop! Want to fight about it?";
              strCorrect[20] ="Too easy...";
              
 
        Random randomCorrectResponse=new Random();
        correctResponse=strCorrect[randomCorrectResponse.nextInt(strCorrect.length)];
    System.out.println(correctResponse);
    }
    
/**A method to show an incorrect message, upon a wrong answer.
 * The method will only be called upon an incorrect answer. The answers
 * are purposely witty, and are ment to antagonize the user.
 */
 
    public void showMessageInCorrect() {
        String incorrectResponse;
        String [] strIncorrect = new String [21];
        
        strIncorrect [0] = "Not even close!";
        strIncorrect [1] = "That wasn't actually your answer was it?";
        strIncorrect [2] = "You should take a break! You seem to be struggling";
        strIncorrect [3] = "We should start betting! I'd be rich!!!";
        strIncorrect [4] = "Awful... just awful";
        strIncorrect [5] = "*Yawnn* you being wrong is getting old";
        strIncorrect [6] = "ERRRR!! WRONG!";
        strIncorrect [7] = "HA! Not even close";
        strIncorrect [8] = "Wow, you must be pretty stupid if you missed that one";
        strIncorrect [9] = "Nope, try again next time";
        strIncorrect [10] = "Am I playing with a 6 year old? I'm sorry, your answers are just bad...";
        strIncorrect [11] = "Nice job!!!... is what I would say if you got that right, but you didn't!";
        strIncorrect [12] = "That's so far off its funny!";
        strIncorrect [13] = "Are you trying to get these wrong??";
        strIncorrect [14] = "You're joking, right?";
        strIncorrect [15] = "No way!!! You got it wrong? Who would of guessed...";
        strIncorrect [16] = "Don't worry, you'll get the next one, hopefully...";
        strIncorrect [17] = "The magic 8 ball says: \"Outlook not so good\"";
        strIncorrect [18] = "Wrong, wrong, wrong..";
        strIncorrect [19] = "Well, good thing this isn't a test, because you'd fail...";
        strIncorrect [20] = "When did you go to school? Because you might want to go back...";
        
        Random randomIncorrectResponse = new Random ();
        incorrectResponse = strIncorrect[randomIncorrectResponse.nextInt(strIncorrect.length)];
        System.out.println (incorrectResponse);
        
    }
}


