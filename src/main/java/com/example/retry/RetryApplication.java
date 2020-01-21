package com.example.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.support.RetryTemplate;

@SpringBootApplication
public class RetryApplication implements CommandLineRunner {

	@Autowired
	RetryTemplate retryTemplate;

	@Autowired
	Servicio servicio;

	public static void main(String[] args) {
		SpringApplication.run(RetryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String execute = retryTemplate.execute(context -> servicio.metodo("ok :)", context.getRetryCount()));

		System.out.println("execute: " + execute);
	}
}
