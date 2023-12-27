package com.finaltraining.hotelbooking.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelBookingConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
