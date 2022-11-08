package org.example;

public class QuadraticExpression {
    private double a;
    private double b;
    private double c;
    public QuadraticExpression(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getValueFor(double x){
        // TODO calculate value of quadratic for this x
        double value = Double.NaN;

        return value;
    }

    public double[] solve(double solveFor){
        double equationC = c - solveFor;
        // TODO apply the formula using this.a, this.b, and equationC
        double plusSolution = Double.NaN;
        double minusSolution = Double.NaN;
        return new double[] {plusSolution, minusSolution};
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
