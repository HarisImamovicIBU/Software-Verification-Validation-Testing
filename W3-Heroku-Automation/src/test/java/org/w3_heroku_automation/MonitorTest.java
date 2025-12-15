package org.w3_heroku_automation;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class MonitorTest {
    @Test
    @Order(1)
    void calculateMonitorAge_POSITIVE(){
        Monitor m1 = new Monitor("Dell", 27, 400, 2020, 144);
        assertEquals(5, m1.calculateMonitorAge());
    }
    @Test
    @Order(2)
    void calculateMonitorAge_NEGATIVE() {
        Monitor m2 = new Monitor("Dell", 27, 400, 2023, 144);
        assertNotEquals(5, m2.calculateMonitorAge());
    }
    @Test
    @Order(3)
    void calculateDiscount_positive() {
        Monitor monitor = new Monitor("Samsung", 24, 500, 2019, 75);
        assertEquals(100, monitor.calculateDiscount());
    }

    @Test
    @Order(4)
    void calculateDiscount_negative() {
        Monitor monitor = new Monitor("Samsung", 24, 500, 2024, 75);
        assertNotEquals(100, monitor.calculateDiscount());
    }

    @Test
    @Order(5)
    void isPremiumMonitor_positive() {
        Monitor monitor = new Monitor("Dell", 27, 700, 2022, 144);
        assertTrue(monitor.isPremiumMonitor());
    }

    @Test
    @Order(6)
    void isPremiumMonitor_negative() {
        Monitor monitor = new Monitor("HP", 27, 700, 2022, 144);
        assertFalse(monitor.isPremiumMonitor());
    }

    @ParameterizedTest
    @Order(7)
    @CsvFileSource(resources = "/premiums.csv", numLinesToSkip = 1)
    void isPremiumMonitor_CSV(String manufacturer,
                              double screenSize,
                              double price,
                              int year,
                              int refreshRate,
                              boolean expected){
        Monitor m3 = new Monitor(manufacturer, screenSize, price, year, refreshRate);
        assertEquals(expected, m3.isPremiumMonitor());

    }

}



















