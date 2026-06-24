package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

        Optional<Country> country = countryRepository.findById(countryCode);

        if(country.isEmpty()) {
            throw new CountryNotFoundException("Country Not Found");
        }

        return country.get();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
}