package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.repository.StockRepository;
import com.cognizant.orm_learn.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;
	
	private static StockRepository stockRepository;

	private static EmployeeService employeeService;

	private static DepartmentService departmentService;

	private static SkillService skillService;

	private static EmployeeCriteriaService employeeCriteriaService;

	private static AttemptService attemptService;

	public static void main(String[] args) throws Exception{

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class,args);

		countryService = context.getBean(CountryService.class);
		stockRepository=context.getBean(StockRepository.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		employeeCriteriaService = context.getBean(EmployeeCriteriaService.class);
		attemptService=context.getBean(AttemptService.class);

//		testGetAllCountries();
//		testAddCountry();
//		testCountriesStartingWith();
//		testSearchCountries();
//		testSearchCountriesSorted();
//		testDeleteCountry();
//		testFacebookStocks();
//		testGoogleStocks();
//		testNetflixStocks();
//		testTopVolumeStock();
//		testGetEmployee();
//		testAddEmployee();
		testGetDepartment();
		testGetAttempt();
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
		LOGGER.info("Start - Facebook Stocks");
		List<Stock> stock=stockRepository.findByCodeAndDateBetween("FB",LocalDate.of(2019,9,1),LocalDate.of(2019,9,30));
		stock.forEach(s->LOGGER.debug("Stock: {}",s));
		LOGGER.info("End - Facebook Stocks");
	}

	private static void testGoogleStocks(){
		LOGGER.info("Start - Google Stocks");
		List<Stock> stock=stockRepository.findByCodeAndCloseGreaterThan("GOOGL",1250);
		stock.forEach(s->LOGGER.debug("Stock: {}",s));
		LOGGER.info("End - Google Stocks");
	}

	private static void testTopVolumeStock(){
		LOGGER.info("Start - Top Volume Stocks");
		stockRepository.findTop3ByOrderByVolumeDesc().forEach(s->LOGGER.debug("Stock: {}",s));
		LOGGER.info("End - Top Volume Stocks");
	}

	private static void testNetflixStocks(){
		LOGGER.info("Start - Netflix Lowest Stocks");
		stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX").forEach(s->LOGGER.debug("Stock: {}",s));
		LOGGER.info("End - Netflix Lowest Stocks");
	}

	private static void testGetEmployee() {

		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills: {}",employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testAddEmployee() {

		LOGGER.info("Start");

		Employee employee = new Employee();
		employee.setName("Ragul");
		employee.setSalary(50000);
		employee.setPermanent(true);
		Department department = departmentService.get(1);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {

		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Department newDept = departmentService.get(2);
		employee.setDepartment(newDept);
		employeeService.save(employee);
		LOGGER.debug("Updated Employee: {}", employee);
		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {

		LOGGER.info("Start");

		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(1);
		employee.getSkillList().add(skill);
		employeeService.save(employee);
		LOGGER.debug("Employee with skills updated: {}", employee);
		LOGGER.info("End");
	}

	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department department = departmentService.get(2);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("Employees:{}", department.getEmployees());
		LOGGER.info("End");
	}

	private static void testGetAllPermanentEmployees(){
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		employees.forEach(e -> LOGGER.debug("Employee: {}", e));
		LOGGER.info("End");
	}

	private static void testAverageSalary(){
		LOGGER.info("Start");
		double avg = employeeService.getAverageSalary(1);
		LOGGER.debug("Average Salary: {}", avg);
		LOGGER.info("End");
	}

	private static void testNativeEmployees(){
		LOGGER.info("Start");
		employeeService.getAllEmployeesNative()
				.forEach(e -> LOGGER.debug("Employee: {}", e));
		LOGGER.info("End");
	}

	private static void testCriteria(){
		LOGGER.info("Start");
		employeeCriteriaService.getPermanentEmployees()
				.forEach(e -> LOGGER.debug("Employee: {}", e));
		LOGGER.info("End");
	}

	private static void testGetAttempt() {
		LOGGER.info("Start");
		Attempt attempt = attemptService.getAttempt(1, 1);
		LOGGER.debug("User: {}", attempt.getUser().getName());
		LOGGER.debug("Attempted Date: {}", attempt.getDate());

		attempt.getAttemptQuestions().stream().sorted(Comparator.comparingInt(AttemptQuestion::getId))
				.forEach(aq -> {
					Question q = aq.getQuestion();
					Set<Integer> picked = aq.getAttemptOptions().stream().map(ao -> ao.getOption().getId()).collect(Collectors.toSet());
					LOGGER.debug("");
					LOGGER.debug(q.getText());
					int[] i = {1};
					q.getOptions().stream().sorted(Comparator.comparingInt(Options::getId)).forEach(o -> LOGGER.debug(String.format(" %d) %-12s %.1f   %b", i[0]++, o.getText(), o.getScore(), picked.contains(o.getId()))));
				});
		LOGGER.info("End");
	}

}