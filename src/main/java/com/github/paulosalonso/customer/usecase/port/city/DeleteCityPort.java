package com.github.paulosalonso.customer.usecase.port.city;

import com.github.paulosalonso.customer.domain.City;

public interface DeleteCityPort {
    void delete(City city);
    void deleteById(String id);
}
