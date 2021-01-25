package com.cloud.family.rest.service.impl;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.family.constant.StatusCode;
import com.cloud.family.model.entity.MemberEntity;
import com.cloud.family.model.repository.MemberRepository;
import com.cloud.family.rest.dto.GenericResponse;
import com.cloud.family.rest.dto.Member;
import com.cloud.family.rest.handler.exception.ItemNotFoundException;
import com.cloud.family.rest.service.MemberService;

/**
 * 
 * @author Jose M Oliveros
 */
@Service
public class MemberServiceImpl implements MemberService{
	
    Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberRepository memberRepository;
	
	/**
     * Service that add member to family record
     * 
     * @param {@link Member} Member to save on record
     * @return Identification of record on Database
     */
	@Override
	public GenericResponse<String> addMember(Member member) {
		
		logger.info("Member Service -> addMember, Request : {}",member.toString());
		
		MemberEntity memberentity = new MemberEntity();
		memberentity.setFamilyId(member.getFamilyId());
		memberentity.setGender(member.getGender());
		memberentity.setName(member.getName());
		memberentity.setLastName(member.getLastName());
		
		memberRepository.save(memberentity);
		
        GenericResponse<String> response = new GenericResponse<>();
        response.setStatusCode(StatusCode.OK.getCode());
        response.setMessage(StatusCode.OK.getDescription());
        response.setData(memberentity.getId());
        
		logger.info("Member Service -> addMember, Response: {}", Arrays.asList(response.toString()));
		
        return response;
	}
	
	@Override
	public GenericResponse<Member> getById(String memberId) {
		
		logger.info("Member Service -> getById, Request : {}", memberId);
		
		Optional<MemberEntity> OptionalMember = memberRepository.findById(memberId);
		
		if(! OptionalMember.isPresent()) {
			   throw new ItemNotFoundException("Member Id Not Found!");
		}
		
		MemberEntity member = OptionalMember.get();
		
        GenericResponse<Member> response = new GenericResponse<>();
        response.setStatusCode(StatusCode.OK.getCode());
        response.setMessage(StatusCode.OK.getDescription());
        response.setData(new Member(member.getName(),member.getLastName(),member.getGender(),
        		member.getFamilyId()));
        
		logger.info("Member Service -> getById, Response: {}", Arrays.asList(response.toString()));
		
        return response;
	}
	
	/**
     * Service that update member to family record
     * 
     * @param id Identification member to update on record
     * @param {@link Member} Member to update on record
     * @return {@link Member} Member updated on record
     */
	@Override
	public GenericResponse<Member> updateMember(String memberId, Member member) {
		
		logger.info("Member Service -> updateMember, Request : {}", member.toString());
		
		Optional<MemberEntity> OptionalMember = memberRepository.findById(memberId);
		
		if(! OptionalMember.isPresent()) {
			
			   throw new ItemNotFoundException("Member Id Not Found!");
			
		}
		
		MemberEntity memberentity = OptionalMember.get();
		memberentity.setFamilyId(member.getFamilyId());
		memberentity.setGender(member.getGender());
		memberentity.setName(member.getName());
		memberentity.setLastName(member.getLastName());

		memberRepository.save(memberentity);
		
        GenericResponse<Member> response = new GenericResponse<>();
        response.setStatusCode(StatusCode.OK.getCode());
        response.setMessage(StatusCode.OK.getDescription());
        response.setData(member);
        
		logger.info("Member Service -> updateMember, Response: {}", Arrays.asList(response.toString()));
		
        return response;
	}
	
	
	/**
     * Service that delete member to family record
     * 
     * @param id Identification member to delete on record
     */
	@Override
	public GenericResponse<Void> deleteMember(String memberId) {
		
		logger.info("Member Service -> deleteMember, Request : {}",memberId);
		
		Optional<MemberEntity> OptionalMember = memberRepository.findById(memberId);
		
		if(! OptionalMember.isPresent()) {
			   throw new ItemNotFoundException("Member Id Not Found!");
		}
		
		memberRepository.delete(OptionalMember.get());
        
		GenericResponse<Void> response = new GenericResponse<>();
        response.setStatusCode(StatusCode.OK.getCode());
        response.setMessage(StatusCode.OK.getDescription());
        
		logger.info("Member Service -> deleteMember, Response: {}", Arrays.asList(response.toString()));
        
        return response;
	}


}
