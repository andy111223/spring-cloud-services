package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Service01 {

	private final MountainDAO dao;

	// Constructor injection for MountainDAO
	public Service01(MountainDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Service01.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "This is a Spring Boot application";
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mountain get(@PathVariable("id") Long id) {
		Mountain c = dao.get(id);
		String url = "http://service02/{id}"; // service name, not actual URL
		String str = this.restTemplate().getForObject(url, String.class, id); // should use LoadBalanced RestTemplate
		c.setFirstAscent(str);
		return c;
	}

	@Bean
	@LoadBalanced // Enable LoadBalancer for RestTemplate
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}