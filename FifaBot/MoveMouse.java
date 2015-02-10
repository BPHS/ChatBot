package FifaBot;

import java.awt.*;

/**
 * Created by cameronmonks on 11/7/14.
 */

/**
 * This class moves the mouse towards1 the location that is called
 */
public class MoveMouse {

    // Member data
    private int px, py;
    Robot robot;

    // Defualt constructor
    public MoveMouse() throws AWTException{
        px = 1;
        py = 1;
        robot = new Robot();
    }

    /**
     * It moves the mouse a pixel at a time starting at px
     * which is the last place the mouse was and py.
     * px stands for previous x value
     * py stands for previous y value
     * It moves the mouse towards param int x and param int y.
     * The mouse moves 1 x and 1 y at a time going perfectly diagonal
     * in till px or py = x or y respectively then it goes vertical or horizontal
     * @param x
     * @param y
     * @param randomNumb
     */
    public void startMoving(int x, int y, int randomNumb){



        // if it has to go down to the right
        if (y>=py && x >= px){
            // Done when x ahs to go father than y
            if((x - px) >= (y - py)) {
                // moves mouse down to the right
                for (int i = py; i < y; i++) {
                    py = i;
                    px++;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }

                // moves mouse right
                for (int i = px; i < x; i++) {
                    px = i;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
            }
            // done when y has to go father than x
            else {
                // moves mouse down to the right
                for (int i = px; i < x; i++){
                    px = i;
                    py ++;
                    robot.delay(randomNumb);
                    robot.mouseMove(px,py);
                }
                // moves mouse down
                for (int i = py; i < y; i++){
                    py = i;
                    robot.delay(randomNumb);
                    robot.mouseMove(px,py);
                }
            }
        }

        // going in bottom left direction
        else if (y>=py && x <= px) {

            // Done when x has to go farther
            if ((px - x) >= (y - py)) {
                for (int i = py; i < y; i++) {
                    py = i;
                    px--;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }

                // mouse moves left
                for (int i = px; i > x; i--) {
                    px = i;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
            } else {
                // Done when y has to move farther

                for (int i = px; i > x; i--) {
                    px = i;
                    py++;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
                // moves Mouse downj
                for (int i = py; i < y; i++) {
                    py = i;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
            }
        }

        // going up to the right
        else if (py>=y && x >= px) {
            // if x has to go father than y
            if ((x - px) >= (py - y)) {
                // moves mouse up to the right
                for (int i = py; i > y; i--) {
                    py = i;
                    px++;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
                // moves mouse to the right
                for (int i = px; i < x; i++) {
                    px = i;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
            } else { // Done when y has to go father

                // moves mouse up to the right
                for (int i = px; i < x; i++) {
                    px = i;
                    py--;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
                // moves mouse up
                for (int i = py; i > y; i--) {
                    py = i;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
            }
        }


        // going up to left
        else {
            // done if x has to move more than y
            if ((px - x) >= (py - y)) {
                // moves mouse up to the left
                for (int i = py; i > y; i--) {
                    py = i;
                    px--;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
                // movesd mouse to the left
                for (int i = px; i > x; i--) {
                    px = i;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
            } else { // Done when y has to move more than x
                // Moves mouse up the the left
                for (int i = px; i > x; i--) {
                    px = i;
                    py--;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
                // Move mouse upward
                for (int i = py; i > y; i--) {
                    py = i;
                    robot.delay(randomNumb);
                    robot.mouseMove(px, py);
                }
            }
        }
    }
}
