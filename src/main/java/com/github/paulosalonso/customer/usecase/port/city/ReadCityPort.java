package com.github.paulosalonso.customer.usecase.port.city;

import com.github.paulosalonso.customer.domain.City;
import com.github.paulosalonso.customer.usecase.Page;

import java.util.List;
import java.util.Optional;

public interface ReadCityPort {

    boolean existsById(String id);
    boolean existsByPostalCode(String postalCode);
    Optional<City> findById(String id);
    Optional<City> findByPostalCode(String postalCode);
    List<City> findAll();
    Page<City> findByCriteria(CityCriteria criteria);

}
