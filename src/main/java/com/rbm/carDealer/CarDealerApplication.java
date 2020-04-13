package com.rbm.carDealer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan("com.rbm.carDealer.mappers")
public class CarDealerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDealerApplication.class, args);
	}

}
