package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// BigDecimal throws exception instead of using NaN
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
public class QuadraticTest
{
    @Test
    public void expression()
    {
        QuadraticExpression simpleExpression = new QuadraticExpression(1, 1, -6);
        assertEquals( "simpleExpression", new BigDecimal(0) , simpleExpression.getValueFor(-3));
        assertEquals( "simpleExpression",  new BigDecimal(0) ,simpleExpression.getValueFor(2) );
    }


    @Test
    public void squareSolve() {
        QuadraticExpression squareExpression = new QuadraticExpression(1, 0, -9);
        BigDecimal[] solution = squareExpression.solve(0);
        BigDecimal[] expected = {new BigDecimal(3), new BigDecimal(-3)};
        Assert.assertArrayEquals(expected, solution);
    }

    @Test
    public void simpleSolve() {
        QuadraticExpression simpleExpression = new QuadraticExpression(1, 1, -6);
        BigDecimal[] solution = simpleExpression.solve(0);
        BigDecimal[] expected = {new BigDecimal(2), new BigDecimal(-3)};
        Assert.assertArrayEquals(expected, solution);
        Assert.assertEquals("first solution yields zero",
                BigDecimal.ZERO, simpleExpression.getValueFor(solution[0]) );
        Assert.assertEquals("second solution yields zero",
                BigDecimal.ZERO, simpleExpression.getValueFor(solution[1]) );
    }

    @Test
    public void badSolve() {

        QuadraticExpression linearExpression = new QuadraticExpression(0, 4, -8);

        Assert.assertThrows(ArithmeticException.class,
                () -> linearExpression.solve(0)
             );
    }

    @Test
    public void largeSolve() {
        QuadraticExpression simpleExpression = new QuadraticExpression(1, -5e50, 6e100);
        BigDecimal[] solution = simpleExpression.solve(0);

        // TODO - use debugger to see why BigDecimal.ZERO.compareTo() is used
        Assert.assertEquals("first solution yields zero",
                0, BigDecimal.ZERO.compareTo(simpleExpression.getValueFor(solution[1])) );
        Assert.assertEquals("second solution yields zero",
                0, BigDecimal.ZERO.compareTo(simpleExpression.getValueFor(solution[1])) );
    }
}
