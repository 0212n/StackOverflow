package com.demo.stackOverflow.domain.entity;

import java.util.Date;
import java.util.HashMap;

public class Entity {
	EntityType entityType;
	String entityID;
	Member creator;
	Date creationDate;
	HashMap<Votetype, Integer> voteMap;
	public Entity(String entityID) {
		// TODO Auto-generated constructor stub
		this.entityID = entityID;
		this.voteMap = new HashMap<>();
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getEntityID() {
		return entityID;
	}
	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}
	public Member getCreator() {
		return creator;
	}
	public void setCreator(Member creator) {
		this.creator = creator;
	}
	public EntityType getEntityType() {
		return entityType;
	}
	
	public void updateVote(Votetype type) {
		int currCount = this.voteMap.getOrDefault(type, 0);
		this.voteMap.put(type, currCount+1);
	}
}
