package net.KoopaECS.Entities;

import net.KoopaECS.Components.Collider;
import net.KoopaECS.Components.Renderer;
import net.KoopaECS.Components.Transform;
import net.KoopaECS.Handlers.EntityHandler;


public abstract class BaseEntity {

	public Renderer  renderer;
	public Collider  collider;
	public Transform transform;
	
	
	// The parent to all entities -- Should instantiate its base-components
	public BaseEntity() {
		
		 // BaseEntity does not assign a texture, all deriving entities must generate the texture through their constructor. 
		renderer = new Renderer(this);
		
		collider = new Collider();
		
		transform = new Transform();
		
		//EntityHandler.registerEntity(this);
		
	}
	

	public abstract void update(double dt);
	
	
}
