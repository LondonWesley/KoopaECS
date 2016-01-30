package net.KoopaECS.Components;

import net.KoopaECS.Entities.BaseEntity;

public class Physics {
	
	private double _mass;
	
	private double _baseSpeed;
	
	public double accelerationX;
	public double accelerationY;
	
	private double _velocityX;
	private double _velocityY;
	
	public double friction;
	
	private BaseEntity _parentEntity;
	
	
	public Physics(double baseSpeed, double mass, BaseEntity entity) {
		
//TODO: make physical properties public and accessible
		_baseSpeed    	= baseSpeed;
		_mass 		  	= mass;
		_parentEntity 	= entity;
		
		accelerationX 	= 0;
		accelerationY 	= 0;
		
		_velocityX	   	= 0;
		_velocityY	   	= 0;
//friction should be between 0 and 1
		friction		= 0.3; //by default
		
	}
	
	
	
	public void calcAcceleration(double dt) {
		
		double directionX = _parentEntity.transform.getDirectionX();
		double directionY = _parentEntity.transform.getDirectionY();
		
		double forceX = (directionX * _baseSpeed) * dt;
		double forceY = (directionY * _baseSpeed) * dt;
		
		accelerationX = forceX / _mass;
		accelerationY = forceY / _mass;
		 
	}
	
	
	public void addVelocity(){

		if(!_parentEntity.xCollide)
			_velocityX += accelerationX - friction*_velocityX;
		else _velocityX = 0;
		if(!_parentEntity.yCollide)
			_velocityY += accelerationY - friction*_velocityY;
		else _velocityY = 0;
		
	}
	
	
	public void updateDirections(){
		
		if(!_parentEntity.xCollide)
			_parentEntity.transform.x += _velocityX;
		else _velocityX = 0;
		if(!_parentEntity.yCollide)
			_parentEntity.transform.y += _velocityY;
		else _velocityY = 0;
	
	}
	
	
	public double getDistance(BaseEntity target){
		
		double dx = target.transform.x - _parentEntity.transform.x;
		double dy = target.transform.y - _parentEntity.transform.y;
		
		return Math.sqrt(dx * dx + dx * dy);
		
	}
	
	
	
	public void update(double dt){
		
		calcAcceleration(dt);
		addVelocity();
		updateDirections();
		
	}
}
