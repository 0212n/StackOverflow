package com.demo.stackOverflow.service;

import com.demo.stackOverflow.domain.entity.Question;

public interface UserService {
	
	public Question getQuestion(String questionID);
	
}
