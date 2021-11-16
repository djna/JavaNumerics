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
        exploreIntToByte(126, 130);
        exploreIntToByte(510, 514);
        exploreIntToByte(-514, -510);
    }

    // explore converting 32 bit int to 8 bit byte
    private static void exploreIntToByte(int from, int to) {
        LOGGER.info("From " + from + " to " + to);
        for ( int b = from; b < to; b++ ) {
            String bAsIntValue = String.format("%8d", b);
            String bAsByteValue = String.format("%8d", (byte)b); // cast

            String intAsBits = numberAsBinary(b, 32);
            String byteAsBits = numberAsBinary(b, 8);

            LOGGER.info("int " + bAsIntValue + " converted to byte "
                       + bAsByteValue + " = " + byteAsBits + " from " + intAsBits);
        }
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
