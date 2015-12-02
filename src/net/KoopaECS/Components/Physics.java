package net.KoopaECS.Components;

import net.KoopaECS.Entities.BaseEntity;

public class Physics {
	
	private double _mass;
	
	private double _baseSpeed;
	
	private double _accelerationX;
	private double _accelerationY;
	
	private double _velocityX;
	private double _velocityY;
	
	private BaseEntity _parentEntity;
	
	
	public Physics(double baseSpeed, double mass, BaseEntity entity) {
		
		_baseSpeed    = baseSpeed;
		_mass 		  = mass;
		_parentEntity = entity;
		
		_accelerationX = 0;
		_accelerationY = 0;
		
		_velocityX	   = 0;
		_velocityY	   = 0;
		
	}
	
	
	
	public void calcAcceleration(double dt) {
		
		double directionX = _parentEntity.transform.getDirectionX();
		double directionY = _parentEntity.transform.getDirectionY();
		
		double forceX = (directionX * _baseSpeed) * dt;
		double forceY = (directionY * _baseSpeed) * dt;
		
		 _accelerationX = forceX / _mass;
		 _accelerationY = forceY / _mass;
		 
	}
	
	public void updateDirections(){
		
		_parentEntity.transform.x += _accelerationX;
		_parentEntity.transform.y += _accelerationY;
		
	}
	
	
	
	
	public double getDistance(BaseEntity target){
		
		double dx = target.transform.x - _parentEntity.transform.x;
		double dy = target.transform.y - _parentEntity.transform.y;
		
		return Math.sqrt(dx * dx + dx * dy);
	}
	
	
	
	public void update(double dt){
		
		calcAcceleration(dt);
		updateDirections();
		
	}
}
