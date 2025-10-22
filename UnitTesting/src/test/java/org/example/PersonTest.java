package org.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonTest {
    //Task 3
    @Order(2)
    @Test
    public void assertIsAdult(){
        Person p = new Person(20);
        assertTrue(p.isAdult());
    }
    @Test
    public void assertIsChild(){
        Person p = new Person(2);
        assertFalse(p.isAdult());
    }

    //Task5
    @Test
    public void assertEveryoneIsAdult(){
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(20),
                new Person(32),
                new Person(18),
                new Person(40),
                new Person(41)
        ));
        for(Person p : people){
            assertTrue(p.isAdult());
        }
        people.clear();
    }

    //Task 6
    @Order(1)
    @Test
    public void assertCanGoToSchool(){
        Person p1 = new Person(1);
        Person p2 = new Person(7);
        assertFalse(p1.canGoToSchool());
        assertTrue(p2.canGoToSchool());
    }

    //Task 7
    @Test
    public void assertThrowsExceptionOnNegativeAge(){
        Exception e = assertThrows(IllegalArgumentException.class, ()->{
           Person p = new Person(-2);
        });
        assertEquals("A person's age cannot be negative!", e.getMessage());
    }
}