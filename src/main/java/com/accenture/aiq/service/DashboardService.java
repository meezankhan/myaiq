package com.accenture.aiq.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.accenture.aiq.constants.Constants;
import com.accenture.aiq.dto.DashboardResult;
import com.accenture.aiq.dto.MUAndProjectDTO;
import com.accenture.aiq.dto.SurveyResultDTO;
import com.accenture.aiq.dto.UserDashboard;
import com.accenture.aiq.dto.DashboardFilterResponseDTO;
import com.accenture.aiq.entities.SurveyMaster;
import com.accenture.aiq.entities.SurveyResult;
import com.accenture.aiq.entities.UserMaster;
import com.accenture.aiq.repository.HomePageMasterRepository;
import com.accenture.aiq.repository.SurveyMasterRepository;
import com.accenture.aiq.repository.SurveyResultRepository;
import com.accenture.aiq.repository.SurveyResultScoreMasterRepository;
import com.accenture.aiq.repository.UserMasterRepository;
import com.accenture.aiq.util.GenericUtil;

@Service
public class DashboardService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardService.class);

	@Autowired
	SurveyResultRepository surveyResultDao;

	@Autowired
	UserMasterRepository userMasterDao;

	@Autowired
	SurveyMasterRepository surveyMasterDao;

	@Autowired
	SurveyResultScoreMasterRepository scoreMasterDao;
	
	@Autowired
	HomePageMasterRepository homePageMasterRepository;
	

	public DashboardResult getUserSurveys(int userId, String marketUnit, String project) throws Exception {
		DashboardResult response = new DashboardResult();
		List<SurveyResult> surveyResults = new ArrayList<SurveyResult>();
		
		LOGGER.debug("Inside DashboardService to get surveys for user:{}, marketUnit:{} and project:{}",userId, marketUnit, project);

		UserMaster user = userMasterDao.getOne(userId);
		if(user != null && !StringUtils.isEmpty(user.getRole())) {
			String role = user.getRole();
			
			validateInput(role, marketUnit, project);
			
			if(StringUtils.isEmpty(marketUnit)) {
				marketUnit = Constants.DEFAULT_DROP_DOWN_ALL;
			}
			
			if(StringUtils.isEmpty(project)) {
				project = Constants.DEFAULT_DROP_DOWN_ALL;
			}
			
			if(Constants.USER_ROLE_USER.equalsIgnoreCase(role)) {
				if(Constants.DEFAULT_DROP_DOWN_ALL.equalsIgnoreCase(project) ){
					surveyResults = surveyResultDao.findSurveyResultsForNormalUserByUserId(userId);
				}else {
					surveyResults = surveyResultDao.findByUseridAndClientname(userId, project);
				}
			}else if(Constants.USER_ROLE_MU_ADMIN.equalsIgnoreCase(role)) {
				if(Constants.DEFAULT_DROP_DOWN_ALL.equalsIgnoreCase(project) ){
					surveyResults = surveyResultDao.findByMarketunit(user.getMarketunit());
				}else {
					surveyResults = surveyResultDao.findByMarketunitAndClientname(user.getMarketunit(), project);
				}
			}else if(Constants.USER_ROLE_SUPER_ADMIN.equalsIgnoreCase(role)) {
				if(Constants.DEFAULT_DROP_DOWN_ALL.equalsIgnoreCase(marketUnit) && Constants.DEFAULT_DROP_DOWN_ALL.equalsIgnoreCase(project) ){
					surveyResults = surveyResultDao.findAll();
				}else if (Constants.DEFAULT_DROP_DOWN_ALL.equalsIgnoreCase(marketUnit)){
					surveyResults = surveyResultDao.findByClientname(project);
				}else if (Constants.DEFAULT_DROP_DOWN_ALL.equalsIgnoreCase(project)){
					surveyResults = surveyResultDao.findByMarketunit(marketUnit);
				}else {
					surveyResults = surveyResultDao.findByMarketunitAndClientname(marketUnit, project);
				}
			}
		}
		
		if (surveyResults != null && surveyResults.size() > 0) {
			LOGGER.debug("Number of Surveys for User:{}", surveyResults.size());
			response = convertFromEntityToDTO(surveyResults, response);
		}
		LOGGER.info("Survey results for normal user:{}",response);
		return response;
	}

	private void validateInput(String role, String marketUnit, String project) throws Exception {

		if(Constants.USER_ROLE_USER.equalsIgnoreCase(role) || Constants.USER_ROLE_MU_ADMIN.equalsIgnoreCase(role)) {
			if(Constants.DEFAULT_DROP_DOWN_OPTION.equalsIgnoreCase(project)) {
				throw new Exception("Please select a value for project or select all");
			}
		}else if(Constants.USER_ROLE_SUPER_ADMIN.equalsIgnoreCase(role)) {
			
			if(Constants.DEFAULT_DROP_DOWN_OPTION.equalsIgnoreCase(marketUnit)) {
				throw new Exception("Please select a value for market unit or select all");
			}
			
			if(Constants.DEFAULT_DROP_DOWN_OPTION.equalsIgnoreCase(project)) {
				throw new Exception("Please select a value for project or select all");
			}
		}
		
	}

	public DashboardResult getAdminSurveys(int userId, String marketUnit) {

		if (marketUnit == null || marketUnit.trim().length() == 0) {
			marketUnit = "ALL";
		}

		DashboardResult response = new DashboardResult();
		List<SurveyResult> surveyResults;

		UserMaster user = userMasterDao.getOne(userId);

		if ("Super Admin".equals(user.getRole())) {

			if ("ALL".equals(marketUnit)) {
				surveyResults = surveyResultDao.findAll();
			} else {
				surveyResults = surveyResultDao.findByMarketunit(marketUnit);
			}

		} else {
			surveyResults = surveyResultDao.findByMarketunit(user.getMarketunit());
		}

		if (surveyResults != null && surveyResults.size() > 0) {

			response = convertFromEntityToDTO(surveyResults, response);
		}

		return response;

	}

	private DashboardResult convertFromEntityToDTO(List<SurveyResult> surveyResults, DashboardResult response) {
		UserDashboard surveys = new UserDashboard();

		List<SurveyResultDTO> surveyList = new ArrayList<SurveyResultDTO>();

		for (SurveyResult data : surveyResults) {

			SurveyResultDTO resultDTO = new SurveyResultDTO();

			UserMaster user = userMasterDao.getOne(data.getUserid());
			resultDTO.setUserId(user.getId());

			resultDTO.setUserEmail(user.getUseremail());

			resultDTO.setMarketUnit(data.getMarketunit());
			resultDTO.setProject(data.getClientname());

			SurveyMaster surveyMaster = surveyMasterDao.getOne(data.getSurveyid());
			resultDTO.setSurveyId(data.getSurveyid());
			resultDTO.setSurveyTitle(surveyMaster.getSurveyTitle());

			resultDTO.setVersion(1);
			resultDTO.setStatus(data.getStatus());

			if (Constants.SURVEY_STATUS_SUBMITTED.equals(data.getStatus())) {

				resultDTO.setScore(data.getScore() + "/" + surveyMaster.getMaxScore());

				double finalRating = data.getScore() * .09;
				resultDTO.setRating(String.format("%.1f", finalRating) + "/" + surveyMaster.getMaxRating());

				resultDTO.setLevel(scoreMasterDao.findLevelByScore(finalRating));

				resultDTO.setSubmittedOn(GenericUtil.convertDateToDTOFormat(data.getSubmittedOn()));

			}

			surveyList.add(resultDTO);
		}

		surveys.setSurveyList(surveyList);
		response.setSurveys(surveys);

		return response;
	}

	
	public DashboardFilterResponseDTO getUserProjects(int userId) throws Exception {
		
		DashboardFilterResponseDTO response = new DashboardFilterResponseDTO();
		MUAndProjectDTO responseData = new MUAndProjectDTO();
		response.setResponse(responseData );
		
		Optional<UserMaster> userEntity = userMasterDao.findById(userId);
		if(userEntity.isPresent()) {
			UserMaster user = userEntity.get();
			String role = user.getRole();
			List<String> muList = new ArrayList<String>();
			List<String> projectList = new ArrayList<String>();
			
			muList.add(Constants.DEFAULT_DROP_DOWN_OPTION);
			projectList.add(Constants.DEFAULT_DROP_DOWN_OPTION);
			muList.add(Constants.DEFAULT_DROP_DOWN_ALL);
			projectList.add(Constants.DEFAULT_DROP_DOWN_ALL);
			
			if(Constants.USER_ROLE_USER.equals(role)) {
				muList = homePageMasterRepository.findMUForNormalUser(userId);
				projectList = homePageMasterRepository.findProjectsForNormalUser(userId);
				
			}else if (Constants.USER_ROLE_MU_ADMIN.equals(role)) {
				muList.add(user.getMarketunit());
				projectList = homePageMasterRepository.findProjectsForMuAdminUser(user.getMarketunit());
			}else if (Constants.USER_ROLE_SUPER_ADMIN.equals(role)) {
				muList = homePageMasterRepository.findMUForSuperAdminUser();
				projectList = homePageMasterRepository.findProjectsForSuperAdminUser();
			}else {
				LOGGER.error("No User role defined");
				throw new Exception("No role defined for user: "+ user.getUseremail());
			}
			
			if(!CollectionUtils.isEmpty(muList)) {
				responseData.setMarketUnitList(muList);
			}
			if(!CollectionUtils.isEmpty(projectList)) {
				responseData.setProjectList(projectList);
			}
		}
		return response;
	}

}
