package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.bean")
public class DemoTes {
	
	
	
		

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			SpringApplication.run(DemoTes.class, args);
			System.out.println("Server up on port number 8080");
		}

	}