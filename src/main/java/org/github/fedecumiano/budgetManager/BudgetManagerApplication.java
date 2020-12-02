package org.github.fedecumiano.budgetManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class BudgetManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetManagerApplication.class, args);
	}

}
