package com.datajpa.Jpademo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


@SpringBootApplication
public class JpademoApplication {

	private static final Logger log = LoggerFactory.getLogger(JpademoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// saving the values of customer
			repository.save(new Customer("Ankit", "Soni"));
			repository.save(new Customer("Saurabh", "Soni"));
			repository.save(new Customer("Shreya", "Verma"));
			repository.save(new Customer("Parul", "Soni"));
			repository.save(new Customer("Surbhi", "Soni"));

			log.info("Customer by findAll()");
			log.info("---------------------");

			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("---------------------");
			Customer customer = repository.findById(1L);

			log.info(customer.toString());
			// fetch customers by last name
			log.info("Customer found with findByLastName('Soni'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Soni").forEach(bauer -> {
				log.info(bauer.toString());
			});
			Long ans = repository.count();
			log.info("count is " + ans);



		};
	}

}
