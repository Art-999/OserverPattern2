package com.company;

import com.company.interfaces.DispalyElement;
import com.company.interfaces.Observer;
import com.company.interfaces.Subject;

public class TempDisplay implements Observer, DispalyElement {
    private float temp;
    private Subject weatherData;

    public TempDisplay() {
    }

    /**
     * sovorakani pes kanstructori mej chi grac, ayl arandzin methodova grvac
     */
    public void register(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        display();
    }

    @Override
    public void display() {
        System.out.println("temperature: " + temp);
    }

    public void unRegister() {
        if (weatherData != null) {
            weatherData.removeObserver(this);
        }
    }
}
