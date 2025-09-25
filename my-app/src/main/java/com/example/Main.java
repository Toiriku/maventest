package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("32F -> " + TemperatureConverter.fahrenheitToCelsius(32) + " C");
        System.out.println("100C -> " + TemperatureConverter.celsiusToFahrenheit(100) + " F");
        System.out.println("-50 extreme? " + TemperatureConverter.isExtremeTemperature(-50));
        System.out.println("300K -> " + TemperatureConverter.kelvinToCelsius(300) + " C");
    }
}
