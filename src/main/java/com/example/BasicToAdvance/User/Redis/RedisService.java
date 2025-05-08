package com.example.BasicToAdvance.User.Redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public RedisService(RedisTemplate<String, Object> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    // Save data to Redis with TTL (expiration)
    public void setValue(String key, Object obj, long ttlInSeconds) {
        try {
            String jsonValue = objectMapper.writeValueAsString(obj);
            redisTemplate.opsForValue().set(key, jsonValue, ttlInSeconds, TimeUnit.SECONDS);
        } catch (JsonProcessingException e) {
            log.error("Error serializing object to JSON: {}", e.getMessage());
            throw new RuntimeException("Failed to serialize object to JSON", e);
        }
    }

    // Get data from Redis
    public <T> T getValue(String key, Class<T> entityClass) {
        try {
            Object value = redisTemplate.opsForValue().get(key);
            if (value == null) {
                log.info("No value found in Redis for key: {}", key);
                return null;
            }
            return objectMapper.readValue(value.toString(), entityClass);
        } catch (Exception e) {
            log.error("Error deserializing JSON from Redis: {}", e.getMessage());
            throw new RuntimeException("Failed to deserialize JSON from Redis", e);
        }
    }

    // Delete a key
    public Boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }
}
