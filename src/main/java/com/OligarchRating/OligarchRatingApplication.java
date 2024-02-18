package com.OligarchRating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.OligarchRating")
public class OligarchRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OligarchRatingApplication.class, args);
	}
}


