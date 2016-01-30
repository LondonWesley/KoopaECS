package net.KoopaECS.Components;


public class Transform {
	
	public double x;
	public double y;
	
	public double boxCollisionWidth;
	public double boxCollisionHeight;
	
	public double boxCollisionOffsetX;
	public double boxCollisionOffsetY;
	
	public double directionX;
	public double directionY;
	
	
	public double angle;
	
	
	public Transform() {
		
		boxCollisionWidth 		= 0;
		boxCollisionHeight 		= 0;
		x 			= 0;
		y 			= 0;
		directionX 	= 0;
		directionY 	= 0;
		
		angle 		= 0;
		
		
	}
	
	
	
	
	public Transform(double x, double y) {
		
		this.x = x;
		this.y = y;
		this.angle = 0;
		
	}


	
	public Transform(double x, double y, double angle) {
		
		this.x = x;
		this.y = y;
		this.angle = angle;
		
	}
	

	public void update() {
		
		
		
	}




	public double getDirectionY() {
		
		return this.directionY;
	}




	public double getDirectionX() {
		
		return this.directionX;
	}
	
}
