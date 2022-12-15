package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }, scanBasePackages = { "com.example.demo" })
public class StudioTesiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudioTesiApplication.class, args);
	}

}
