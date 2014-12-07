package FifaBot;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by cameronmonks on 11/7/14.
 */

/**
 * It left Clicks for you
 */
public class LeftClick {

    // Member data
    private int randomNumb;
    Robot robot;

    /**
     * Defualt Constructor
     * @throws java.awt.AWTException
     */
    public LeftClick() throws AWTException{
        randomNumb = 1;
        robot = new Robot();
    }

    /**
     * Clicks the left button on the mouse and relases it for you
     * @param randomNumb
     */
    public void lClick(int randomNumb){

        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(randomNumb);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(randomNumb);
    }
}
