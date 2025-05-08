package com.example.BasicToAdvance.User.WeatherApi;

import lombok.Data;

@Data
public class WeatherSummaryDTO {
    private String city;
    private String description;
    private double temperature;
    private double feelsLike;
    private int humidity;

    public static WeatherSummaryDTO fromResponse(WeatherResponseDTO response) {
        WeatherSummaryDTO summary = new WeatherSummaryDTO();
        summary.setCity(response.getName());
        summary.setDescription(response.getWeather().get(0).getDescription());
        summary.setTemperature(response.getMain().getTemp());
        summary.setFeelsLike(response.getMain().getFeels_like());
        summary.setHumidity(response.getMain().getHumidity());
        return summary;
    }
}