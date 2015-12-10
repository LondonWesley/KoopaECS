package net.KoopaECS.Entities;

import net.KoopaECS.Components.Physics;
import net.KoopaECS.Handlers.EntityHandler;

public class ExampleEntity extends BaseEntity {
	
	public Physics physics;
	
	public ExampleEntity(float x, float y, String texturePath){
		super();
		// Physics(movementSpeed,Mass,base entity) leave baseentity as "this" meaning this class or itself
		physics = new Physics(30,30,this);
		physics.friction = 0.3; // MUST BE BETWEEN 0 AND 1 0
		
		
		transform.x = x;
		transform.y = y;
		
		renderer.generateTexture(texturePath); // this tells the renderer class to get the image
		
		EntityHandler.registerEntity(this); // adds the entity to entityhandler's list to be constantly updated
		
		
	}
	

	@Override
	public void update(double dt) {
		
		
		transform.update();
	
	}
	


}
