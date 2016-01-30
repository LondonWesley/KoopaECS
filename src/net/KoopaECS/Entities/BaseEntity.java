package net.KoopaECS.Entities;

import net.KoopaECS.Components.Collider;
import net.KoopaECS.Components.Renderer;
import net.KoopaECS.Components.Transform;
import net.KoopaECS.Handlers.EntityHandler;


public abstract class BaseEntity {

	public Renderer  renderer;
	public Collider  collider;
	public Transform transform;
	
	public boolean 	xCollide;
	public boolean 	yCollide;
	
	public double	velocity;
	
	
	// The parent to all entities -- Should instantiate its base-components
	public BaseEntity() {
		
		 // BaseEntity does not assign a texture, all deriving entities must generate the texture through their constructor. 
		renderer = new Renderer(this);
		
		collider = new Collider(this);
		
		transform = new Transform();
		
		xCollide = false;
		yCollide = false;
		
		velocity = 0;// for moving class detection
		
		
		
		//EntityHandler.registerEntity(this);
		
	}
	

	public abstract void update(double dt);
	
	
}
