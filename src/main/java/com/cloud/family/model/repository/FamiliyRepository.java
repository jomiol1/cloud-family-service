package com.cloud.family.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.family.model.entity.FamilyEntity;


@Repository
public interface FamiliyRepository extends MongoRepository<FamilyEntity, String> {
	
	public Optional<FamilyEntity> findById(String id);

}
