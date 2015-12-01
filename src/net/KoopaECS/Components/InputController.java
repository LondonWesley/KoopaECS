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
		
		
		
	}
	
	
	
	public int getDirectionX() {
		
	}
	
	
}
