package com.cloud.family.rest.dto;

public class Member {

	private String name;
	private String lastName;
	private String gender;
	private String familyId;
	
	public Member() {
	}
	
	public Member(String name, String lastName, String gender, String familyId) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.familyId = familyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFamilyId() {
		return familyId;
	}
	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", familyId=" + familyId
				+ "]";
	}
	
	

}
