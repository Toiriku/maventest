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
    void testKelvinToCelsius() {
        assertEquals(0, TemperatureConverter.kelvinToCelsius(273.15), 0.01);
        assertEquals(100, TemperatureConverter.kelvinToCelsius(373.15), 0.01);
    }
}
