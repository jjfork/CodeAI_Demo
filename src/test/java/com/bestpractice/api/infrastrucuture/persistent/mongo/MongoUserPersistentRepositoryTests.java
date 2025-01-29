package com.bestpractice.api.infrastrucuture.persistent.mongo;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        // GIVEN two numbers
        int num1 = 5;
        int num2 = 3;
        // WHEN add method is called
        int result = calculator.add(num1, num2);
        // THEN the sum is correct
        assertEquals(8, result);
    }

    @Test
    void testSubtract() {
        // GIVEN two numbers
        int num1 = 10;
        int num2 = 4;
        // WHEN subtract method is called
        int result = calculator.subtract(num1, num2);
        // THEN the difference is correct
        assertEquals(6, result);
    }

    @Test
    void testMultiply() {
        // GIVEN two numbers
        int num1 = 7;
        int num2 = 6;
        // WHEN multiply method is called
        int result = calculator.multiply(num1, num2);
        // THEN the product is correct
        assertEquals(42, result);
    }

    @Test
    void testDivide() {
        // GIVEN two numbers
        int num1 = 12;
        int num2 = 3;
        // WHEN divide method is called
        int result = calculator.divide(num1, num2);
        // THEN the quotient is correct
        assertEquals(4, result);
    }
}