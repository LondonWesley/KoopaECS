package net.KoopaECS.Handlers;

import java.util.ArrayList;

import net.KoopaECS.Entities.BaseEntity;


public class EntityHandler {
	
	private static ArrayList<BaseEntity> _entities;
	
	
	public EntityHandler() {
		
		_entities = new ArrayList<BaseEntity>();
		
	}
	
	
	
	public void update(double dt) {
		
		for (BaseEntity entity : _entities) {
			
			entity.update(dt);
			
		}
		
	}
	
	
	
	public static void registerEntity(BaseEntity entity) {
		_entities.add(entity);
	}
	
}
