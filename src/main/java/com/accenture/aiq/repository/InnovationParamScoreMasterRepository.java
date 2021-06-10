package com.accenture.aiq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.aiq.entities.InnovationParamScoreMaster;

public interface InnovationParamScoreMasterRepository extends JpaRepository<InnovationParamScoreMaster,Integer>{

	@Query("SELECT s.level FROM InnovationParamScoreMaster s where s.innovationparamid = ?2 AND "
			+ "(  s.minscore <= ?1  and  s.maxscore > ?1 )")
	public String findLevelByScoreAndInnovationParam(double score, int innovationparamid);
}
