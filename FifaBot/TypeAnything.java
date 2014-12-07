package FifaBot;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by cameronmonks on 11/9/14.
 */

/**
 * This class if for typing it different things like @, :, ENTER, or BACKSPACE,
 */
public class TypeAnything {

    // Member data
    Robot robot;

    // defualt constructor
    public TypeAnything() throws AWTException {

        robot = new Robot();
    }

    /**
     * Types in a colon
     * @param randomNumb
     * @throws java.awt.AWTException
     */
    public void typeColon(int randomNumb) throws AWTException {

        robot.delay(randomNumb);
        robot.keyPress(KeyEvent.VK_COLON);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_COLON);
        robot.delay(randomNumb);
    }

    /**
     * Types in a @ symbol
     * @param randomNumb
     * @throws java.awt.AWTException
     */
    public void typeAT(int randomNumb) throws AWTException {

        robot.delay(randomNumb);
        robot.keyPress(KeyEvent.VK_AT);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_AT);
        robot.delay(randomNumb);
    }

    /**
     * Types in a backspace the amount of time int amount is set to
     * @param randomNumb
     * @param amount
     * @throws java.awt.AWTException
     */
    public void typeBackSpace(int randomNumb, int amount) throws AWTException {

        for (int i = 0; i < amount; i++){
            robot.delay(randomNumb);
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.delay(randomNumb);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        }
    }

    /**
     * Types in Enter
     * @param randomNumb
     * @throws java.awt.AWTException
     */
    public void typeEnter(int randomNumb) throws AWTException {

        robot.delay(randomNumb);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(randomNumb);
    }
}
