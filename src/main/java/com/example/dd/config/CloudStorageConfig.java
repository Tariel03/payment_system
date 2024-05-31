package com.example.dd.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudStorageConfig {
    private String cloudName = "dzw1ivbcq";
    private String apiKey = "336757935729446";
    private String apiSecret = "jneM27NpPfmGOov2ITzw3Tyy1RU";

    @Bean
    public Cloudinary cloudinaryConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        return new Cloudinary(config);
    }
}
