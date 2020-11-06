package com.github.paulosalonso.customer.application.api.v1.controller;

import com.github.paulosalonso.customer.application.api.BaseIT;
import com.github.paulosalonso.customer.adapter.controller.model.city.CityResponseAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.contact.ContactCreateAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.customer.AddressAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.customer.CustomerCreateAdapter;
import com.github.paulosalonso.customer.domain.ContactType;
import com.github.paulosalonso.customer.domain.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.Month;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class CustomerContactAPIControllerIT extends BaseIT {

    @Test
    public void whenGetCustomerContactsThenReturnOk() {
        Integer customerId = createCustomer();

        Integer contactId = given()
                .contentType(JSON)
                .accept(JSON)
                .body(ContactCreateAdapter.of()
                        .type(ContactType.EMAIL)
                        .contact("mail@mail.com")
                        .build())
                .post("/v1/customers/{customerId}/contacts", customerId)
                .path("id");

        given()
                .contentType(JSON)
                .accept(JSON)
                .when()
                .get("/v1/customers/{customerId}/contacts", customerId)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", hasItems(contactId))
                .body("customerId", hasItems(customerId))
                .body("type", hasItems("EMAIL"))
                .body("contact", hasItems("mail@mail.com"));
    }

    @Test
    public void whenGetNonExistentCustomerContactsThenReturnNotFound() {
        given()
                .contentType(JSON)
                .accept(JSON)
                .when()
                .get("/v1/customers/{anyCustomerId}/contacts", 1L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void whenCreateContactThenReturnCreated() {
        Integer customerId = createCustomer();

        given()
                .contentType(JSON)
                .accept(JSON)
                .body(ContactCreateAdapter.of()
                        .type(ContactType.EMAIL)
                        .contact("mail@mail.com")
                        .build())
                .when()
                .post("/v1/customers/{customerId}/contacts", customerId)
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", notNullValue())
                .body("customerId", equalTo(customerId))
                .body("type", equalTo("EMAIL"))
                .body("contact", equalTo("mail@mail.com"));
    }

    @Test
    public void whenCreateContactForNonExistentCustomerThenReturnBadRequest() {
        given()
                .contentType(JSON)
                .accept(JSON)
                .body(ContactCreateAdapter.of()
                        .type(ContactType.EMAIL)
                        .contact("mail@mail.com")
                        .build())
                .when()
                .post("/v1/customers/{anyCustomerId}/contacts", 1L)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void whenUpdateContactThenReturnOk() {
        Integer customerId = createCustomer();

        Integer contactId = given()
                .contentType(JSON)
                .accept(JSON)
                .body(ContactCreateAdapter.of()
                        .type(ContactType.EMAIL)
                        .contact("mail@mail.com")
                        .build())
                .when()
                .post("/v1/customers/{customerId}/contacts", customerId)
                .path("id");

        given()
                .contentType(JSON)
                .accept(JSON)
                .body(ContactCreateAdapter.of()
                        .type(ContactType.PHONE)
                        .contact("(00) 00000-0000")
                        .build())
                .when()
                .put("/v1/customers/{customerId}/contacts/{contactId}", customerId, contactId)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("id",equalTo(contactId))
                .body("customerId", equalTo(customerId))
                .body("type", equalTo("PHONE"))
                .body("contact", equalTo("(00) 00000-0000"));
    }

    @Test
    public void whenUpdateContactFromNonExistentCustomerThenReturnNotFound() {
        given()
                .contentType(JSON)
                .accept(JSON)
                .body(ContactCreateAdapter.of()
                        .type(ContactType.PHONE)
                        .contact("(00) 00000-0000")
                        .build())
                .when()
                .put("/v1/customers/{anyCustomerId}/contacts/{anyContactId}", 1L, 1L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void whenUpdateNonExistentContactThenReturnNotFound() {
        Integer customerId = createCustomer();

        given()
                .contentType(JSON)
                .accept(JSON)
                .body(ContactCreateAdapter.of()
                        .type(ContactType.PHONE)
                        .contact("(00) 00000-0000")
                        .build())
                .when()
                .put("/v1/customers/{customerId}/contacts/{anyContactId}", customerId, 1L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void whenDeleteContactThenReturnNoContent() {
        Integer customerId = createCustomer();

        Integer contactId = given()
                .contentType(JSON)
                .accept(JSON)
                .body(ContactCreateAdapter.of()
                        .type(ContactType.EMAIL)
                        .contact("mail@mail.com")
                        .build())
                .when()
                .post("/v1/customers/{customerId}/contacts", customerId)
                .path("id");

        given()
                .contentType(JSON)
                .accept(JSON)
                .when()
                .delete("/v1/customers/{customerId}/contacts/{contactId}", customerId, contactId)
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());

        given()
                .contentType(JSON)
                .accept(JSON)
                .when()
                .get("/v1/customers/{customerId}/contacts", customerId)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("$", hasSize(0));
    }

    @Test
    public void whenDeleteContactFromNonExistentCustomerThenReturnBadRequest() {
        given()
                .contentType(JSON)
                .accept(JSON)
                .when()
                .delete("/v1/customers/{anyCustomerId}/contacts/{anyContactId}", 1L, 1L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void whenDeleteNonExistentContactThenReturnNotFound() {
        Integer customerId = createCustomer();

        given()
                .contentType(JSON)
                .accept(JSON)
                .when()
                .delete("/v1/customers/{customerId}/contacts/{anyContactId}", customerId, 1L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    private Integer createCustomer() {
        mockViaCepJoinville();

        return given()
                .contentType(JSON)
                .accept(JSON)
                .body(CustomerCreateAdapter.of()
                        .name("name")
                        .cpf("cpf")
                        .gender(Gender.MALE)
                        .address(AddressAdapter.of()
                                .city(CityResponseAdapter.of()
                                        .ibgeCode(JOINVILLE_IBGE_CODE)
                                        .build())
                                .street("street")
                                .number("number")
                                .complement("complement")
                                .district("district")
                                .postalCode(JOINVILLE_POSTAL_CODE)
                                .build())
                        .birthDate(LocalDate.of(1988, Month.FEBRUARY, 26))
                        .build())
                .post("/v1/customers")
                .path("id");
    }

}
