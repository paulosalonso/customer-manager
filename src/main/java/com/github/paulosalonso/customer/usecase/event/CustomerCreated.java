package com.github.paulosalonso.customer.usecase.event;

import com.github.paulosalonso.customer.domain.Customer;

public class CustomerCreated {

    private Customer customer;

    private CustomerCreated(Customer customer) {
        this.customer = customer;
    }

    public static CustomerCreated of(Customer customer) {
        return new CustomerCreated(customer);
    }

    public Customer getCustomer() {
        return customer;
    }
}
