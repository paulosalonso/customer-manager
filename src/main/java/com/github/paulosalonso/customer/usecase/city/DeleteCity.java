package com.github.paulosalonso.customer.usecase.city;

import com.github.paulosalonso.customer.domain.City;
import com.github.paulosalonso.customer.usecase.port.city.DeleteCityPort;

public class DeleteCity {

    private final DeleteCityPort deleteCityPort;

    public DeleteCity(DeleteCityPort deleteCityPort) {
        this.deleteCityPort = deleteCityPort;
    }

    public void delete(City city) {
        deleteCityPort.delete(city);
    }

    public void deleteById(String id) {
        deleteCityPort.deleteById(id);
    }
}
