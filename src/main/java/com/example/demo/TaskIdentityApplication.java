package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class TaskIdentityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskIdentityApplication.class, args);
	}

}
