package com.github.paulosalonso.customer.usecase.customer;

import com.github.paulosalonso.customer.domain.Customer;
import com.github.paulosalonso.customer.usecase.port.customer.DeleteCustomerPort;

public class DeleteCustomer {

    private final DeleteCustomerPort deleteCustomerPort;

    public DeleteCustomer(DeleteCustomerPort deleteCustomerPort) {
        this.deleteCustomerPort = deleteCustomerPort;
    }

    public void delete(Customer customer) {
        deleteCustomerPort.delete(customer);
    }

    public void deleteById(Long id) {
        deleteCustomerPort.deleteById(id);
    }
}
