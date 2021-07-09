package com.demo.stackOverflow.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Answer extends Entity {
	String message;
	String questionID;
	List<String> commentIDs;
	public Answer(String questionID, String message, String newID) {
		super(newID);
		this.message = message;
		this.questionID = questionID;
		this.entityType = EntityType.ANSWER;
		this.commentIDs = new ArrayList<>();
	}
	@Override
	public String toString() {
		return "Answer [message=" + message + ", to questionID=" + questionID + "]";
	}
	public List<String> getCommentIDs() {
		return commentIDs;
	}
	public void addCommentID(String commentID) {
		this.commentIDs.add(commentID);
	}

}
