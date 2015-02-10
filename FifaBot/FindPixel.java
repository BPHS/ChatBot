package FifaBot;

import java.math.*;
import java.awt.*;
import java.lang.*;

/**
 * Created by cameronmonks on 11/7/14.
 */
public class FindPixel {

    // memeber data
    Robot robot;
    Color color;
    private String colour;
    private int x;
    private int y;

    // defualt constructor
    public FindPixel() throws AWTException {
        robot = new Robot();
        Color color = robot.getPixelColor(370, 70);
        x = 0;
        y = 0;
    }

    /**
     * This finds the main color of the pixel you want
     * @param x
     * @param y
     * @return colour is main color of pixel
     */
    public String findingPixelColor(int x, int y){

        color = robot.getPixelColor(x, y);
        int green = color.getGreen();
        int red = color.getRed();
        int blue = color.getBlue();

        if (green > red && green > blue) colour = "green";
        else if (red > green && red > blue) colour = "red";
        else {colour = "blue";}


        return colour;
    }


    /**
     * It gets the amoount of color of the pixel you want
     * @param x
     * @param y
     * @param colour
     * @return the amount of the color you pick at the pixel you want
     */
    public int getColor(int x, int y, String colour){

        color = robot.getPixelColor(x, y);

        if (colour.equals("green")) return color.getGreen();
        else if (color.equals("blue")) return color.getBlue();
        else if (color.equals("red")) return color.getRed();
        else return -1;
    }

    /**
     * Stores x and y as the pixels you want
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @param amountOfGreen
     * @param amountOfRed
     * @param amountOfBlue
     * @param amountOff
     * @param amountOfPixels
     */
    public void findingPixel(int startX, int endX, int startY, int endY, int amountOfGreen, int amountOfRed, int amountOfBlue, int amountOff, int amountOfPixels) {

        int found = -1;
        findingPixel(startX, endX, startY, endY, amountOfGreen, amountOfRed, amountOfBlue, amountOff);
        System.out.println("X is " + x + "Y is " + y);
        while (found == -1){
            found = 0;

            findingPixel(getX(), endX, getY(), endY, amountOfGreen, amountOfRed, amountOfBlue, amountOff);
            color = robot.getPixelColor(x,y);

            // checks to see if it found the right pixel
            if ((Math.abs(color.getGreen() - amountOfGreen) < amountOff)
                    && (Math.abs(color.getRed() - amountOfRed) < amountOff)
                    && (Math.abs(color.getBlue() - amountOfBlue) < amountOff)) {
                for (int i = 0; i < amountOfPixels; i++) {

                    color = robot.getPixelColor(x,y);

                    // checks to see if it found the right pixel
                    if ((Math.abs(color.getGreen() - amountOfGreen) > amountOff)
                            || (Math.abs(color.getRed() - amountOfRed) > amountOff)
                            || (Math.abs(color.getBlue() - amountOfBlue) > amountOff)) {

                        found = -1;
                    }
                }
            }
            else {
                System.out.println("Sorry! We could not find your pixel.");
            }

        }
    }

    /**
     * Store x and y as the pixel you want
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @param amountOfGreen
     * @param amountOfRed
     * @param amountOfBlue
     * @param amountOff
     */
    public void findingPixel(int startX, int endX, int startY, int endY, int amountOfGreen, int amountOfRed, int amountOfBlue, int amountOff) {

        int x = startX, y = startY;
        color = robot.getPixelColor(x, y);


        while (x < endX && (Math.abs(color.getGreen() - amountOfGreen) > amountOff)
                && (Math.abs(color.getRed() - amountOfRed) > amountOff)
                && (Math.abs(color.getBlue() - amountOfBlue) > amountOff)) {

            while (y < endY && (Math.abs(color.getGreen() - amountOfGreen) > amountOff)
                    && (Math.abs(color.getRed() - amountOfRed) > amountOff)
                    && (Math.abs(color.getBlue() - amountOfBlue) > amountOff)) {

                y += 1;
                color = robot.getPixelColor(x, y);
                System.out.println("The x axis is " + x + "\nThe y axis is " + y);
            }

            if (y > endY
                    && (Math.abs(color.getGreen() - amountOfGreen) > amountOff)
                    && (Math.abs(color.getRed() - amountOfRed) > amountOff)
                    && (Math.abs(color.getBlue() - amountOfBlue) > amountOff))
                y = startY;

            x += 1;
            System.out.println("The x axis is " + x + "\nThe y axis is " + y);
        }
    }

    /**
     * it sets the x and y to the first color of pixel it finds
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @param colour
     * @param amountOfColor
     */
    public void findingPixel(int startX, int endX, int startY, int endY, String colour, int amountOfColor){

        if (colour.equals("green")) findingGreenPixel(startX, endX, startY, endY, amountOfColor);
        else if (colour.equals("red")) findingRedPixel(startX, endX, startY, endY, amountOfColor);
        else if (colour.equals("blue")) findingBluePixel(startX, endX, startY, endY, amountOfColor);
    }

    /**
     * Finds pixel of the first Green pixel and stores x and y their
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @param amountOfColor
     */
    public void findingGreenPixel(int startX, int endX, int startY, int endY, int amountOfColor){

        int x = startX, y = startY;

        while (x < endX && color.getGreen() < amountOfColor){

            x += 1;

            while (y < endY && color.getGreen() < amountOfColor) y += 1;

            if (y > endY - 2 && color.getGreen() < amountOfColor)y = startY;

        }
    }

    /**
     * Finds pixel of the first Red pixel and stores x and y their
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @param amountOfColor
     */
    public void findingRedPixel(int startX, int endX, int startY, int endY, int amountOfColor){

        int x = startX, y = startY;

        while (x < endX && color.getRed() < amountOfColor){

            x += 1;

            while (y < endY && color.getRed() < amountOfColor) y += 1;

            if (y > endY - 2 && color.getRed() < amountOfColor)y = startY;

        }
    }

    /**
     * Finds pixel of the first Blue pixel and stores x and y their
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @param amountOfColor
     */
    public void findingBluePixel(int startX, int endX, int startY, int endY, int amountOfColor){

        int x = startX, y = startY;

        while (x < endX && color.getBlue() < amountOfColor){

            x += 1;

            while (y < endY && color.getBlue() < amountOfColor) y += 1;

            if (y > endY - 2 && color.getBlue() < amountOfColor)y = startY;

        }
    }

    /**
     * it returns x axis
     * @return int x
     */
    public int getX(){
        return x;
    }

    /**
     * It returns y axis
     * @return int y
     */
    public int getY(){
        return y;
    }
}
