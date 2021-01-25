package com.cloud.family.rest.service;

import com.cloud.family.rest.dto.GenericResponse;
import com.cloud.family.rest.dto.Member;

public interface MemberService {
	
	public GenericResponse<String> addMember(Member member);
	
	public GenericResponse<Member> getById(String memberId);
	
	public GenericResponse<Void> deleteMember(String memberId);
	
	public GenericResponse<Member> updateMember(String MemberId, Member member);

}
