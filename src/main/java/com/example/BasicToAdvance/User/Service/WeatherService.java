package com.example.BasicToAdvance.User.Service;


import com.example.BasicToAdvance.User.Redis.RedisService;
import com.example.BasicToAdvance.User.WeatherApi.WeatherResponseDTO;
import com.example.BasicToAdvance.User.WeatherApi.WeatherSummaryDTO;
import org.hibernate.envers.Audited;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final RedisService redisService;

    //    @Value("${weather.api.url}")
    private String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=city&appid=API_KEY";

    //    @Value("${weather.api.key}")
    private String apiKey = "6d442aacd036786994bb1e2f8fd52854";


    public WeatherService(RestTemplate restTemplate, RedisService redisService) {
        this.restTemplate = restTemplate;
        this.redisService = redisService;
    }



    public WeatherSummaryDTO getWeatherSummary(String city) {
        WeatherSummaryDTO respons = redisService.getValue("weather_of_" + city, WeatherSummaryDTO.class);
        if (respons != null) {
            return respons;
        } else {
            String url = apiUrl.replace("API_KEY", apiKey).replace("city", city);
            WeatherResponseDTO response = restTemplate.getForObject(url, WeatherResponseDTO.class);
            WeatherSummaryDTO summary = WeatherSummaryDTO.fromResponse(response);
            if (summary != null) {
                redisService.setValue("weather_of_" + city, summary, 300L);
            }
            return summary;
        }


    }
}
