package net.KoopaECS;

import net.KoopaECS.Framework.Window;
import net.KoopaECS.Handlers.CollisionHandler;
import net.KoopaECS.Handlers.RenderHandler;
import net.KoopaECS.Util.Config;


public class Program {
	
	public enum STATES {RUNNING, PAUSED, STOP};
	private STATES _state;
	
	private RenderHandler    _renderHandler;
	private CollisionHandler _collisionHandler;
	
	private Window _window = new Window(Config.screenWidth, Config.screenHeight, "KoopaECS| Engine");
	
	
	
	public void init() {
		
		_renderHandler 	  = new RenderHandler();
		_collisionHandler = new CollisionHandler();
		
	}
	
	
	
	public void quit() {}
	
	
	
	public void run() {
		
		_state = STATES.RUNNING;
		
		mainUpdate();
		
	}
	
	
	
	public void mainUpdate() {
		
		while(_state != STATES.STOP){
			
			// Update handlers
			_renderHandler.update();
			_collisionHandler.update();
			
		}
		
	}
	
	
}
