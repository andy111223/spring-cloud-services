package com.student;


import jakarta.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
 
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Service02 {
	public static void main(String[] args) {
          SpringApplication.run(Service02.class, args);
    }
 
	@RequestMapping("/")
    public String index() {
         return "This is  service02";
    }

	@Inject
	private FirstAscentDAO dao;

	@GetMapping(value = "/{id}")
	public String get(@PathVariable("id") Long id) {
		return dao.get(id);
	}
	 
}