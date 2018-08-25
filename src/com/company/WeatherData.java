package com.company;

import com.company.interfaces.Observer;
import com.company.interfaces.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Observer> observersList;
    private float temperature;
    private float humidity;
    private float preassure;

    public WeatherData() {
        observersList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observersList.indexOf(observer);
        if (index >= 0) {
            observersList.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observersList.size(); i++) {
            Observer observer = observersList.get(i);
            observer.update(temperature, humidity, preassure);
        }
    }

    public void measurmentsChanged() {
        notifyObservers();
    }

    public void setMeasurments(float temperature, float humidity, float preassure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.preassure = preassure;
        measurmentsChanged();
    }
}
