package com.todolist.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	// Ringkasnya,
	// @Controller untuk aplikasi web tradisional dengan views,
	// sementara @RestController untuk layanan RESTful yang mengembalikan data
	// langsung.
	// @Controller
	// @RestController
	// class HelloWorld {
	// @GetMapping("/")
	// public String hello() {
	// return "Hello world";
	// }

	// }

}
