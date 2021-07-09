package com.demo.stackOverflow.domain.repo.util;

import com.demo.stackOverflow.domain.entity.EntityType;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(EntityType type , String entityID) {
		super( type + " with id : " + entityID + " not found");
		// TODO Auto-generated constructor stub
	}

	
	
	

}
