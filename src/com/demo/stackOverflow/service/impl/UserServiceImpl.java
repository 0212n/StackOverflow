package com.demo.stackOverflow.service.impl;

import com.demo.stackOverflow.domain.entity.Member;
import com.demo.stackOverflow.domain.entity.User;
import com.demo.stackOverflow.domain.repo.UserRepo;
import com.demo.stackOverflow.domain.repo.util.UserNotFoundException;

public class UserServiceImpl {
	UserRepo userRepo;

	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public User getMember(String memberID) throws UserNotFoundException {
		return  userRepo.getUser(memberID);
	}
	
	public boolean doesUserExist(String email) {
		return userRepo.isRegistered(email);
	}
	
	public String addNewMember(String name, String email) {
		String id = userRepo.getNextID();
		Member newMember  = new Member(id, email, name);
		userRepo.addUser(id, newMember);
		return id;
	}
}
