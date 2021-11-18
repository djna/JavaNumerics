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
        BigDecimal value = null;
        //TODO implement

        return value;
    }

    public BigDecimal getValueFor(double x){
        return getValueFor(new BigDecimal(x));
    }

    public BigDecimal[] solve(BigDecimal solveFor){

        BigDecimal plusSolution =null;
        BigDecimal minusSolution = null;

        // TODO implement
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
