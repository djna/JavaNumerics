package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class QuadraticTest
{
    @Test
    public void simple()
    {
        QuadraticExpression simpleExpression = new QuadraticExpression(1, 1, -6);
        assertEquals( "simpleExpression", 0.0 , simpleExpression.getValueFor(-3), 0.0);
        assertEquals( "simpleExpression",  0.0 ,simpleExpression.getValueFor(2), 0.0);
    }


    @Test
    public void squareSolve() {
        QuadraticExpression squareExpression = new QuadraticExpression(1, 0, -9);
        double[] solution = squareExpression.solve(0);
        Assert.assertArrayEquals(new double[]{+3, -3}, solution, 0.0);
    }

    @Test
    public void simpleSolve() {
        QuadraticExpression simpleExpression = new QuadraticExpression(1, 1, -6);
        double[] solution = simpleExpression.solve(0);
        Assert.assertArrayEquals(new double[]{2, -3}, solution,0.0);
    }

    @Test
    public void badSolve() {
        QuadraticExpression linearExpression = new QuadraticExpression(0, 4, -8);
        double[] solution = linearExpression.solve(0);
        assertTrue("invalid quadratic", java.lang.Double.isNaN(solution[0]));
        assertTrue("invalid quadratic", java.lang.Double.isInfinite(solution[1]));
    }
}
