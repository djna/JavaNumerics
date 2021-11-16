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
        double axSquared = a * x * x;
        double bx = b * x;
        double value = axSquared + bx + c;

        return value;
    }

    public double[] solve(double solveFor){
        double equationC = c - solveFor;
        double bSquaredMinus4ac = (b * b) - ( 4 * a * equationC );
        double sqrtBSquaredMinus4ac = Math.sqrt(bSquaredMinus4ac);

        double plusSolution = ((-b) + sqrtBSquaredMinus4ac) / ( 2 * a);
        double minusSolution = ((-b) - sqrtBSquaredMinus4ac) / ( 2 * a);

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
