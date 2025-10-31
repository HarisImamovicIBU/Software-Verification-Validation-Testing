package org.CodeCoverage;

import org.junit.jupiter.api.Test;

import static org.CodeCoverage.BinarySearch.search;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    void testElementNotFound(){
        int[] testArray = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(-1, search(testArray, 11));
    }
    @Test
    void testElementFoundFirst(){
        int[] testArray = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(0, search(testArray, 1));
    }
    @Test
    void testElementFoundMiddle(){
        int[] testArray = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(4, search(testArray, 5));
    }
    @Test
    void testElementFoundLast(){
        int[] testArray = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(9, search(testArray, 10));
    }

}