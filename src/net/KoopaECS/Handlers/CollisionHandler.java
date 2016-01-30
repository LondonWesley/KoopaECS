package net.KoopaECS.Handlers;

import java.util.ArrayList;

import net.KoopaECS.Program;
import net.KoopaECS.Components.Collider;

public class CollisionHandler {	
	
	private static ArrayList<Collider>  _collisionComponents;
	
	
	
	public CollisionHandler() {
	
		_collisionComponents = new ArrayList<Collider>();
	
	}
	
	public static void registerCollider(Collider collider){
		
		_collisionComponents.add(collider);
	
	}
	
	
	public static void unregisterCollider(Collider collider){
		
		_collisionComponents.remove(collider);
		
	}
	
	
	public void update(double dt){
			//TODO:Remove Program from imports and go to Program
		for(Collider collisionComponent: _collisionComponents){
			collisionComponent.stayInBound();
			for(Collider collisionComponent2: _collisionComponents){
				
				checkCollision(collisionComponent,collisionComponent2);
			
			}
		}
		
	}
	
	
	private void checkCollision(Collider collisionComponent, Collider collidedEntity){
		
		if(collisionComponent.intersects(collidedEntity)){	
			
			collisionComponent.isColliding = true;
			
		}
		
	}
	

}
