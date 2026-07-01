package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.exception.CountryNotFoundException;
import com.cognizant.spring_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.ArrayList;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    private final CountryService countryService;

    public CountryController (CountryService countryService){
        this.countryService=countryService;
    }
    @RequestMapping("/india")
    public Country getCountryIndia() {

        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);

        LOGGER.info("END");
        return country;
    }

    @GetMapping
    public ArrayList<Country> getAllCountries() {

        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
        LOGGER.info("END");

        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {

        LOGGER.info("START");
        Country country = countryService.getCountry(code);
        LOGGER.info("END");

        return country;
    }

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {

        LOGGER.info("Start");
        LOGGER.debug("Country : {}", country);
        LOGGER.info("End");

        return country;
    }
}