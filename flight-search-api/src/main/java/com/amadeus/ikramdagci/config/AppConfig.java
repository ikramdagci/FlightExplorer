package com.amadeus.ikramdagci.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.time.Duration;

@Configuration
public class AppConfig {

    @Value("${spring.data.redis.ttl}")
    private Long timeToLiveInMinutes;
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

    @Bean
    public RedisCacheConfiguration defaultCacheConfig() {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(timeToLiveInMinutes))
                .disableCachingNullValues();
    }


}
