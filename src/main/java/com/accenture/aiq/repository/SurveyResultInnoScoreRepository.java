package com.accenture.aiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.aiq.entities.SurveyResultInnoScore;

public interface SurveyResultInnoScoreRepository extends JpaRepository<SurveyResultInnoScore, Integer>{

	public List<SurveyResultInnoScore> findBySurveyresultid(int surveyresultid);
	
	public SurveyResultInnoScore findBySurveyresultidAndInnoparamid(int surveyresultid, 
			int innoparamid);
	
}
