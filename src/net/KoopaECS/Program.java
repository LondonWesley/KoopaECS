package net.KoopaECS;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import net.KoopaECS.Entities.Player;
import net.KoopaECS.Handlers.CollisionHandler;
import net.KoopaECS.Handlers.EntityHandler;
import net.KoopaECS.Handlers.RenderHandler;
import net.KoopaECS.Util.Config;


public class Program extends BasicGame {
	
	public enum STATES {RUNNING, PAUSED, STOP};
	private STATES _state;
	
	AppGameContainer _window;
	
	private RenderHandler    _renderHandler;
	private CollisionHandler _collisionHandler;
	private EntityHandler 	 _entityHandler;
	
	
	
	public Program() throws SlickException {
		
		super(Config.title);
		
		_renderHandler    = new RenderHandler();
		_collisionHandler = new CollisionHandler();
		_entityHandler    = new EntityHandler();
		
		_window = new AppGameContainer(this);
		_window.setDisplayMode(Config.screenWidth, Config.screenHeight, false);
		
		_window.start();
		
	}
	
	
	
	public void quit() {}
	
	
	
	public void run() throws SlickException {
		
		_state = STATES.RUNNING;
		
		
		
	}
	

	
	@Override
	public void init(GameContainer frame) throws SlickException {
		
		frame.setAlwaysRender(true);
		
		frame.setClearEachFrame(true);
		frame.setShowFPS(true);
		frame.setVSync(true);
		
		new Player(100, 100, "data/images/test.jpg");
		
	}
	
	

	@Override
	public void render(GameContainer frame, Graphics graphics) throws SlickException {
		
		_renderHandler.update(frame, graphics);
		
	}



	@Override
	public void update(GameContainer frame, int dt) throws SlickException {
		
		// Change dt from milliseconds to seconds
		double deltaTime = ((double) dt) / 1000;
		
		//_collisionHandler.update(dt);
		_entityHandler.update(deltaTime);
		
	}
	
	
}
