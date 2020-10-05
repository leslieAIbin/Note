package com.example.sb2.event;

import org.springframework.stereotype.Component;

@Component
public class SnowEvent extends WeatherEvent{
    @Override
    public String getWeather() {
        return "snow";
    }
}
