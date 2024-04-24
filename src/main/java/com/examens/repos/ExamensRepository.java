package com.examens.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examens.entities.Examens;

@Repository
public interface ExamensRepository  extends JpaRepository<Examens, Long> {

}
