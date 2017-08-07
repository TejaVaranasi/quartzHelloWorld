package com.go.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzHelloWorldApplication.class, args);
		System.out.println("Hello World!!!");
		System.out.println("---------------------------Context generation completed-------------");
	}
}
