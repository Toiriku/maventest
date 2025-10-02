package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField inputField;
    private ComboBox<String> fromUnit;
    private ComboBox<String> toUnit;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Temperature Converter");

        Label titleLabel = new Label("Temperature Converter");

        Label inputLabel = new Label("Enter Temperature:");
        inputField = new TextField();
        inputField.setPromptText("Enter value");

        Label fromLabel = new Label("From:");
        fromUnit = new ComboBox<>();
        fromUnit.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
        fromUnit.setValue("Fahrenheit");

        Label toLabel = new Label("To:");
        toUnit = new ComboBox<>();

        Button convertButton = new Button("Convert");

        resultLabel = new Label("Result: ");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        HBox inputBox = new HBox(10);
        inputBox.getChildren().addAll(inputLabel, inputField);

        HBox fromBox = new HBox(10);
        fromBox.getChildren().addAll(fromLabel, fromUnit);

        HBox toBox = new HBox(10);
        toBox.getChildren().addAll(toLabel, toUnit);

        root.getChildren().addAll(titleLabel, inputBox, fromBox, toBox, convertButton, resultLabel);

        fromUnit.setOnAction(e -> updateToUnit());
        updateToUnit();

        convertButton.setOnAction(e -> convertTemperature());
        inputField.setOnAction(e -> convertTemperature());

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateToUnit() {
        String from = fromUnit.getValue();
        toUnit.getItems().clear();

        if (from.equals("Fahrenheit")) {
            toUnit.getItems().add("Celsius");
            toUnit.setValue("Celsius");
        } else if (from.equals("Celsius")) {
            toUnit.getItems().add("Kelvin");
            toUnit.setValue("Kelvin");
        } else if (from.equals("Kelvin")) {
            toUnit.getItems().add("Celsius");
            toUnit.setValue("Celsius");
        }
    }

    private void convertTemperature() {
        try {
            double input = Double.parseDouble(inputField.getText());
            String from = fromUnit.getValue();
            String to = toUnit.getValue();

            double result = convert(input, from, to);
            resultLabel.setText(String.format("Result: %.2f %s", result, to));
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number");
        }
    }

    private double convert(double value, String from, String to) {
        if (from.equals("Fahrenheit") && to.equals("Celsius")) {
            return TemperatureConverter.fahrenheitToCelsius(value);
        } else if (from.equals("Celsius") && to.equals("Kelvin")) {
            return TemperatureConverter.celsiusToKelvin(value);
        } else if (from.equals("Kelvin") && to.equals("Celsius")) {
            return TemperatureConverter.kelvinToCelsius(value);
        }
        return value;
    }

    public static void main(String[] args) {
        launch(args);
    }
}