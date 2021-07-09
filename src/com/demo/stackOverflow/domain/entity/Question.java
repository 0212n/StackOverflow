package com.demo.stackOverflow.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Question extends Entity{
	String Header;
	String question;
	Date lastUpdate;
	List<String> tags;
	List<String> answerIDs;
	List<String> commentIDs;
	
	public Question(String header, String message, String entityID) {
		super(entityID);
		this.Header = header;
		this.question = message;
		this.entityType = EntityType.QUESTION;
		tags = new ArrayList<>();
		answerIDs = new ArrayList<>();
		commentIDs = new ArrayList<>();
	}
	public String getHeader() {
		return Header;
	}
	public void setHeader(String header) {
		Header = header;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTag(String tag) {
		this.tags.add(tag);
	}
	public List<String> getAnswerIDs() {
		return answerIDs;
	}
	public void addAnswerID(String answerID) {
		this.answerIDs.add(answerID);
	}
	public List<String> getCommentIDs() {
		return commentIDs;
	}
	public void addCommentID(String commentID) {
		this.commentIDs.add(commentID);
	}
	@Override
	public String toString() {
		return "Question [Header=" + Header + ", question=" + question + ", lastUpdate=" + lastUpdate + ", tags=" + tags
				+ "]";
	}
}
