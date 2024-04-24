package com.examens.demo;

import java.util.Date;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import com.examens.entities.Examens;
import com.examens.service.ExamenService;
import com.examens.service.ExamenServiceImpl;

@SpringBootApplication
public class ExamensApplication implements CommandLineRunner {
	
	
	private ExamenService ex = new ExamenServiceImpl();
	
	public static void main(String[] args) {
		SpringApplication.run(ExamensApplication.class, args);
	}
	
	@Override
	public void run (String... args) throws Exception {
		ex.saveExamens(new Examens("aaa aaaa", 10.0, new Date()));
		ex.saveExamens(new Examens("ffff fffff", 12.0, new Date()));
		ex.saveExamens(new Examens("foulen ben foulen", 14.5, new Date()));
	}


}
