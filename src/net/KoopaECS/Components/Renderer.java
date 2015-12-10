package net.KoopaECS.Components;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import net.KoopaECS.Entities.BaseEntity;
import net.KoopaECS.Handlers.RenderHandler;


public class Renderer {

	public Image _texture;
	public BaseEntity _parentEntity;
	
	
	public Renderer(BaseEntity entity) {
		
		_parentEntity = entity;
		RenderHandler.registerRenderer(this);
		
	}
	
	
	
	public Renderer(BaseEntity entity, String texturePath) {
		
		_parentEntity = entity;
		RenderHandler.registerRenderer(this);
		generateTexture(texturePath);
		
	}

	
	
	public void generateTexture(String path) {
		
		try { 
			_texture = new Image(path);
		} catch (SlickException e) { e.printStackTrace(); }
		
	}

	
}


