package org.parameterizedtesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/radii.csv")
    public void testAreaCalculation(
            @ConvertWith(CircleConverter.class) Circle c, double expected
    ){
        assertEquals(expected, c.calculateArea());
    }
}