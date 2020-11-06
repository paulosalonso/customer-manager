package com.github.paulosalonso.customer.usecase.port.city;

import com.github.paulosalonso.customer.usecase.Criteria;

import java.util.Map;

public class CityCriteria extends Criteria {
    private String name;
    private String state;

    public static Builder of() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static final class Builder {

        private CityCriteria cityCriteria;

        private Builder() {
            cityCriteria = new CityCriteria();
        }

        public Builder page(int page) {
            cityCriteria.setPage(page);
            return this;
        }

        public Builder size(int size) {
            cityCriteria.setSize(size);
            return this;
        }

        public Builder sort(Map<String, SortDirection> sort) {
            cityCriteria.setSort(sort);
            return this;
        }

        public Builder name(String name) {
            cityCriteria.setName(name);
            return this;
        }

        public Builder state(String state) {
            cityCriteria.setState(state);
            return this;
        }

        public CityCriteria build() {
            return cityCriteria;
        }
    }
}
