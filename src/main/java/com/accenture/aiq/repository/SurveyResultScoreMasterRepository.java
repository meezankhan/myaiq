package com.accenture.aiq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.aiq.entities.SurveyResultScoreMaster;

@Repository
public interface SurveyResultScoreMasterRepository extends JpaRepository<SurveyResultScoreMaster,Integer>{

	@Query("SELECT s.level FROM SurveyResultScoreMaster s where  s.minscore <= ?1  and  s.maxscore > ?1")
	public String findLevelByScore(double score);
	
}
