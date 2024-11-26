package com.wholesale.wholesale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.wholesale.wholesale")
public class WholesaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WholesaleApplication.class, args);
	}

}
