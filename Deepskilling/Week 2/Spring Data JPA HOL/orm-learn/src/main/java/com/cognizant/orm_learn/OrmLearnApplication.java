package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;
	
	private static StockRepository stockRepository;

	public static void main(String[] args) throws Exception{

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class,args);

		countryService = context.getBean(CountryService.class);
		stockRepository=context.getBean(StockRepository.class);

//		testGetAllCountries();
//		testAddCountry();
//		testCountriesStartingWith();
//		testSearchCountries();
//		testSearchCountriesSorted();
//		testDeleteCountry();
		testFacebookStocks();
		testGoogleStocks();
		testNetflixStocks();
		testTopVolumeStock();
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

	private static void testSearchCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.searchCountries("ou");
		LOGGER.debug("Countries={}", countries);
		LOGGER.info("End");
	}

	private static void testSearchCountriesSorted() {
		LOGGER.info("Start");
		List<Country> countries = countryService.searchCountriesSorted("ou");
		LOGGER.debug("Countries={}", countries);
		LOGGER.info("End");
	}

	private static void testCountriesStartingWith() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getCountriesStartingWith("Z");
		LOGGER.debug("Countries={}", countries);
		LOGGER.info("End");
	}

	private static void testDeleteCountry() {

		LOGGER.info("Start");
		countryService.deleteCountry("RG");
		LOGGER.info("Country Deleted");
		LOGGER.info("End");
	}

	private static void testFacebookStocks(){
		List<Stock> stock=stockRepository.findByCodeAndDateBetween("FB", LocalDate.of(2019,9,1),LocalDate.of(2019,9,30));
		stock.forEach(System.out::println);
	}

	private static void testGoogleStocks(){
		List<Stock> stock=stockRepository.findByCodeAndCloseGreaterThan("GOOGL",1250);
		stock.forEach(System.out::println);
	}

	private static void testTopVolumeStock(){
		stockRepository.findTop3ByOrderByVolumeDesc().forEach(System.out::println);
	}

	private static void testNetflixStocks(){
		stockRepository.findTop3ByOrderByVolumeDesc().forEach(System.out::println);
	}

}