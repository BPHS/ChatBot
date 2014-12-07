package FifaBot;

/**
 * Created by cameronmonks on 10/31/14.
 */

import java.awt.*;
import java.util.Scanner;
import java.lang.*;

/**
 * This is the main class for the fifa auto bidder
 * So far it can
 * 1) Gets username and passcode for ea
 * 2) Click on safari if its at the same place
 * 3) Maximizes safari and types in url of ultimate team (Cant type in : yet but will be able to)
 * 4) Loggs in to fifa ( cant type in  @ symbol yet but will)
 * 5) Does a lot of stuff that gets a random function for less noticable
 *
 * It will
 * 1) Use the class FindPixel to find whear safari is (or your own choice of web browser) and
 *      other things like a maximizer auto bids on player
 * 2) I will make a class that keeps track of the time for the day and you get to choose the time to bid and sell players
 * 3) Menu and something to change options. And permittly change them for every time you log on
 * 4) Eventually when it starts to buy players i will have a while loops to loop through it
 * 5) needs a way to exit
 * 6) wont be with terminal but instead it will have picture and ability to click on things
 * 7) I want to improve the MoveMouse class so it is less noticable of a bot and maybe uses
 *      a quadratic formula od something to move the mouse to where it should go.
 *      Also have another thing that the mouse move about 5 pixels off everytime for less detection of a bot
 *      Also have another function that the moves randomly on the screan and that will happen every once in
 *          a while for better detection.
 * 8)
 */

public class Bot {

    Robot robot = new Robot();
    Scanner scanner = new Scanner(System.in);
    MoveMouse moveMouse = new MoveMouse();
    Type myType = new Type();
    LeftClick leftClick = new LeftClick();
    RandomNumber randomNumber = new RandomNumber();
    TypeAnything typeAnything = new TypeAnything();
    FindPixel findPixel = new FindPixel();
    Color color = robot.getPixelColor(1, 1);

    public static void main(String[] args) throws AWTException{
        new Bot();
    }

    private Bot() throws AWTException{

        System.out.print("Type your email but put a space for @: ");
        String username1 = scanner.next();
        String username2 = scanner.next();
        String q = scanner.nextLine();
        System.out.print("Type your passcode: ");
        String passcode = scanner.nextLine();

        int y = 0, x = 0, randomNumb = 0;

        moveMouse.startMoving(0,0,1);

        // getting onto safari. Must be in same location every time. Also maximizes it
        findPixel.findingPixel(460, 500, 730, 770, 181, 2, 216, 10, 10);

        moveMouse.startMoving(findPixel.getX(),findPixel.getY(), randomNumber.getRandom(1,10));
        System.out.println("X == " + findPixel.getX());
        System.out.println("Y == " + findPixel.getY());
        /*randomNumb = randomNumber.getRandom(10,20);
        moveMouse.startMoving(480, 750, randomNumb);
        randomNumb = randomNumber.getRandom(7, 10);
        leftClick.lClick(randomNumb); */

        moveMouse.startMoving(300, 70, 20); // helps me find where maximizer is
        // Maximizes Safari
        Color color = robot.getPixelColor(370, 70);
        System.out.println("Green == " + color.getGreen());
        System.out.println("Red == " + color.getRed());
        System.out.println("Blue == " + color.getBlue());
        color = robot.getPixelColor(x, y);
        while (color.getGreen() < 150){
            x += 1;
            while (y < 300 && color.getGreen() < 150) {
                y += 1;
                robot.getPixelColor(x, y);
            }
            if (y > 298 && color.getGreen() < 150) y = 0;
        }
        randomNumb = randomNumber.getRandom(1, 5);
        moveMouse.startMoving(x, y, randomNumb);   // moves mouse to maximizer. usually 370, 70
        randomNumb = randomNumber.getRandom(1, 5);
        leftClick.lClick(randomNumb);               // clicks on maximizer

        //  Clicks on Url
        randomNumb = randomNumber.getRandom(1, 5);
        moveMouse.startMoving(700, 20, randomNumb);
        leftClick.lClick(randomNumb);
        randomNumb = randomNumber.getRandom(10,30);

        // Types in url for Ultimate Team
        randomNumb = randomNumber.getRandom(30,50);
        myType.typer("http", randomNumb);
        typeAnything.typeColon(randomNumb);
        myType.typer("//www.easports.com/fifa/ultimate-team/why-fifa-ultimate-team", randomNumb);
        //type("http://www.easports.com/fifa/ultimate-team/why-fifa-ultimate-team", randomNumb);
        typeAnything.typeEnter(randomNumb);

        // Loggin in
        randomNumb = randomNumber.getRandom(1,5);
        moveMouse.startMoving(1100,50, randomNumb); // moves mouse to log in button
        leftClick.lClick(randomNumb); // clicks on loggin
        robot.delay(5);
        leftClick.lClick(randomNumb); // double clicks
        robot.delay(10000);  // waits for screen to load
        randomNumb = randomNumber.getRandom(1,5);
        moveMouse.startMoving(500,350, randomNumb); // moves mouse to type username
        randomNumb = randomNumber.getRandom(10,20);
        leftClick.lClick(randomNumb); //clicks on username
        typeAnything.typeBackSpace(randomNumb, username1.length() + username2.length() + 1); // Back Spaces any previous passwords typed
        randomNumb = randomNumber.getRandom(50,75);
        myType.typer(username1, randomNumb); // types in email before @
        typeAnything.typeAT(randomNumb); // Types in @
        myType.typer(username2, randomNumb); // Types second part of email after @
        randomNumb = randomNumber.getRandom(1,5);
        moveMouse.startMoving(500,430,randomNumb); // moves mouse to type passcode
        randomNumb = randomNumber.getRandom(10,20);
        leftClick.lClick(randomNumb); // clicks on passcode
        typeAnything.typeBackSpace(randomNumb, passcode.length() + 1); // Back Spaces any previous passwords typed
        randomNumb = randomNumber.getRandom(50,100);
        myType.typer(passcode, randomNumb); // types passcode
        randomNumb = randomNumber.getRandom(1,5);
        moveMouse.startMoving(410,500, randomNumb); // finds log in button
        randomNumb = randomNumber.getRandom(1,5);
        leftClick.lClick(randomNumb); // clicks login button
        leftClick.lClick(randomNumb); // double clicks
        /*robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);

        robot.delay(500);

        System.exit(0);*/
    }
}
