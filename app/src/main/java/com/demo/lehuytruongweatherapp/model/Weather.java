package com.demo.lehuytruongweatherapp.model;

public class Weather {
    private  String DateTime;
    private static int WeatherIcon;
    private String IconPhrase;
    private Temperature Temperature;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public static int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public com.demo.lehuytruongweatherapp.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.demo.lehuytruongweatherapp.model.Temperature temperature) {
        Temperature = temperature;
    }
}

