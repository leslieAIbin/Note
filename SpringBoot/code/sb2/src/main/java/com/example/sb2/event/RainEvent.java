package com.example.sb2.event;


import org.springframework.stereotype.Component;

@Component
public class RainEvent extends WeatherEvent{
    @Override
    public String getWeather() {
        return "rain";
    }
}
