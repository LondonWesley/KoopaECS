package net.KoopaECS.Components;


import java.net.URL;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import net.KoopaECS.Entities.BaseEntity;


public class Renderer {

	public Image texture;
	public BaseEntity parentEntity;
	
	
	public Renderer(BaseEntity entity, String texturePath) {
		
		generateTexture(texturePath);
		
	}

	
	
	void generateTexture(String path) {
		
		try {
			texture = new Image("ImgRes/Folder.jpg");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}


