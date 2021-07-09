package com.demo.stackOverflow.domain.repo;

import java.util.HashMap;

import com.demo.stackOverflow.domain.entity.Member;
import com.demo.stackOverflow.domain.entity.User;
import com.demo.stackOverflow.domain.repo.util.UserNotFoundException;

public class UserRepo {
	HashMap<String, String> emailIDMap;
	HashMap<String, User> userIDMap;
	
	public UserRepo() {
		userIDMap = new HashMap<>();
		emailIDMap = new HashMap<>();
	}
	
	public User getUser(String userID) throws UserNotFoundException {
		if(userIDMap.containsKey(userID)) {
			return userIDMap.get(userID);
		}
		throw new UserNotFoundException(userID);
	}
	
	public boolean isRegistered(String emailID) {
		if(emailIDMap.containsKey(emailID))
			return true;
		return false;
	}
	
	public String getNextID() {
		int next = emailIDMap.size();
		return "User" + next;
	}

	@Override
	public String toString() {
		return "UserRepo [emailIDMap=" + emailIDMap + ", userIDMap=" + userIDMap + "]";
	}

	public void addUser(String id, Member newMember) {
		userIDMap.put(id, newMember);
		emailIDMap.put(newMember.getEmail(), id);
		
	}
	
	
}
