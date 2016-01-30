package net.KoopaECS.Entities;

import net.KoopaECS.Components.Physics;
import net.KoopaECS.Handlers.EntityHandler;


public class Block extends BaseEntity {
	
	
	public Physics physics;
	
	public Block(float x, float y, String texturePath) {
		
		super();
		
		physics = new Physics(750, 5, this);

		
		
		transform.x 	= x;
		transform.y 	= y;
		
		transform.boxCollisionWidth = 200;
		transform.boxCollisionHeight = 200;
		
		transform.boxCollisionOffsetX = 0;
		transform.boxCollisionOffsetY = 0;
		
		
		renderer.generateTexture(texturePath);
		
		EntityHandler.registerEntity(this);
		
	}


	// Update components belonging to entity
	@Override
	public void update(double dt) {		
		
		transform.update();
		physics.update(dt);
		collider.update();
		
	}
	
	
	
}
