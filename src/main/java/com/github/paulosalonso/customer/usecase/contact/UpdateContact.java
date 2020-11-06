package com.github.paulosalonso.customer.usecase.contact;

import com.github.paulosalonso.customer.domain.Contact;
import com.github.paulosalonso.customer.usecase.port.contact.ReadContactPort;
import com.github.paulosalonso.customer.usecase.port.contact.UpdateContactPort;
import com.github.paulosalonso.customer.usecase.port.customer.ReadCustomerPort;

public class UpdateContact {

    private final UpdateContactPort updateContactPort;
    private final ReadContactPort readContactPort;
    private final ReadCustomerPort readCustomerPort;

    public UpdateContact(UpdateContactPort updateContactPort,
            ReadContactPort readContactPort, ReadCustomerPort readCustomerPort) {
        this.updateContactPort = updateContactPort;
        this.readContactPort = readContactPort;
        this.readCustomerPort = readCustomerPort;
    }

    public Contact update(Contact contact) {
        return updateContactPort.update(contact);
    }
}
