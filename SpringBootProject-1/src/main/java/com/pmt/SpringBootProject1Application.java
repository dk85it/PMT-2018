package com.pmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pmt")
public class SpringBootProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject1Application.class, args);
	}
	
	
}
