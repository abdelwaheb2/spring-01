package com.examens.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.examens.entities.Examens;
import com.examens.repos.ExamensRepository;
public class ExamenServiceImpl  implements ExamenService {
	@Autowired
	ExamensRepository ExamensRepository;
	@Override
	public Examens saveExamens(Examens e) {
	return ExamensRepository.save(e);
	}
	@Override
	public Examens updateExamens(Examens e) {
	return ExamensRepository.save(e);
	}
	@Override
	public void deleteExamens(Examens e) {
	ExamensRepository.delete(e);
	}
	 @Override
	public void deleteExamensById(Long id) {
	ExamensRepository.deleteById(id);
	}
	@Override
	public Examens getExamens(Long id) {
	return ExamensRepository.findById(id).get();
	}
	@Override
	public List<Examens> getAllExamenss() {
	return ExamensRepository.findAll();
	}
	
	@Override
	public Page<Examens> getAllProduitsParPage(int page, int size) {
		return ExamensRepository.findAll(PageRequest.of(page, size));
	}
}

