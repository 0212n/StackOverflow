package com.demo.stackOverflow.service.impl;

import java.util.List;

import com.demo.stackOverflow.domain.entity.Answer;
import com.demo.stackOverflow.domain.entity.BadgeType;
import com.demo.stackOverflow.domain.entity.Comment;
import com.demo.stackOverflow.domain.entity.Entity;
import com.demo.stackOverflow.domain.entity.EntityType;
import com.demo.stackOverflow.domain.entity.Member;
import com.demo.stackOverflow.domain.entity.Question;
import com.demo.stackOverflow.domain.entity.Votetype;
import com.demo.stackOverflow.domain.repo.EntityRepo;
import com.demo.stackOverflow.domain.repo.UserRepo;
import com.demo.stackOverflow.domain.repo.util.ResourceNotFoundException;
import com.demo.stackOverflow.domain.repo.util.UserNotFoundException;
import com.demo.stackOverflow.service.MemberService;
import com.demo.stackOverflow.service.ModeratorService;

public class MemberServiceImpl extends UserServiceImpl implements MemberService, ModeratorService {
	EntityRepo entityRepo;
	public MemberServiceImpl(UserRepo userRepo, EntityRepo entityRepo) {
		super(userRepo);
		// TODO Auto-generated constructor stub
		this.entityRepo = entityRepo;
	}

	@Override
	public String postQuestion(String header, String message, String memberID) {
		Member member = null;
		try {
			member = (Member) this.getMember(memberID);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		String newID = entityRepo.nextID();
		Question question = new Question(header, message, newID);
		entityRepo.addEntity(newID, question);
		question.setCreator(member);
		member.addAccountInfo(EntityType.QUESTION, newID);
		return newID;
	}

	@Override
	public String addComment(String entityID, String message, String memberID) {
		Member member = null;
		try {
			member = (Member) this.getMember(memberID);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Entity entity = null;
		try {
			entity = entityRepo.getEntity(entityID);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newID = entityRepo.nextID();
		Comment comment = new Comment(entityID, message, newID);
		entityRepo.addEntity(newID, comment);
		comment.setCreator(member);
		member.addAccountInfo(EntityType.COMMENT, newID);
		if(entity.getEntityType() == EntityType.QUESTION)
			((Question) entity).addCommentID(newID);
		if(entity.getEntityType() == EntityType.ANSWER)
			((Answer) entity).addCommentID(newID);
		return newID;
	}

	@Override
	public String addAnswer(String message, String questionID, String memberID) {
		Member member = null;
		try {
			member = (Member) this.getMember(memberID);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Entity entity = null;
		try {
			entity = entityRepo.getEntity(questionID);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		String newID = entityRepo.nextID();
		if(entity.getEntityType() == EntityType.QUESTION)
			((Question) entity).addAnswerID(newID);
		Answer answer = new Answer(questionID, message, newID);
		entityRepo.addEntity(newID, answer);
		answer.setCreator(member);
		member.addAccountInfo(EntityType.COMMENT, newID);
		return newID;
	}

	@Override
	public void flag(String entityID) {

		Entity entity = null;
		try {
			entity = entityRepo.getEntity(entityID);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.updateVote(Votetype.FLAG);
	}

	@Override
	public void addBadge(BadgeType type, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVote(String questionID, Votetype vote) {
		// TODO Auto-generated method stub
		
		Entity entity = null;
		try {
			entity = entityRepo.getEntity(questionID);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.updateVote(vote);
		
	}

	@Override
	public void close(String questionID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undelete(String questionID) {
		// TODO Auto-generated method stub
		
	}

	public String getQuestion(String entityId) {
		Question entity;
		try {
			entity = (Question) entityRepo.getEntity(entityId);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		return entity.toString();
	}
	
	public String getTopAnswer(String entityId, int topCount, Votetype type) {
		Question entity;
		try {
			entity = (Question) entityRepo.getEntity(entityId);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		return entity.toString();
	}

	public String getComments(String entityID) {
		Question entity;
		try {
			entity = (Question) entityRepo.getEntity(entityID);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		List<String> commentsIDs =  entity.getCommentIDs();
		StringBuffer str = new StringBuffer();
		for(String commentID : commentsIDs) {
			str.append(str.length() + 1);
			str.append(entityRepo.getEntity(commentID).toString());
			str.append("\\n");
		}
		return str.toString();
	}

	public String getAllQuestions(String memberID) {
		Member member = (Member) userRepo.getUser(memberID);
		return member.getAccountInfo();
	}

}
