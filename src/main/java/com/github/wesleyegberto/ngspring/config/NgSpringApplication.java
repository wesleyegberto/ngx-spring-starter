package com.github.wesleyegberto.ngspring.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NgSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(NgSpringApplication.class, args);
	}

	@RequestMapping("/api/hello")
	public Map<String, Object> greet() {
		Map<String, Object> model = new HashMap<>();
		model.put("message", "Hello Ng-Boot-World!");
		return model;
	}
}
