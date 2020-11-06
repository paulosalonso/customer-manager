package com.github.paulosalonso.customer.application.configuration;

import com.github.paulosalonso.customer.usecase.publisher.Publisher;
import com.github.paulosalonso.customer.usecase.publisher.PublisherImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfiguration {

    @Bean
    public Publisher publisher() {
        return new PublisherImpl();
    }
}
