package com.accenture.aiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.aiq.entities.OptionsMaster;

@Repository
public interface OptionsMasterRepository extends JpaRepository<OptionsMaster, Integer>{
	
	public List<OptionsMaster> findByQuestionidOrderByOrderidAsc(int questionid);

}
