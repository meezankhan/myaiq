package com.accenture.aiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.aiq.entities.SurveyResultQuestionScore;

public interface SurveyResultQuestionScoreRepository extends JpaRepository<SurveyResultQuestionScore, Integer>{

	public List<SurveyResultQuestionScore> findBySurveyresultid(int surveyresultid);
	
	public SurveyResultQuestionScore findBySurveyresultidAndQuestionid(int surveyresultid, 
			int questionid);
	@Query("SELECT questionid, concat(answerid, '_', comments) FROM SurveyResultQuestionScore a where a.surveyresultid= ?1 ")
	public List<Object[]> findSelectOptionBySurveyresultid(int surveyresultid);
}
