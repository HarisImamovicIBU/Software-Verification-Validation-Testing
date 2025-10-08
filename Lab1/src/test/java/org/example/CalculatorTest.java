package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    //Task 1
    @Test
    public void assertValidFactorial(){
        Calculator calc = new Calculator();
        assertEquals(120, calc.factorial(5), "Factorial of 5 should be 120!");
        assertNotEquals(25, calc.factorial(4), "Factorial of 4 should not be 25!");
    }

    //Task 2
    @Test
    public void assertNullOnNullArgument(){
        Calculator calc = new Calculator();
        assertNull(calc.stringToArrayOfWords(null));
    }
    @Test
    public void assertArrayOfWordsOnStringArgument(){
        Calculator calc = new Calculator();
        assertArrayEquals(new String[]{"This", "is", "a", "unit", "test"}, calc.stringToArrayOfWords("This is a unit test"));
    }

    //Task 4
    @Test
    public void assertEmptyArray(){
        Calculator calc = new Calculator();
        assertArrayEquals(new int[]{}, calc.sort(new int[]{}));
    }
    @Test
    public void assertCorrectlySortedArray(){
        Calculator calc = new Calculator();
        assertArrayEquals(new int[]{1,2,3,4,5}, calc.sort(new int[]{2,3,5,1,4}));
    }
}