package org.parameterizedtesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberCheckerTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 17, 19, 211})
    public void testIsPrime(int n){
        NumberChecker nc = new NumberChecker();
        assertTrue(nc.isPrime(n), n+" should be prime!");
    }

    @ParameterizedTest
    @CsvFileSource(resources="/fibonacci.csv", numLinesToSkip = 1)
    public void testFibonacci(int input, int expected){
        NumberChecker nc = new NumberChecker();
        assertEquals(expected, nc.fibonacci(input));
    }
}