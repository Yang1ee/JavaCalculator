package org.example;

public class Calculator {

    // Arithmetic Operations
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // Scientific Operations
    public double sqrt(double a) {
        if (a < 0) {
            throw new ArithmeticException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(a);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double log(double a) {
        if (a <= 0) {
            throw new ArithmeticException("Logarithm undefined for non-positive numbers");
        }
        return Math.log10(a);
    }

    public double ln(double a) {
        if (a <= 0) {
            throw new ArithmeticException("Natural logarithm undefined for non-positive numbers");
        }
        return Math.log(a);
    }

    public double sin(double a) {
        return Math.sin(Math.toRadians(a));
    }

    public double cos(double a) {
        return Math.cos(Math.toRadians(a));
    }

    public double tan(double a) {
        return Math.tan(Math.toRadians(a));
    }
}
