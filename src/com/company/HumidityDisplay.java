package com.company;

import com.company.interfaces.DispalyElement;
import com.company.interfaces.Observer;
import com.company.interfaces.Subject;

public class HumidityDisplay implements Observer, DispalyElement {
    private float humidity;
    private Subject weatherData;

    public HumidityDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Humidity is: " + humidity);
    }

    public void unRegister(){
        weatherData.removeObserver(this);
    }
}
