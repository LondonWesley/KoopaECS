package net.KoopaECS.Entities;

import net.KoopaECS.Components.InputController;
import net.KoopaECS.Handlers.EntityHandler;


public class Player extends BaseEntity {
	
	public InputController inputController;
	
	
	public Player(float x, float y, String texturePath) {
		
		super();
		
		inputController = new InputController(this);
		
		transform.x = x;
		transform.y = y;
		
		
		renderer.generateTexture(texturePath);
		
		EntityHandler.registerEntity(this);
		
	}


	// Update components belonging to entity
	@Override
	public void update(double dt) {		
		
		transform.update();
		inputController.update(dt);
		// Collisions
		
	}
	
	
	
}
