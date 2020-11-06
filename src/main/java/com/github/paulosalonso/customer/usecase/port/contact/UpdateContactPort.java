package com.github.paulosalonso.customer.usecase.port.contact;

import com.github.paulosalonso.customer.domain.Contact;

public interface UpdateContactPort {
    Contact update(Contact contact);
}
