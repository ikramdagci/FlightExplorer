package com.amadeus.ikramdagci.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper(){
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ConcurrentTaskScheduler scheduler = new ConcurrentTaskScheduler();
        scheduler.setErrorHandler(throwable -> {
            final Logger schedulerLogger = LoggerFactory.getLogger(ConcurrentTaskScheduler.class);
            schedulerLogger.error("An error occurred during the scheduled task. Error message: {}", throwable.getMessage());
        });
        return scheduler;
    }

}
