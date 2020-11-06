package com.github.paulosalonso.customer.adapter.controller;

import com.github.paulosalonso.customer.adapter.controller.mapper.CityAdapterMapper;
import com.github.paulosalonso.customer.adapter.controller.mapper.CityCriteriaAdapterMapper;
import com.github.paulosalonso.customer.adapter.controller.mapper.PageAdapterMapper;
import com.github.paulosalonso.customer.adapter.controller.model.PageAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.city.CityCreateAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.city.CityCriteriaAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.city.CityResponseAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.city.CityUpdateAdapter;
import com.github.paulosalonso.customer.domain.City;
import com.github.paulosalonso.customer.usecase.Page;
import com.github.paulosalonso.customer.usecase.city.CreateCity;
import com.github.paulosalonso.customer.usecase.city.DeleteCity;
import com.github.paulosalonso.customer.usecase.city.ReadCity;
import com.github.paulosalonso.customer.usecase.city.UpdateCity;

import static com.github.paulosalonso.customer.adapter.controller.mapper.CityAdapterMapper.from;
import static com.github.paulosalonso.customer.adapter.controller.mapper.CityAdapterMapper.to;

public class CityController {

    private final CreateCity createCity;
    private final ReadCity readCity;
    private final UpdateCity updateCity;
    private final DeleteCity deleteCity;

    public CityController(CreateCity createCity, ReadCity readCity, UpdateCity updateCity, DeleteCity deleteCity) {
        this.createCity = createCity;
        this.readCity = readCity;
        this.updateCity = updateCity;
        this.deleteCity = deleteCity;
    }

    public PageAdapter<CityResponseAdapter> search(CityCriteriaAdapter cityCriteriaAdapter) {
        Page<City> page = readCity.findByCriteria(CityCriteriaAdapterMapper.to(cityCriteriaAdapter));
        return PageAdapterMapper.from(page, CityAdapterMapper::from);
    }

    public CityResponseAdapter create(CityCreateAdapter cityCreateAdapter) {
        City city = createCity.create(to(cityCreateAdapter));
        return from(city);
    }

    public CityResponseAdapter read(String ibgeCode) {
        City city = readCity.findById(ibgeCode);
        return from(city);
    }

    public CityResponseAdapter update(String ibgeCode, CityUpdateAdapter cityUpdateAdapter) {
        City city = readCity.findById(ibgeCode);
        return from(updateCity.update(to(cityUpdateAdapter, city)));
    }

    public void delete(String ibgeCode) {
        deleteCity.deleteById(ibgeCode);
    }
}
