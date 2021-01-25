package com.cloud.family.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.family.rest.dto.Family;
import com.cloud.family.rest.dto.GenericResponse;
import com.cloud.family.rest.dto.Member;
import com.cloud.family.rest.service.MemberService;

import io.swagger.annotations.Api;

/**
 * 
 * @author Jose M Oliveros
 */
@RestController
@RequestMapping("/api")
@Api(
        value = "/api",
        produces = "application/json")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/**
     * {@code POST  /member : Add member to family record
     * 
     * @param {@link Member} Member to save on record
     * @return Identification of record on Database
     */
    @PostMapping(
            path = "/member",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<String>> addMember(
            @RequestBody Member member) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.addMember(member));
    }
    
	/**
     * {@code PUT  /member : Update member to family record
     * 
     * @param id Identification member to update on record
     * @param {@link Member} Member to update on record
     * @return {@link Member} Member updated on record
     */
    @PutMapping(
            path = "/member/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Member>> updateMember(
    		@PathVariable String id,
            @RequestBody Member member) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.updateMember(id, member));
    }
    
	/**
     * {@code DELETE  /member : Delete member to family record
     * 
     * @param id Identification member to delete on record
     */
    @DeleteMapping(
            path = "/member/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Void>> deleteMember(
    		@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.deleteMember(id));
    }

}
