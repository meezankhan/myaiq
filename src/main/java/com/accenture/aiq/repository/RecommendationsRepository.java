package com.accenture.aiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.aiq.entities.RecommendationMaster;

@Repository
public interface RecommendationsRepository extends JpaRepository<RecommendationMaster, Integer>{

	@Query("SELECT recommendation FROM RecommendationMaster r where r.level= ?1 AND r.innovationparamid=?2 ")
	List<String> findByLevelAndInnovationparamid(String level, int innovationparamid);

}
