package com.accenture.aiq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.aiq.AiqApplication;
import com.accenture.aiq.dto.DashboardResult;
import com.accenture.aiq.dto.DashboardFilterResponseDTO;
import com.accenture.aiq.service.DashboardService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DashboardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AiqApplication.class);

	@Autowired
	DashboardService service;
	
	@GetMapping("/dashboard/user/{userId}")
	public DashboardResult userDashboard(@PathVariable(required = true) int userId, 
			@RequestParam(required = false) String marketUnit,
			@RequestParam(required = false) String project) throws JsonProcessingException {	
		
		LOGGER.info("Request received for loading dashboard for user with id : {}",userId);
		
		DashboardResult response = new DashboardResult();
		try {
			response = service.getUserSurveys(userId, marketUnit, project);
		} catch (Exception e) {
			LOGGER.error("error while fetching dashboard for user. message is:{}", e.getMessage());
			e.printStackTrace();
		}
		
		LOGGER.debug("user dashboard response data: {}",response);
		
		LOGGER.info("Dashboard data generated for user with id: {}",userId);
		System.out.println(" ");
        
        return response;
		
	}
	
	/*
	 * @GetMapping("/dashboard/admin/{id}") public DashboardResult
	 * adminDashboard(@PathVariable(required = true) int id,
	 * 
	 * @RequestParam(required = false) String marketUnit) {
	 * 
	 * LOGGER.info("Request received for loading dashboard for admin with id : {}"
	 * ,id);
	 * 
	 * DashboardResult response = service.getAdminSurveys(id, marketUnit);
	 * 
	 * LOGGER.debug("admin dashboard response data: {}",response);
	 * 
	 * LOGGER.info("Dashboard data generated for admin with id: {}",id);
	 * 
	 * System.out.println(" ");
	 * 
	 * return response; }
	 */
	@GetMapping("/dashboard/getfilters/{userId}")
	public DashboardFilterResponseDTO getDashboardPageFilter(@PathVariable(required = true) int userId) {
		
		DashboardFilterResponseDTO response = null;
		try {
			response = service.getUserProjects(userId);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return response;
	}
}
