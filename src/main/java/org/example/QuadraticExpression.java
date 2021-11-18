package org.example;

import java.math.BigDecimal;
import java.math.MathContext;

public class QuadraticExpression {
    private final BigDecimal a;
    private final BigDecimal b;
    private final BigDecimal c;
    private MathContext mathContext;
    public QuadraticExpression(BigDecimal a, BigDecimal b, BigDecimal c){
        this.a = a;
        this.b = b;
        this.c = c;
        mathContext = new MathContext(10);
    }
    public QuadraticExpression(double a, double b, double c){
        this.a = new BigDecimal(a);
        this.b = new BigDecimal(b);
        this.c = new BigDecimal(c);
        mathContext = new MathContext(10);
    }

    public BigDecimal getValueFor(BigDecimal x){
        BigDecimal axSquared = a.multiply(x, mathContext).multiply(x, mathContext);
        BigDecimal bx = b.multiply(x, mathContext);
        BigDecimal roundedC = c.round(mathContext);
        BigDecimal value = axSquared.add(bx, mathContext).add(roundedC, mathContext);

        return value;
    }

    public BigDecimal getValueFor(double x){
        return getValueFor(new BigDecimal(x));
    }

    public BigDecimal[] solve(BigDecimal solveFor){
        BigDecimal equationC = c.subtract(solveFor);
        BigDecimal bSquaredMinus4ac = b.multiply(b).subtract( a.multiply(new BigDecimal(4) ).multiply(equationC) );
        BigDecimal sqrtBSquaredMinus4ac = bSquaredMinus4ac.sqrt(mathContext);

        BigDecimal plusSolution = b.negate().add(sqrtBSquaredMinus4ac).divide(a.multiply(new BigDecimal(2)));
        BigDecimal minusSolution = b.negate().subtract(sqrtBSquaredMinus4ac).divide(a.multiply(new BigDecimal(2)));

        return new BigDecimal[] {plusSolution, minusSolution};
    }

    public BigDecimal[] solve(double solveFor){
        return solve(new BigDecimal(solveFor));
    }

    @Override
    public String toString() {
        return "QuadraticExpression{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }


}
