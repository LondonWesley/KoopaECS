package net.KoopaECS.Handlers;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import net.KoopaECS.Components.Renderer;
import net.KoopaECS.Entities.BaseEntity;
import net.KoopaECS.Util.Config;


public class RenderHandler {


	private static ArrayList<Renderer> _rendererComponents;
	
	
	
	public RenderHandler() {
		
		_rendererComponents = new ArrayList<Renderer>();
		
	}
	
	
	
	public void update(GameContainer frame, Graphics graphics) throws SlickException {
		
		for (Renderer renderComponent : _rendererComponents) {
			
			// Clear screen for next render (Might be redundent / TODO: Check
			graphics.setColor(Config.backgroundColor);
			graphics.fillRect(0, 0, Config.screenWidth, Config.screenHeight);
			
			
			// Gather data from renderComponent's parent entity
			float x = (float) renderComponent._parentEntity.transform.x;
			float y = (float) renderComponent._parentEntity.transform.y;
			
			
			// Draw renderComponent's gathered data
			graphics.drawImage(renderComponent._texture, x, y);
			
		}
		
		
	}

	
	
	public static void registerRenderer(Renderer renderer) {
		_rendererComponents.add(renderer);
	}


}

