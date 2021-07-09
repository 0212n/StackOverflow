package com.demo.stackOverflow.service;

import com.demo.stackOverflow.domain.entity.BadgeType;
import com.demo.stackOverflow.domain.entity.Votetype;

public interface MemberService{
	
	public String postQuestion(String header, String message, String memberID);
	
	public String addComment(String entityID, String message, String memberID);
	
	public String addAnswer(String message, String questionID, String memberID);
	
	public void flag(String entityID);
	
	public void addBadge(BadgeType type, String description);
	
	public void addVote(String questionID, Votetype vote);

}
