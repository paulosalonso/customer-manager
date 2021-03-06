package com.github.paulosalonso.customer.application.configuration;

import com.github.paulosalonso.customer.adapter.controller.CustomerController;
import com.github.paulosalonso.customer.adapter.event.CustomerCreatedListener;
import com.github.paulosalonso.customer.adapter.kafka.producer.NotificationProducer;
import com.github.paulosalonso.customer.usecase.city.CreateCity;
import com.github.paulosalonso.customer.usecase.customer.CreateCustomer;
import com.github.paulosalonso.customer.usecase.customer.DeleteCustomer;
import com.github.paulosalonso.customer.usecase.customer.ReadCustomer;
import com.github.paulosalonso.customer.usecase.customer.UpdateCustomer;
import com.github.paulosalonso.customer.usecase.port.customer.CreateCustomerPort;
import com.github.paulosalonso.customer.usecase.port.customer.DeleteCustomerPort;
import com.github.paulosalonso.customer.usecase.port.customer.ReadCustomerPort;
import com.github.paulosalonso.customer.usecase.port.customer.UpdateCustomerPort;
import com.github.paulosalonso.customer.usecase.publisher.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CustomerConfiguration {

    @Bean
    public CreateCustomer createCustomer(
            CreateCustomerPort createCustomerPort, CreateCity createCity, Publisher publisher) {
        return new CreateCustomer(createCustomerPort, createCity, publisher);
    }

    @Bean
    public ReadCustomer readCustomer(ReadCustomerPort readCustomerPort) {
        return new ReadCustomer(readCustomerPort);
    }

    @Bean
    public UpdateCustomer updateCustomer(UpdateCustomerPort updateCustomerPort, CreateCity createCity) {
        return new UpdateCustomer(updateCustomerPort, createCity);
    }

    @Bean
    public DeleteCustomer deleteCustomer(DeleteCustomerPort deleteCustomerPort) {
        return new DeleteCustomer(deleteCustomerPort);
    }

    @Bean
    public CustomerController customerController(CreateCustomer createCustomer,
            ReadCustomer readCustomer, UpdateCustomer updateCustomer, DeleteCustomer deleteCustomer) {
        return new CustomerController(createCustomer, readCustomer, updateCustomer, deleteCustomer);
    }

    @Profile("customer-creation-notifier")
    @Bean
    public CustomerCreatedListener customerCreatedListener(Publisher publisher, NotificationProducer notificationProducer) {
        return new CustomerCreatedListener(publisher, notificationProducer);
    }
}
