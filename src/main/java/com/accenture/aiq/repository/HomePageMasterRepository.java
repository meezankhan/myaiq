package com.accenture.aiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.aiq.entities.HomePageMaster;

@Repository
public interface HomePageMasterRepository extends JpaRepository<HomePageMaster, Integer>{


	@Query("SELECT a FROM HomePageMaster a where a.surveyid = ?1 "
			+ "and a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?2) ")
	public List<HomePageMaster> findBySurveyIdAndUserId(int surveyId, int userId);
	
	@Query("SELECT distinct marketunit FROM HomePageMaster a where a.surveyid = ?1 "
			+ "and a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?2) ")
	public List<String> findMarketUnitBySurveyIdAndUserId(int surveyId, int userId);
	
	@Query("SELECT distinct clientgroup FROM HomePageMaster a where a.surveyid = ?1 "
			+ "and a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?2) ")
	public List<String> findClientGroupBySurveyIdAndUserId(int surveyId, int userId);
	
	@Query("SELECT distinct deliveryunit FROM HomePageMaster a where a.surveyid = ?1 "
			+ "and a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?2) ")
	public List<String> findDeliveryUnitBySurveyIdAndUserId(int surveyId, int userId);
	
	@Query("SELECT distinct clientname FROM HomePageMaster a where a.surveyid = ?1 "
			+ "and a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?2) ")
	public List<String> findClientNameBySurveyIdAndUserId(int surveyId, int userId);
	
	@Query("SELECT distinct cal FROM HomePageMaster a where a.surveyid = ?1 "
			+ "and a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?2) ")
	public List<String> findCALBySurveyIdAndUserId(int surveyId, int userId);
	
	@Query("SELECT distinct deliverymd FROM HomePageMaster a where a.surveyid = ?1 "
			+ "and a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?2) ")
	public List<String> findDeliveryMDBySurveyIdAndUserId(int surveyId, int userId);
	
	@Query("SELECT distinct marketunit FROM HomePageMaster a where "
			+ " a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?1) ")
	public List<String> findMUForNormalUser(int userId);
	
	@Query("SELECT distinct clientname FROM HomePageMaster a where "
			+ " a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?1) ")
	public List<String> findProjectsForNormalUser(int userId);
	
	@Query("SELECT distinct clientname FROM HomePageMaster a where a.marketunit = ?1 ")
	public List<String> findProjectsForMuAdminUser(String marketUnit);
	
	@Query("SELECT distinct marketunit FROM HomePageMaster")
	public List<String> findMUForSuperAdminUser();
	
	@Query("SELECT distinct clientname FROM HomePageMaster")
	public List<String> findProjectsForSuperAdminUser();
}
