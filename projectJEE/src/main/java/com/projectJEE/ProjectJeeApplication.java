package com.projectJEE;

import com.projectJEE.repositories.*;
import com.projectJEE.tables.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectJeeApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjectJeeApplication.class, args);
	}	
	
	@Override
	public void run(ApplicationArguments args) throws Exception{				
	}
	
	
	
}
