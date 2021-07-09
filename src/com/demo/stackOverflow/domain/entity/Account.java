package com.demo.stackOverflow.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Account {
	List<String> questionsPosted;
	List<String> answersPosted;
	List<String> comments;
	HashMap<BadgeType, Integer> badgeCount;
	public Account() {
		questionsPosted = new ArrayList<>();
		answersPosted = new ArrayList<>();
		comments = new ArrayList<>();
		badgeCount = new HashMap<>();
	}
	@Override
	public String toString() {
		return "Account [badgeCount=" + badgeCount + "]" + " No of questions posted= " + questionsPosted.size() + " No of answers added= " + answersPosted.size() + " No of comments written= " + comments.size();
	}
	
}
