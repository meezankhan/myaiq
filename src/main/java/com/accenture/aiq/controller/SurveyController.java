package com.accenture.aiq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.aiq.AiqApplication;
import com.accenture.aiq.dto.NewSurveyDTO;
import com.accenture.aiq.dto.SubmitSurveyResponseDTO;
import com.accenture.aiq.dto.SurveyResultRequestDTO;
import com.accenture.aiq.entities.SurveyResult;
import com.accenture.aiq.service.SurveyService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SurveyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AiqApplication.class);
	
	@Autowired
	SurveyService surveyService;

	@GetMapping("/survey/start/{surveyId}/{userId}")
	public NewSurveyDTO startSurvey(@PathVariable(name = "surveyId", required = true) int surveyId,
			@PathVariable(name = "userId", required = true) int userId) throws Exception {

		LOGGER.info("Request received TO START THE SURVEY for user with id : {}, surveyId: {}",userId,surveyId);
		NewSurveyDTO response = null;
		try {
			if (surveyService.checkIfInProgressSurveyExists(surveyId, userId)) {
				throw new Exception(
						"There are already surveys in in progress state for this customer's project. Kindly complete them first"); 
			}
			
		
			response = surveyService.loadNewSurveyForUser(surveyId, userId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		LOGGER.debug("START Survey response data: {}",response);
		
		LOGGER.info("START Survey data generated for user with id: {}, survetId: {}",userId,surveyId);
		
		System.out.println(" ");
		
		return response;
		

	}

	@GetMapping("/survey/resume/{surveyId}/{projectId}")
	public NewSurveyDTO resumeSurvey(@PathVariable(name = "surveyId", required = true) int surveyId,
			@PathVariable(name = "projectId", required = true) int projectId) throws Exception {
		
		LOGGER.info("Request received TO RESUME THE SURVEY for user with id : {}, surveyId: {}",projectId,surveyId);
		NewSurveyDTO response = surveyService.loadActiveSurveyForProject(surveyId, projectId);
		if(response != null) {
			return response;
		}else {
			throw new Exception("No in progress survey for project id :"+projectId);
		}
	}

	@PutMapping("/survey/save")
	public String saveSurvey(@RequestBody SurveyResultRequestDTO request) throws JsonProcessingException {
		
		LOGGER.info("Request received TO SAVE THE SURVEY");
		
		
		LOGGER.debug("SAVE Survey Request for user with id:{} , surveyId:{} ,projectId:{} ",request.getUserId(),request.getSurveyId(),request.getProjectId());
		LOGGER.debug("{}",request);
		
		boolean status = surveyService.saveSurvey(request);
		if(status) {
			LOGGER.info("SAVE SURVEY done......");
			
			System.out.println(" ");
			
			return "Survey has been saved succesfully";
		}else {
			return "There is some problem in saving survey. Please contact support team to get more details.";
			
		}
		
		

	}

	@PutMapping("/survey/submit")
    public SubmitSurveyResponseDTO submitSurvey(@RequestBody SurveyResultRequestDTO request)  {
		
		LOGGER.info("Request received TO SUBMIT THE SURVEY");
		SurveyResult surveyResult = surveyService.submitSurvey(request);
		LOGGER.debug("SUBMIT Survey for user with userId:{}, surveyId:{}, projectId:{} ",request.getUserId(),request.getSurveyId(),request.getProjectId());
		LOGGER.debug("{}",request);
		
        LOGGER.info("SUBMIT SURVEY done......");
		SubmitSurveyResponseDTO response = surveyService.generateSubmitSurveyResponse(surveyResult);

		return response;

	}

}
