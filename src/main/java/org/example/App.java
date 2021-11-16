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

        exploreBitwise();

    }

   private static void exploreBitwise(){
       LOGGER.info( "Explore Bitwise" );

       int startingPoint = 4;
       for (int offset = 0; offset <= 8; offset++ ){
           int theValue = startingPoint - offset;
           twosComplement(theValue);
       }
       twosComplement(0);
       twosComplement(Integer.MIN_VALUE);

       int x = Integer.MIN_VALUE;
       int y = -x;

       LOGGER.info( "x equals y? " + ( x == y ));
   }

    private static void twosComplement(int theValue) {
        int complement = ~theValue;
        int complementPlusOne = complement + 1;
        int added = theValue + complementPlusOne;

        String decimalValue = String.format("%12d", theValue);

        String theValueBinary = numberAsBinary(theValue, 32);
        String complementBinary = numberAsBinary(complement, 32);
        String complementPlusOneBinary = numberAsBinary(complementPlusOne, 32);
        String addedBinary = numberAsBinary(added, 32);

        LOGGER.info(decimalValue + " = " + theValueBinary
                + " = " + complementBinary
                + " = " + complementPlusOneBinary
                + " = " + addedBinary
        );
    }

    // print an int value as a binary number
    // show only the specified number of bits
    private static String numberAsBinary(int b, int bits){
        String formatString = "%" + bits + "s";
        String bAsBits = String.format(formatString,
                        Integer.toBinaryString(b))
                .replaceAll(" ","0");
        if ( bAsBits.length() > bits){
            bAsBits =  bAsBits.substring(bAsBits.length()-8);
        }

        return bAsBits;
    }


}
