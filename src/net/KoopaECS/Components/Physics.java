package net.KoopaECS.Components;

import net.KoopaECS.Entities.BaseEntity;

public class Physics {
	
	private double _mass;
	
	private double _baseSpeed;
	
	private double _accelerationX;
	private double _accelerationY;
	
	private double _velocityX;
	private double _velocityY;
	
	private double _friction;
	
	private BaseEntity _parentEntity;
	
	
	public Physics(double baseSpeed, double mass, BaseEntity entity) {
		
		_baseSpeed    	= baseSpeed;
		_mass 		  	= mass;
		_parentEntity 	= entity;
		
		_accelerationX 	= 0;
		_accelerationY 	= 0;
		
		_velocityX	   	= 0;
		_velocityY	   	= 0;
//TODO: add friction
		_friction		= 0.89;
		
	}
	
	
	
	public void calcAcceleration(double dt) {
		
		double directionX = _parentEntity.transform.getDirectionX();
		double directionY = _parentEntity.transform.getDirectionY();
		
		double forceX = (directionX * _baseSpeed) * dt;
		double forceY = (directionY * _baseSpeed) * dt;
		
		 _accelerationX = forceX / _mass;
		 _accelerationY = forceY / _mass;
		 
		 
	}
	public void addVelocity(){
		_velocityX += _accelerationX;
		_velocityY += _accelerationY;
	}
	
	public void updateDirections(){
//TODO: apply friction to slow down
		_parentEntity.transform.x += _velocityX;
		_parentEntity.transform.y += _velocityY;
		applyFriction();
	}
	
	private void applyFriction(){
		
		double directionX = _parentEntity.transform.getDirectionX();
		double directionY = _parentEntity.transform.getDirectionY();
		
		//BUG: if you change directions too fast friction is non existant :D
		//just an ugly thing i did here to test
		if(directionX == 0)
			_velocityX = _velocityX*_friction;
		
		if(directionY == 0)
			_velocityY = _velocityY*_friction;
			
	}
	
	
	
	
	public double getDistance(BaseEntity target){
		
		double dx = target.transform.x - _parentEntity.transform.x;
		double dy = target.transform.y - _parentEntity.transform.y;
		
		return Math.sqrt(dx * dx + dx * dy);
	}
	
	
	
	public void update(double dt){
		
		calcAcceleration(dt);
		updateDirections();
		addVelocity();
		
	}
}
