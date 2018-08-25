package com.company;

import com.company.interfaces.Subject;

public class Main {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        TempDisplay tempDisplay = new TempDisplay();
        tempDisplay.register(weatherData);
        // tempDisplay.unRegister();
        HumidityDisplay humidityDisplay = new HumidityDisplay(weatherData);
        FullDisplay fullDisplay = new FullDisplay(weatherData);


        weatherData.setMeasurments(29, 56, 98);
    }
}
