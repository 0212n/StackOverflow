package com.demo.stackOverflow.domain.entity;

public class Member extends User {
	Account account; 
	String email;
	String name;
	
	public Member(String userID, String email, String name) {
		super(userID);
		this.email = email;
		this.name = name;
		this.account = new Account();
	}

	public void addAccountInfo(EntityType question, String newID) {
		switch(question) {
			case QUESTION :
				account.questionsPosted.add(newID);
				break;
			case ANSWER :
				account.answersPosted.add(newID);
				break;
			case COMMENT :
				account.comments.add(newID);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountInfo() {
		return account.toString();
	}

	@Override
	public String toString() {
		return "Member [account=" + account + ", email=" + email + ", name=" + name + ", userId=" + userId + "]";
	}
}
