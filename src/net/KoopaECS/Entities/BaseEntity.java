package net.KoopaECS.Entities;

import net.KoopaECS.Components.Collider;
import net.KoopaECS.Components.Renderer;
import net.KoopaECS.Components.Transform;


public class BaseEntity {

	public Renderer renderer;
	Collider collider;
	public Transform transform;
	
	
	
	public BaseEntity(String pic) {
		
		this.renderer = new Renderer(this, pic);
		
	}
	
}
