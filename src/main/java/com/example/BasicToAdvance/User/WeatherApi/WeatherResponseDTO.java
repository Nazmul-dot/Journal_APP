package com.example.BasicToAdvance.User.WeatherApi;
import lombok.Data;
import java.util.List;

@Data
public class WeatherResponseDTO {
    private Coord coord;
    private List<Weather> weather;
    private Main main;
    private String name; // City name

    @Data
    public static class Coord {
        private double lon;
        private double lat;
    }

    @Data
    public static class Weather {
        private String main;
        private String description;
        private String icon;
    }

    @Data
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
    }
}