package io.github.kszuba1;

import io.github.kszuba1.dao.AccountRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AccountRepository.class)
public class MyCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoursesApplication.class, args);
	}

}
