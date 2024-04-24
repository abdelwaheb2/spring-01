package com.examens.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.examens.entities.Examens;

public interface ExamenService {
	Examens saveExamens(Examens e);
	Examens updateExamens(Examens e);
	void deleteExamens(Examens e);
	 void deleteExamensById(Long id);
	Examens getExamens(Long id);
	List<Examens> getAllExamenss();
	Page<Examens> getAllProduitsParPage(int page, int size);


}
