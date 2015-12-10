package net.KoopaECS.Components;

import net.KoopaECS.Entities.BaseEntity;
import net.KoopaECS.Handlers.CollisionHandler;

public class Collider {
	
	public BaseEntity parentEntity;
	
	public double x;
	public double y;

	public double width;
	public double height;
	
	public double offsetX;
	public double offsetY;
	
	public double x2;
	public double y2;
	
	public boolean isColliding;
	
	
	
	public Collider(BaseEntity entity){
		
		parentEntity	= entity;
		x 				= 0;
		y 				= 0;
		x2				= 0;
		y2				= 0;
		width 			= 0;
		height 			= 0;
		offsetX			= 0;
		offsetY			= 0;
		isColliding	= false;
		
		CollisionHandler.registerCollider(this);
	}
	
	
	
	private void setBoundaries(double w, double h ,double offsetx ,double offsety){
		
		width 	= parentEntity.transform.boxCollisionWidth;
		height 	= parentEntity.transform.boxCollisionHeight;
		
		offsetX = parentEntity.transform.boxCollisionOffsetx;
		offsetY = parentEntity.transform.boxCollisionOffsety;
		
		x 	= parentEntity.transform.x + offsetX;
		y 	= parentEntity.transform.y + offsetY;
		
		x2 	= x + w;
		y2 	= y + h;
		
		
	}
	
	
	
	public void update(){
	
		setBoundaries(width,height, offsetX, offsetY);
		
	}
	
}
