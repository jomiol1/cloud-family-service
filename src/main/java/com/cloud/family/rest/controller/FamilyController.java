package com.cloud.family.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.family.rest.dto.Family;
import com.cloud.family.rest.dto.GenericResponse;
import com.cloud.family.rest.service.FamilyService;

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
public class FamilyController {
	
	@Autowired
	private FamilyService familyService;
	
	 /**
     * {@code GET  /family} : Get all the families records
     *
     * @return List of {@link Family} 
     */
    @GetMapping(
            path = "/family",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<List<Family>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(familyService.getAll());
    }
    
	 /**
     * {@code GET  /family} : Get family by DB Identification
     * 
     * @param id identification of family record
     * @return {@link Family} 
     */
    @GetMapping(
            path = "/family/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Family>> getById(
    		  @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(familyService.getById(id));
    }
    
	/**
     * {@code POST  /family/{id} : Create family record
     * 
     * @param name name of family record
     * @return Identification of record on Database
     */
    @PostMapping(
            path = "/family/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<String>> create(
            @PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(familyService.create(name));
    }
    

}
