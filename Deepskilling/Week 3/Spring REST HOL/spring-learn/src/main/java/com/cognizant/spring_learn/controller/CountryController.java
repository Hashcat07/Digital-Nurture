package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    private CountryService countryService=new CountryService();

    @RequestMapping("/country")
    public Country getCountryIndia() {

        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);

        LOGGER.info("END");
        return country;
    }

    @GetMapping("/countries")
    public ArrayList<Country> getAllCountries() {

        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
        LOGGER.info("END");

        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        LOGGER.info("START");
        Country country = countryService.getCountry(code);
        LOGGER.info("END");

        return country;
    }
}