package com.cloud.family.rest.service;


import java.util.List;

import com.cloud.family.rest.dto.Family;
import com.cloud.family.rest.dto.GenericResponse;

public interface FamilyService {
	
	public GenericResponse<String> create(String name);

	public GenericResponse<List<Family>> getAll();
	
	public GenericResponse<Family> getById(String id);
	

}
