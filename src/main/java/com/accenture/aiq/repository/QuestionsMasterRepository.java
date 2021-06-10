package com.accenture.aiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.accenture.aiq.entities.QuestionsMaster;

public interface QuestionsMasterRepository extends JpaRepository<QuestionsMaster, Integer>{

	public List<QuestionsMaster> findByInnovationparamidOrderByOrderIdAsc(int innovationparamid);
}
