package com.accenture.aiq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.accenture.aiq.dto.AuthenticateUserResponseDTO;
import com.accenture.aiq.dto.LoginForm;
import com.accenture.aiq.dto.UserDTO;
import com.accenture.aiq.entities.UserMaster;
import com.accenture.aiq.repository.UserMasterRepository;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserMasterRepository userDao;
	
	public void createUser(UserDTO user) {
		
		UserMaster u = new UserMaster(user.getUseremail(),user.getRole(),user.getMarketunit());
		
		userDao.save(u);
		
	}

	
	public boolean isEmailAvailable(String emailId) {
		
		List<UserMaster> users = userDao.findByEmailId(emailId);
		
		if(CollectionUtils.isEmpty(users)) {
			return false;
		}
		
		return true;
	}
	
	public AuthenticateUserResponseDTO createResponse(String email) {
		
		AuthenticateUserResponseDTO response = new AuthenticateUserResponseDTO();
		List<UserMaster> users = userDao.findByEmailId(email);
		
		response.setUserId(users.get(0).getId());
		response.setRole(users.get(0).getRole());
		
		return response;
	}
	
	public UserDTO authenticateUser(LoginForm loginForm) {

		UserMaster userEntity = userDao.findByUseremail(loginForm.getUserName());

		if (userEntity != null) {
			return new UserDTO(userEntity.getUseremail(), userEntity.getRole(), userEntity.getMarketunit(),
					userEntity.getId());
		} else
			return null;
	}	
}
