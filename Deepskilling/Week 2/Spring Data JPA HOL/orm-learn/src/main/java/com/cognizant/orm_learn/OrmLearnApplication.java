package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) throws Exception{

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class,args);

		countryService = context.getBean(CountryService.class);

		//testGetAllCountries();
		testAddCountry();

		LOGGER.info("Inside main");
	}

	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries =
				countryService.getAllCountries();

		LOGGER.debug("Countries={}",countries);

		LOGGER.info("End");
	}

	private static void testAddCountry() throws Exception {

		LOGGER.info("Start");
		Country country = new Country("RG", "RagulLand");
		countryService.addCountry(country);
		Country result = countryService.findCountryByCode("RG");
		LOGGER.debug("Country={}", result);
		LOGGER.info("End");
	}

	private static void testUpdateCountry() throws Exception {

		LOGGER.info("Start");
		countryService.updateCountry("RG", "Ragul Country");

		Country country = countryService.findCountryByCode("RG");
		LOGGER.debug("Country={}", country);

		LOGGER.info("End");
	}
}