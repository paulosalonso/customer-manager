package com.github.paulosalonso.customer.application.api.v1.model.contact;

import com.github.paulosalonso.customer.domain.ContactType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("ContactCreate")
public class ContactCreateDTO {

    @ApiModelProperty(example = "EMAIL", required = true)
    @NotNull
    private ContactType type;

    @ApiModelProperty(example = "mail@mail.com", required = true)
    @NotBlank
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

        private ContactCreateDTO contactCreateDTO;

        private Builder() {
            this.contactCreateDTO = new ContactCreateDTO();
        }

        public Builder type(ContactType type) {
            contactCreateDTO.type = type;
            return this;
        }

        public Builder contact(String contact) {
            contactCreateDTO.contact = contact;
            return this;
        }

        public ContactCreateDTO build() {
            return contactCreateDTO;
        }
    }
}
