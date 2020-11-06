package com.github.paulosalonso.customer.usecase.customer;

import com.github.paulosalonso.customer.domain.Customer;
import com.github.paulosalonso.customer.usecase.Page;
import com.github.paulosalonso.customer.usecase.exception.NotFoundException;
import com.github.paulosalonso.customer.usecase.port.customer.CustomerCriteria;
import com.github.paulosalonso.customer.usecase.port.customer.ReadCustomerPort;

import java.util.List;

public class ReadCustomer {

    private final ReadCustomerPort readCustomerPort;

    public ReadCustomer(ReadCustomerPort readCustomerPort) {
        this.readCustomerPort = readCustomerPort;
    }

    public Customer findById(Long id) {
        return readCustomerPort.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<Customer> findAll() {
        return readCustomerPort.findAll();
    }

    public Page<Customer> findByCriteria(CustomerCriteria criteria) {
        return readCustomerPort.findByCriteria(criteria);
    }
}
