package com.cloud.family.rest.dto;

import java.util.List;

public class Family {
	
	private String id;
	private String name;
	private List<Member> members;
	
	public Family(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Family(String id, String name, List<Member> members) {
		super();
		this.id = id;
		this.name = name;
		this.members = members;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Family [id=" + id + ", name=" + name + ", members=" + members + "]";
	}
	
	

}
