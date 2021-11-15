package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main( String[] args )
    {
        LOGGER.info( "Hello World!" );
        exploreIncrements();
        exploreAddition();
        exploreBigNumbers();
        exploreSameButDifferent();
    }

    private static void exploreIncrements() {
         int bigNumber = Integer.MAX_VALUE;
         int biggerNumber = bigNumber + 1;
        if ( biggerNumber > bigNumber){
            LOGGER.info("biggerNumber is bigger");
        } else {
            LOGGER.info("biggerNumber is smaller");
        }
    }

    private static void exploreAddition() {
        double pointOne = 0.1;
        double pointTwo = 0.2;
        double pointThree = 0.3;
        double sumValue = pointOne + pointTwo;

        if ( sumValue == pointThree){
            LOGGER.info("0.1 + 0.2 == 0.3");
        } else {
            LOGGER.warn("0.1 + 0.2 != 0.3");
        }

    }

    private static void exploreBigNumbers() {
        double bigNumber = 9007199254740992.0;
        double biggerNumber = bigNumber + 1;

        if ( biggerNumber == bigNumber){
            LOGGER.info("Adding did not change the value");
        } else {
            LOGGER.info("Adding did change the value");
        }

    }

    private static void exploreSameButDifferent() {

        calculateShare(20, 5);
        calculateShare(0, 5);
        calculateShare(0, 0);

    }

    private static void calculateShare(double toBeShared, double shareBetween) {

        double oneShare = toBeShared / shareBetween;
        double anotherShare = toBeShared / shareBetween;

        if ( oneShare == anotherShare){
            LOGGER.info("Same calculation, same answers");
        } else {
            LOGGER.info("Same calculation, different answers!");
        }

    }
}
