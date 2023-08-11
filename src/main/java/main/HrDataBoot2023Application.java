package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"models"})
public class HrDataBoot2023Application {

	public static void main(String[] args) {
		SpringApplication.run(HrDataBoot2023Application.class, args);
	}

}
