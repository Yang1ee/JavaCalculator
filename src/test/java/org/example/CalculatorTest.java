package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(2, -3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(5, calculator.subtract(2, -3));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-6, calculator.multiply(2, -3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-2, calculator.divide(6, -3));
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

    @Test
    void testSqrt() {
        assertEquals(3, calculator.sqrt(9));
        assertThrows(ArithmeticException.class, () -> calculator.sqrt(-1));
    }

    @Test
    void testPower() {
        assertEquals(8, calculator.power(2, 3));
        assertEquals(1, calculator.power(5, 0));
    }

    @Test
    void testLog() {
        assertEquals(1, calculator.log(10));
        assertThrows(ArithmeticException.class, () -> calculator.log(0));
    }

    @Test
    void testLn() {
        assertEquals(0, calculator.ln(1));
        assertThrows(ArithmeticException.class, () -> calculator.ln(0));
    }

    @Test
    void testTrig() {
        // Checking approximate values due to floating point precision
        assertEquals(0, calculator.sin(0), 0.0001);
        assertEquals(1, calculator.sin(90), 0.0001);
        assertEquals(1, calculator.cos(0), 0.0001);
        assertEquals(0, calculator.cos(90), 0.0001);
        assertEquals(0, calculator.tan(0), 0.0001);
    }
}
