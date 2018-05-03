package com.xiaomo.travelhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.xiaomo"})
public class TravelHelperServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelHelperServerApplication.class, args);
	}
}
