package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, TemperatureConverter.fahrenheitToCelsius(32), 0.01);
        assertEquals(100, TemperatureConverter.fahrenheitToCelsius(212), 0.01);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32, TemperatureConverter.celsiusToFahrenheit(0), 0.01);
        assertEquals(212, TemperatureConverter.celsiusToFahrenheit(100), 0.01);
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(TemperatureConverter.isExtremeTemperature(-50));
        assertTrue(TemperatureConverter.isExtremeTemperature(51));
        assertFalse(TemperatureConverter.isExtremeTemperature(20));
    }
    @Test
    void testKelvinToCelsius() {
        assertEquals(0, TemperatureConverter.kelvinToCelsius(273.15), 0.01);
        assertEquals(100, TemperatureConverter.kelvinToCelsius(373.15), 0.01);
    }
}
