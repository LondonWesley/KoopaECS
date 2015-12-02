package net.KoopaECS.Components;

import org.newdawn.slick.Input;

import net.KoopaECS.Entities.BaseEntity;


public class InputController {
	
	private BaseEntity _parentEntity;
	private Input 	   _inputs;
	
	private int _directionX;
	private int _directionY;
	
	
	public InputController(BaseEntity entity) {
		
		_parentEntity = entity;
		_inputs = new Input(0);
		
		_directionX = 0;
		_directionY = 0;
		
	}
	
	
	public void update(double dt) {
		
		processInputs(dt);
		
	}

	
	// This will set the input directions
	private void processInputs(double dt) {
		
		// Used keys
		int w = Input.KEY_W;
		int s = Input.KEY_S;
		int a = Input.KEY_A;
		int d = Input.KEY_D;
		
		if (_inputs.isKeyDown(w))
			_directionY = -1;
		else if (_inputs.isKeyDown(s))
			_directionY = 1;
		else _directionY = 0;
		if (_inputs.isKeyDown(a))
			_directionX = -1;
		else if (_inputs.isKeyDown(d))
			_directionX = 1;
		else _directionX = 0;
		
		_parentEntity.transform.directionX = getDirectionX();
		_parentEntity.transform.directionY = getDirectionY();
		
	}
	

	
	
	public int getDirectionX() {
		
		return this._directionX;
		
	}
	
	
	
	public int getDirectionY(){
		
		return this._directionY;
		
	}
	
}
