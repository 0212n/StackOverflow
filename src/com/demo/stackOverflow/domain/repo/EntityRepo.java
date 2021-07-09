package com.demo.stackOverflow.domain.repo;

import java.util.HashMap;

import com.demo.stackOverflow.domain.entity.Entity;
import com.demo.stackOverflow.domain.entity.EntityType;
import com.demo.stackOverflow.domain.repo.util.ResourceNotFoundException;

public class EntityRepo {
	HashMap<String, Entity> entityIDMap;

	public EntityRepo() {
		entityIDMap = new HashMap<>();
	}
	
	public Entity getEntity(String entityID) throws ResourceNotFoundException {
		if(entityIDMap.containsKey(entityID)) {
			return entityIDMap.get(entityID);
		}
		throw new ResourceNotFoundException( EntityType.ANSWER, entityID);
	}

	public String nextID() {
		int size = entityIDMap.size();
		return "E" + size;
	}

	public void addEntity(String newID, Entity entity) {
		this.entityIDMap.put(newID, entity);
	}
}
