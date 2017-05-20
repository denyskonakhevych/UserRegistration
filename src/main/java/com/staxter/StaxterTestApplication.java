package com.staxter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.staxter")
public class StaxterTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaxterTestApplication.class, args);
	}
}
