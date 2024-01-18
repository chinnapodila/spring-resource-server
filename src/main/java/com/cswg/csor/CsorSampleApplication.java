package com.cswg.csor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
public class CsorSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsorSampleApplication.class, args);
	}

}
