package com.accenture.aiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.aiq.entities.UserMaster;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Integer>{
	
	
	@Query("SELECT a FROM UserMaster a where a.useremail =?1") 
	public List<UserMaster> findByEmailId(String email);

	public UserMaster findByUseremail(String useremail);
}
