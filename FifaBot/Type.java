package FifaBot;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by cameronmonks on 11/7/14.
 */

/**
 * Presses the buttons on a keyboard to write out stuff
 */
public class Type {

    // Default constructor
    Robot robot;

    /**
     * Defualt Constructor
     * @throws java.awt.AWTException
     */
    public Type() throws AWTException{
        robot = new Robot();
    }

    /**
     * Types in int i
     * @param i
     * @param randomNumb
     */
    public void typer(int i, int randomNumb){

        robot.delay(randomNumb);
        robot.keyPress(i);
        robot.keyRelease(i);
    }

    /**
     * Types in string S
     * @param s
     * @param randomNumb
     */
    public void typer(String s, int randomNumb) {

        byte[] bytes = s.getBytes();
        for (byte b : bytes) {

            int code = b;
            if (code > 96 && code < 123) {
                code = code - 32;
            }
            robot.delay(randomNumb);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }
}
