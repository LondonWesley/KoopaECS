package net.KoopaECS.Components;

import org.newdawn.slick.Input;

import net.KoopaECS.Entities.BaseEntity;


public class InputController {
	
	private BaseEntity _parentEntity;
	private Input _inputs;
	
	
	public InputController(BaseEntity entity) {
		
		_parentEntity = entity;
		_inputs = new Input(0);
		
	}
	
	
	public void update(double dt) {
		
		processInputs(dt);
		
	}

	
	
	private void processInputs(double dt) {
		
		// Used keys
		int w = Input.KEY_W;
		int s = Input.KEY_S;
		int a = Input.KEY_A;
		int d = Input.KEY_D;
		
		// temp; TODO: setup rigidBody (mass, speed, etc implements there)
		double speed = 100.0 * dt;
		
		// Vertical movement
		if (_inputs.isKeyDown(w))
			_parentEntity.transform.y -= speed;
		
		if (_inputs.isKeyDown(s))
			_parentEntity.transform.y += speed;
		
		// Horizontal movement
		if (_inputs.isKeyDown(a))
			_parentEntity.transform.x -= speed;
		
		if (_inputs.isKeyDown(d))
			_parentEntity.transform.x += speed;
		
		
	}
	
	
}
