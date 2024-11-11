package com.workintech.ecomm;

import org.springframework.boot.SpringApplication;

public class TestEcommApplication {

	public static void main(String[] args) {
		SpringApplication.from(EcommApplication::main).run(args);
	}

}
