package com.github.paulosalonso.customer.adapter.controller.model.contact;

import com.github.paulosalonso.customer.domain.ContactType;

public class ContactCreateAdapter {

    private ContactType type;
    private String contact;

    public static Builder of() {
        return new Builder();
    }

    public ContactType getType() {
        return type;
    }

    public String getContact() {
        return contact;
    }

    public static final class Builder {

        private ContactCreateAdapter contactCreateAdapter;

        private Builder() {
            this.contactCreateAdapter = new ContactCreateAdapter();
        }

        public Builder type(ContactType type) {
            contactCreateAdapter.type = type;
            return this;
        }

        public Builder contact(String contact) {
            contactCreateAdapter.contact = contact;
            return this;
        }

        public ContactCreateAdapter build() {
            return contactCreateAdapter;
        }
    }
}
