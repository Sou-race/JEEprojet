package com.projectJEE;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectJeeApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjectJeeApplication.class, args);
	}
	
	/*
	@Autowired 
	CustomerRepository customerRepository;
	
	@Autowired 
	PassportRepository passportRepository;
	*/
	
	@Override
	public void run(ApplicationArguments args) throws Exception{	
		
		
		
	}
	
}
