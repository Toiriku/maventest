package com.example;
public class TemperatureConverter {

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}
