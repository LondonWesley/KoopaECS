package net.KoopaECS.Handlers;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import net.KoopaECS.Components.Renderer;
import net.KoopaECS.Util.Config;


public class RenderHandler {


	private static ArrayList<Renderer> _rendererComponents;
	
	
	
	public RenderHandler() {
		
		_rendererComponents = new ArrayList<Renderer>();
		
	}
	
	
	
	public void update(GameContainer frame, Graphics graphics) throws SlickException {
		
		graphics.setColor(Config.backgroundColor);
		graphics.fillRect(0, 0, Config.screenWidth, Config.screenHeight);
		
		for (Renderer renderComponent : _rendererComponents) {
			
			// Clear screen for next render (Might be redundent / TODO: Check
			
			// Gather data from renderComponent's parent entity
			float x = (float) renderComponent._parentEntity.transform.x;
			float y = (float) renderComponent._parentEntity.transform.y;
			
			
			// Draw renderComponent's gathered data
			graphics.drawImage(renderComponent._texture, x, y);
			
			if(Config.showBoundaries){
				
				float width = (float) renderComponent._parentEntity.collider.width;
				float height = (float) renderComponent._parentEntity.collider.height;
			
				float cx = (float) renderComponent._parentEntity.collider.x;
				float cy = (float) renderComponent._parentEntity.collider.y;
			
				
				graphics.setColor(new Color(255, 0, 0));
				graphics.drawRect(cx, cy, width, height);
				graphics.drawString("(" +cx+ "," +cy+ ")", cx - 50, cy);
				graphics.drawString("("+ Math.round(cx+width) + "," +Math.round(cy+height)+ ")2", cx + width + 10, cy + height);
				
			}
		}
		
		
	}

	
	
	public static void registerRenderer(Renderer renderer) {
		_rendererComponents.add(renderer);
	}


}

