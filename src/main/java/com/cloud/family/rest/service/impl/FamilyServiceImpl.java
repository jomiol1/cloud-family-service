package com.cloud.family.rest.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.family.constant.StatusCode;
import com.cloud.family.model.entity.FamilyEntity;
import com.cloud.family.model.entity.MemberEntity;
import com.cloud.family.model.repository.FamiliyRepository;
import com.cloud.family.model.repository.MemberRepository;
import com.cloud.family.rest.dto.Family;
import com.cloud.family.rest.dto.Member;
import com.cloud.family.rest.handler.exception.ItemNotFoundException;
import com.cloud.family.rest.dto.GenericResponse;
import com.cloud.family.rest.service.FamilyService;

/**
 * 
 * @author Jose M Oliveros
 */
@Service
public class FamilyServiceImpl implements FamilyService{
	
    Logger logger = LoggerFactory.getLogger(FamilyServiceImpl.class);
	
    @Autowired
	private FamiliyRepository familiyRepository;
    
    @Autowired
	private MemberRepository memberRepository;
    
	/**
     * 
     * Service that create family record
     * 
     * @param name name of family record
     * @return Identification of record on Database
     */
	@Override
	public GenericResponse<String> create(String name) {
		
		logger.info("Family Service -> Create, Request : {}",name);
		
		FamilyEntity familyEntity = new FamilyEntity();
		familyEntity.setName(name);
		
		familiyRepository.save(familyEntity);
	
        GenericResponse<String> response = new GenericResponse<>();
        response.setStatusCode(StatusCode.OK.getCode());
        response.setMessage(StatusCode.OK.getDescription());
        response.setData(familyEntity.getId());
        
		logger.info("Family Service -> Create, Response: {}", Arrays.asList(response.toString()));
        
        return response;
	
		
	}
	
	 /**
     * Service that return all the families records
     *
     * @return List of {@link Family}
     */
	@Override
	public GenericResponse<List<Family>> getAll() {
		
		logger.info("Family Service -> getAll, Request : N/A");
		
		List<FamilyEntity> familyList = familiyRepository.findAll();
		List<Family> familyListResponse = new ArrayList<Family>();
		
		familyList.forEach(item -> {
			
			List<MemberEntity> membersEntity = memberRepository.findByFamilyId(item.getId());
			List<Member> members = new ArrayList<Member>();
			
			if(!membersEntity.isEmpty()) {
				membersEntity.forEach(member -> {
					members.add(new Member(member.getName(),member.getLastName(),
							member.getGender(),member.getFamilyId()));
				});
			}
			
			familyListResponse.add(new Family(item.getId(), item.getName(), members));
		});
		
	       GenericResponse<List<Family>> response = new GenericResponse<>();
	        response.setStatusCode(StatusCode.OK.getCode());
	        response.setMessage(StatusCode.OK.getDescription());
	        response.setData(familyListResponse);
	        
			logger.info("Family Service -> getAll, Response: {}", Arrays.asList(response.toString()));
	        
		return response;
	}

	 /**
     * Service that return family by DB Identification
     * 
     * @param id identification of family record
     * @return {@link Family} 
     */
	@Override
	public GenericResponse<Family> getById(String id) {
		
		logger.info("Family Service -> getById, Request : {}", id);
		
		Optional<FamilyEntity> family = familiyRepository.findById(id);
		
        GenericResponse<Family> response = new GenericResponse<>();
        response.setStatusCode(StatusCode.OK.getCode());
        response.setMessage(StatusCode.OK.getDescription());
		
		if(! family.isPresent()) {
			
		   throw new ItemNotFoundException("Family Id Not Found!");
			
		}
	    
		response.setData(new Family(family.get().getId(), family.get().getName()));
		
		logger.info("Family Service -> getById, Response: {}", Arrays.asList(response.toString()));
		
		return response;
	}

}
