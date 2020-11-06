package com.github.paulosalonso.customer.usecase.port.city;

import com.github.paulosalonso.customer.domain.City;

public interface CreateCityPort {
    City create(City city);
}
