package com.accenture.aiq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.aiq.entities.UserProjectMapping;

@Repository
public interface UserProjectMappingRepository extends JpaRepository<UserProjectMapping,Integer>{

}
