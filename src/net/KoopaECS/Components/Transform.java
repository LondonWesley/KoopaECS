package net.KoopaECS.Components;


public class Transform {
	
	public double x;
	public double y;
	
	
	public double angle;
	
	
	public Transform() {
		
		x = 0;
		y = 0;
		angle = 0;
		
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
		
		// Apply velocity to position
		
	}
	
}
