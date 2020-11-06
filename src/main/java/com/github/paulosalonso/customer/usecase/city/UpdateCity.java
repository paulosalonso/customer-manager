package com.github.paulosalonso.customer.usecase.city;

import com.github.paulosalonso.customer.domain.City;
import com.github.paulosalonso.customer.usecase.port.city.UpdateCityPort;

public class UpdateCity {

    private final UpdateCityPort updateCityPort;

    public UpdateCity(UpdateCityPort updateCityPort) {
        this.updateCityPort = updateCityPort;
    }

    public City update(City city) {
        return updateCityPort.update(city);
    }
}
