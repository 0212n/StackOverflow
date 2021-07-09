package com.demo.stackOverflow.domain.entity;

public class Comment extends Entity {
	String message;
	String parentID;
	public Comment(String parentID, String message, String entityID) {
		super(entityID);
		// TODO Auto-generated constructor stub
		this.message = message;
		this.parentID = parentID;
		this.entityType = EntityType.COMMENT;
	}
	@Override
	public String toString() {
		return "Comment [message=" + message + ", parentID=" + parentID + "]";
	}

}
