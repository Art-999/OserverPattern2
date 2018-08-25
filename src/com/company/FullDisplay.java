package com.company;

import com.company.interfaces.DispalyElement;
import com.company.interfaces.Observer;
import com.company.interfaces.Subject;

public class FullDisplay implements Observer, DispalyElement {
    private float temp;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public FullDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("temp: " + temp + ", humidity: " + humidity + ", pressure: " + pressure);
    }

    public void unRegister(){
        weatherData.removeObserver(this);
    }
}
