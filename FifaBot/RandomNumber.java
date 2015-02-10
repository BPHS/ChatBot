package FifaBot;

import java.math.*;

/**
 * Created by cameronmonks on 11/7/14.
 */

/**
 * This class is just made to get a random number beetween to numbers
 */
public class RandomNumber {

    // Member Data
    private int min, max;

    // Defualt constructor
    public RandomNumber(){
        min = 1;
        max = 1;
    }

    /**
     *
     * @param min
     * @param max
     * @return a number beetween min and max. Can be max but is always higher than min
     */
    public int getRandom(int min, int max){

        return ((int)(Math.ceil(Math.random()* (max - min)))) + min;
    }
}
