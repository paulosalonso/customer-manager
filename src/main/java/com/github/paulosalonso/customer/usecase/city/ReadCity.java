package com.github.paulosalonso.customer.usecase.city;

import com.github.paulosalonso.customer.domain.City;
import com.github.paulosalonso.customer.usecase.Page;
import com.github.paulosalonso.customer.usecase.exception.NotFoundException;
import com.github.paulosalonso.customer.usecase.port.city.CityCriteria;
import com.github.paulosalonso.customer.usecase.port.city.ReadCityPort;

import java.util.List;

public class ReadCity {

    private final ReadCityPort readCityPort;

    public ReadCity(ReadCityPort readCityPort) {
        this.readCityPort = readCityPort;
    }

    public City findById(String id) {
        return readCityPort.findById(id).orElseThrow(NotFoundException::new);
    }

    public City findByPostalCode(String postalCode) {

        return null;
    }

    public List<City> findAll() {
        return readCityPort.findAll();
    }

    public Page<City> findByCriteria(CityCriteria criteria) {
        return readCityPort.findByCriteria(criteria);
    }
}
