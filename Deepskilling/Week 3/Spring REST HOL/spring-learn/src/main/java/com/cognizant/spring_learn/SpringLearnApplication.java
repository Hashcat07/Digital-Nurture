package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws Exception {

		SpringApplication.run(SpringLearnApplication.class, args);
//		displayDate();
//		displayCountry();
//		displayCountries();
	}

	public static void displayDate() throws Exception{

		LOGGER.info("Start");
		ApplicationContext context=new ClassPathXmlApplicationContext("date-format.xml");

		SimpleDateFormat format= context.getBean("dateFormat", SimpleDateFormat.class);

		Date date=format.parse("31/12/2018");

		LOGGER.debug("{}",date);

		LOGGER.info("END");
	}

	public static void displayCountry(){
		LOGGER.info("Start");

		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("country",Country.class);
		Country anotherCountry=context.getBean("country",Country.class);

		LOGGER.debug("Country {}", country.toString());
		LOGGER.info("END");
	}

	public static void displayCountries(){

		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);

		LOGGER.debug("Countries : {}", countries);
		LOGGER.info("END");
	}

}
