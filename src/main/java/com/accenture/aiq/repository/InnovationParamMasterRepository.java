package com.accenture.aiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.aiq.entities.InnovationParameterMaster;

public interface InnovationParamMasterRepository extends JpaRepository<InnovationParameterMaster, Integer>{
	
	public List<InnovationParameterMaster> findBySurveyidOrderByOrderidAsc(int surveyId);

}
