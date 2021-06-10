package com.accenture.aiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.aiq.entities.SurveyResult;

@Repository
public interface SurveyResultRepository extends JpaRepository<SurveyResult, Integer> {

	@Query("SELECT a FROM SurveyResult a where a.userid = ?1 "
			+ "and a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid=a.userid) ")
	public List<SurveyResult> findbyUserIdAndProjectId(int userId);
	
	@Query("SELECT a FROM SurveyResult a where a.userid = ?1 "
			+ "and a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid=a.userid) ")
	public List<SurveyResult> findSurveyResultsForNormalUserByUserId(int userId);
	
	public List<SurveyResult> findByUseridAndClientname(int userId, String clientname);
	
	public List<SurveyResult> findByMarketunitAndClientname(String marketunit, String clientname);
	
	public List<SurveyResult> findByMarketunit(String marketunit);
	
	@Query("SELECT id FROM SurveyResult a "
			+ " where a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?2) "
			+ " and a.surveyid =?1 AND a.status = ?3 ") 
	public List<Integer> findUserSurveyResultByStatus(int surveyId, int userId, String status);
	
	
	@Query("SELECT a FROM SurveyResult a where a.userid = ?1 and a.surveyid= ?2 "
			+ "and a.projectid = ?3 AND a.status <> 'SUBMITTED' ")
	public SurveyResult findIncompleteSurveyForUserProject(int userId, int surveyId, int projectId);

	@Query("SELECT a FROM SurveyResult a where a.surveyid= ?1 "
				+ "and a.projectid = ?2 AND a.status <> 'SUBMITTED' ")
		public SurveyResult findActiveSurveyForProject(int surveyId, int projectId);
		
		@Query("SELECT id FROM SurveyResult a "
				+ " where a.projectid in (select distinct b.projectid from UserProjectMapping b where b.userid= ?2) "
				+ " and a.surveyid =?1 AND a.status <> 'SUBMITTED'  ") 
		public List<Integer> findActiveSurveyForUser(int surveyId, int userId);

		public List<SurveyResult> findByClientname(String clientname);
			 
}
