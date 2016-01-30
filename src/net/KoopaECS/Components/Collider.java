package net.KoopaECS.Components;

import net.KoopaECS.Entities.BaseEntity;
import net.KoopaECS.Handlers.CollisionHandler;
import net.KoopaECS.Util.Config;

public class Collider {
	
	private BaseEntity _parentEntity;
	
	public double x;
	public double y;

	public double width;
	public double height;
	
	public double offsetX;
	public double offsetY;
	
	public double x2;
	public double y2;
	
	public boolean isColliding;
	public boolean stayOnScreen;
	
	
	
	public Collider(BaseEntity entity){
		
		_parentEntity	= entity;
		x 				= 0;
		y 				= 0;
		x2				= 0;
		y2				= 0;
		width 			= 0;
		height 			= 0;
		offsetX			= 0;
		offsetY			= 0;
		//Colliding boolean to trigger an event (damage, kill, power up methods, etc)
		
		isColliding	= false;
		stayOnScreen = false;
		
		CollisionHandler.registerCollider(this);
	}
	
	
	
	private void setBoundaries(double w, double h ,double offsetx ,double offsety){
		
		width 	= _parentEntity.transform.boxCollisionWidth;
		height 	= _parentEntity.transform.boxCollisionHeight;
		
		offsetX = _parentEntity.transform.boxCollisionOffsetX;
		offsetY = _parentEntity.transform.boxCollisionOffsetY;
		
		x 	= _parentEntity.transform.x + offsetX;
		y 	= _parentEntity.transform.y + offsetY;
		
		x2 	= x + w;
		y2 	= y + h;
		
		
	}
	
	
	
	public void update(){
	
		setBoundaries(width,height, offsetX, offsetY);
		
	}
	
	
	public boolean intersects(Collider collider){
			
			double dx = _parentEntity.transform.directionX * 20;
			double dy = _parentEntity.transform.directionY * 20;
		
			double x1 = this.x  + dx;
			double x2 = this.x2 + dx;
			double y1 = this.y  + dy;
			double y2 = this.y2 + dy;
			
			double collidedx1 = collider.x;
			double collidedx2 = collider.x2;
			double collidedy1 = collider.y;
			double collidedy2 = collider.y2;
			
			//TODO:finish this part and make it false if it isnt colliding
			
			if(y2> collidedy1)
				
				if(y1< collidedy2)
					
					if(x2> collidedx1)
						
						if(x1< collidedx2){
							
							isColliding = true;
							return true;
							
						}else
							
							isColliding = false;
							return false;
							
	}
	
	
	public void stayInBound(){
		
		if(stayOnScreen){
			
			double dx = _parentEntity.transform.directionX * 8;
			double dy = _parentEntity.transform.directionY * 8;
		
			double	collisionComponentX1 = x  + dx;
			double	collisionComponentY1 = y  + dy;
			double	collisionComponentX2 = x2 + dx;
			double	collisionComponentY2 = y2 + dy;
		
			double screenX = Config.screenWidth;
			double screenY = Config.screenHeight;
			
			if(collisionComponentX1<0 || collisionComponentX2>screenX)
				_parentEntity.xCollide = true;
			else _parentEntity.xCollide = false;
			
			if(collisionComponentY1<0 || collisionComponentY2>screenY)
				_parentEntity.yCollide = true;
			else _parentEntity.yCollide = false;
		}
	}
		
	
	/*TODO SCREWWW IIIIIT
	public void detectCollidingSide(Collider collidedEntity ){

		
		double dx = _parentEntity.transform.directionX;
		double dy = _parentEntity.transform.directionY;
		
		double	collisionComponentX1 = x;
		double	collisionComponentY1 = y;
		double	collisionComponentX2 = x2;
		double	collisionComponentY2 = y2;
		
		double collidedEntityX1 = collidedEntity.x;
		double collidedEntityY1 = collidedEntity.y;
		double collidedEntityX2 = collidedEntity.x2;
		
		
		//X Side Collision
		if(collisionComponentX1<collidedEntityX1)
			if(collisionComponentY2>collidedEntityY1 && collisionComponentY1<collidedEntityY2 )
				_parentEntity.xCollide = true;// colllide with leftside
		if(collisionComponentX2>collidedEntityX2)
			_parentEntity.xCollide = true; // collide with rightside
		else
			_parentEntity.xCollide = false;
		
		//Y Collision
		if(collisionComponentY1<collidedEntityY1)
			_parentEntity.yCollide = true; // collide with topside
		else if(collisionComponentY2>collidedEntityY2)
			_parentEntity.yCollide = true; // collide with bottomside
		else
			_parentEntity.yCollide = false;
	}
	*/

}
