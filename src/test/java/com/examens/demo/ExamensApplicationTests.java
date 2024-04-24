package com.examens.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.examens.entities.Examens;
import com.examens.repos.ExamensRepository;
import com.examens.service.ExamenService;

@SpringBootTest
class ExamensApplicationTests {

	@Autowired
	private ExamensRepository examensRepository;
	private ExamenService examenService;
	@Test
	public void testCreateExamens() {
	Examens ex = new Examens("aaa aaaaaa",16.5,new Date());
	examensRepository.save(ex);
	}
	
	@Test
	public void testUpdateExamens()
	{
		Examens ex = examensRepository.findById(1L).get();
		ex.setnote(10.0);
		examensRepository.save(ex);
	}
	
	@Test
	public void testDeleteExamens()
	{
		examensRepository.deleteById(1L);;
	}
	 
	@Test
	public void testListerTousExamenss()
	{
		List<Examens> ex = examensRepository.findAll();
		for (Examens e : ex)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void testFindByetudiantContains()
	{
		Page<Examens> exs = examenService.getAllProduitsParPage(0,2);
		System.out.println(exs.getSize());
		System.out.println(exs.getTotalElements());
		System.out.println(exs.getTotalPages());
		exs.getContent().forEach(p -> {System.out.println(p.toString());});
	
	}


}
