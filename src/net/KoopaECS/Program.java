package net.KoopaECS;

import net.KoopaECS.Framework.Window;
import net.KoopaECS.Handlers.CollisionHandler;
import net.KoopaECS.Handlers.RenderHandler;
import net.KoopaECS.Util.Config;


public class Program {
	
	public enum STATES {RUNNING, PAUSED, STOP};
	private STATES state;
	
	private RenderHandler renderHandler;
	private CollisionHandler collisionHandler;
	
	private Window window = new Window(Config.screenWidth, Config.screenHeight, "Koopa ECS| Engine");
	
	
	public void init(){}
	
	
	
	public void quit(){}
	
	
	
	public void run(){
		
		state = STATES.RUNNING;
		mainUpdate();
		
	}
	
	
	
	public void mainUpdate(){
		
		while(state != STATES.STOP){
			
			//Udates the Handlers :P
			
			renderHandler.update();
			collisionHandler.update();
			
		}
		
	}
	
	
}
