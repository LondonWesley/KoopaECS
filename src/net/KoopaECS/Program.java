package net.KoopaECS;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import net.KoopaECS.Handlers.CollisionHandler;
import net.KoopaECS.Handlers.RenderHandler;
import net.KoopaECS.Util.Config;


public class Program {
	
	public enum STATES {RUNNING, PAUSED, STOP};
	private STATES _state;
	
	private RenderHandler    _renderHandler;
	private CollisionHandler _collisionHandler;
	
	
	
	public void init(){
		
		_renderHandler = new RenderHandler();
		_collisionHandler 	= new CollisionHandler();
		
		try {
			
			
			AppGameContainer window = new AppGameContainer(_renderHandler);
			window.setDisplayMode(Config.screenWidth, Config.screenHeight, false);
			window.start();
			
		} catch (SlickException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	
	public void quit() {}
	
	
	
	public void run() {
		
		_state = STATES.RUNNING;
		
		mainUpdate();
		
	}
	
	
	
	public void mainUpdate() {
		
		while(_state != STATES.STOP){
			
			// Update handlers
			//_renderHandler.update();
			_collisionHandler.update();
			
		}
		
	}
	
	
}
