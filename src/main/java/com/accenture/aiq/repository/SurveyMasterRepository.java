package com.accenture.aiq.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.accenture.aiq.entities.SurveyMaster;

@Repository
public interface SurveyMasterRepository extends JpaRepository<SurveyMaster, Integer>{

}
