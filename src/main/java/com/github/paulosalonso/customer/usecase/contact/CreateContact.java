package com.github.paulosalonso.customer.usecase.contact;

import com.github.paulosalonso.customer.domain.Contact;
import com.github.paulosalonso.customer.usecase.exception.CreateException;
import com.github.paulosalonso.customer.usecase.port.contact.CreateContactPort;
import com.github.paulosalonso.customer.usecase.port.customer.ReadCustomerPort;

public class CreateContact {

    private final CreateContactPort createContactPort;
    private final ReadCustomerPort readCustomerPort;

    public CreateContact(CreateContactPort createContactPort, ReadCustomerPort readCustomerPort) {
        this.createContactPort = createContactPort;
        this.readCustomerPort = readCustomerPort;
    }

    public Contact create(Contact contact) {
        if (!readCustomerPort.existsById(contact.getCustomer().getId())) {
            throw new CreateException("Customer not found");
        }

        return createContactPort.create(contact);
    }
}
