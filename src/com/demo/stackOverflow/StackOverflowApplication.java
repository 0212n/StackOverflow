package com.demo.stackOverflow;

import java.util.Scanner;

import com.demo.stackOverflow.domain.entity.Votetype;
import com.demo.stackOverflow.domain.repo.EntityRepo;
import com.demo.stackOverflow.domain.repo.UserRepo;
import com.demo.stackOverflow.domain.repo.util.UserNotFoundException;
import com.demo.stackOverflow.service.impl.MemberServiceImpl;

public class StackOverflowApplication {
	static MemberServiceImpl serviceImpl;
	static UserRepo userRepo;
	static EntityRepo entityRepo;
	public static void main(String[] args) {
		entityRepo = new EntityRepo();
		userRepo = new UserRepo();
		serviceImpl = new MemberServiceImpl(userRepo, entityRepo);
		boolean exit = false;
		while(!exit) {
			try {
			System.out.println("Enter the input of your choice");
			System.out.println("1. Register as Member");
			System.out.println("2. Post a Question");
			System.out.println("3. Answer to the question");
			System.out.println("4. Add comment to the question or answer");
			System.out.println("5. Like a Question/Comment/Answer");
			System.out.println("6. Flag a Question");
			System.out.println("7. Vote a Question/Answer/Comment");
			System.out.println("8. Get Question");
			System.out.println("9. Get Top 3 answers for question");
			System.out.println("10. Get all comments on a Question/ Answer");
			System.out.println("11. Get all question Posted by a member");
			System.out.println("12. Get all answer posted by a member");
			System.out.println("13. Delete a question");
			System.out.println("14. Exit");
			Scanner sc=new Scanner(System.in);
			int inp = sc.nextInt();
			String memberID = null;
			if(inp != 1 && inp != 8 && inp!=10) {
				System.out.println("Enter Member ID :: ");
				memberID = sc.next();
				try {
					serviceImpl.getMember(memberID);
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.getMessage();
					System.out.println("Register as Member first");
					continue;
				}
			}
			switch(inp) {
				case 1 :
					System.out.println("Enter Email ID");
					String email = sc.next();
					while(serviceImpl.doesUserExist(email)) {
						System.out.println("Enter new Email ID");
						email = sc.next();
					}
					System.out.println("Enter Valid Name");
					String name = sc.next();
					String userID = serviceImpl.addNewMember(email, name);
					System.out.println("User Added with ID :: " + userID);
					break;
				case 2 :
					System.out.println("Enter Header of question");
					String header = sc.next();
					System.out.println("Enter your question : ");
					String message = sc.next();
					String questionID = serviceImpl.postQuestion(header, message, memberID);
					System.out.println("Question Added with ID :: " + questionID);
					break;
				case 3 :
					System.out.println("Enter answer of question");
					String answer = sc.next();
					System.out.println("Enter your question ID");
					String questionId = sc.next();
					String answerID = serviceImpl.addAnswer(answer, questionId, memberID);
					System.out.println("Answer Added with ID :: " + answerID);
					break;
				case 4 :
					System.out.println("Enter comment : ");
					String comment = sc.next();
					System.out.println("Enter your question/answer ID :");
					String entityId = sc.next();
					String commentId = serviceImpl.addComment(entityId, comment, memberID);
					System.out.println("Answer Added with ID :: " + commentId);
					break;
				case 5 :
					System.out.println("Enter your question/answer/Comment ID that you want to like :");
					entityId = sc.next();
					serviceImpl.addVote(entityId, Votetype.LIKES);
					System.out.println("Liked " + entityId);
					break;
				case 6 :
					System.out.println("Enter your question/answer/Comment ID that you want to flag :");
					entityId = sc.next();
					serviceImpl.addVote(entityId, Votetype.FLAG);
					System.out.println("Flagged " + entityId);
					break;
				case 7 :
					System.out.println("Enter your question/answer/Comment ID that you want to upvote :");
					entityId = sc.next();
					serviceImpl.addVote(entityId, Votetype.VIEWS);
					System.out.println("Voted " + entityId);
					break;
				case 8 :
					System.out.println("Enter your question ID to view :");
					questionID = sc.next();
					String Question = serviceImpl.getQuestion(questionID);
					System.out.println(Question);
					break;
				case 10 :
					System.out.println("Enter your question ID to view comments :");
					questionID = sc.next();
					String comments = serviceImpl.getComments(questionID);
					System.out.println(comments);
				case 11 :
					System.out.println("All Questions posted by user :" + memberID);
					String questions = serviceImpl.getAllQuestions(memberID);
					System.out.println(questions);
					break;
				case 14 :
					System.out.println("Exiting");
					exit = true;
					break;
				default :
					System.out.println("Invalid Input");
					
			}
			}
			catch(Exception e) {
				System.out.println("Something went wrong");
				continue;
			}
			
		}
	}
}
