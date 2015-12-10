package net.KoopaECS.Handlers;

import java.util.ArrayList;

import net.KoopaECS.Components.Collider;

public class CollisionHandler {	
	
	private static ArrayList<Collider>  _collisionComponents;
	
	
	
	public CollisionHandler() {
	
		_collisionComponents = new ArrayList<Collider>();
	
	}
	
	public static void registerCollider(Collider collider){
		
		_collisionComponents.add(collider);
	
	}
	
	public void update(double dt){
		
		for(Collider collisionComponent: _collisionComponents){
			
			for(Collider collisionComponent2: _collisionComponents){
				checkCollision(collisionComponent,collisionComponent2);
			}
			
		}
		
	}
	
	
	private void checkCollision(Collider collisionComponent, Collider collidedEntity){
		
		//check to make sure we dont say we collide with our selves
		
		if(collisionComponent != collidedEntity){
			
			double x1 = collisionComponent.x;
			double x2 = collisionComponent.x2;
			double y1 = collisionComponent.y;
			double y2 = collisionComponent.y2;
			
			double collidedx1 = collidedEntity.x;
			double collidedx2 = collidedEntity.x2;
			double collidedy1 = collidedEntity.y;
			double collidedy2 = collidedEntity.y2;
			
			if(y2> collidedy1){
				
				if(y1< collidedy2){
			
					if(x2> collidedx1){
			
						if(x1< collidedx2){
							System.out.println("Collision detected!");
							
						}
					}
				}
			}

			
			
		}
	}
	

}
