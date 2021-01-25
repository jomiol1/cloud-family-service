package com.cloud.family.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.family.model.entity.MemberEntity;

@Repository
public interface MemberRepository  extends MongoRepository<MemberEntity, String> {
	
	public Optional<MemberEntity> findById(String id);
	
	public List<MemberEntity> findByFamilyId(String familyId);

}
