package com.amadeus.ikramdagci.config;

import com.amadeus.ikramdagci.external.FlightClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfiguration {

    @Value("${api.flight.url}")
    private String flightApiUrl;

    @Bean
    FlightClient productClient(WebClient.Builder builder) {
        WebClientAdapter wca = WebClientAdapter.forClient(builder.baseUrl(flightApiUrl).build());
        return HttpServiceProxyFactory.builder()
                .clientAdapter(wca)
                .build()
                .createClient(FlightClient.class);
    }

}
