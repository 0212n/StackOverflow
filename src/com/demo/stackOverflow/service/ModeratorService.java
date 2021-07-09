package com.demo.stackOverflow.service;

public interface ModeratorService {
	public void close(String questionID);
	
	public void undelete(String questionID);
}
