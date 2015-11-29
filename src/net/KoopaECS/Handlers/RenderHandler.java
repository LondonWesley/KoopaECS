package net.KoopaECS.Handlers;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import net.KoopaECS.Components.Renderer;
import net.KoopaECS.Entities.Player;
import net.KoopaECS.Util.Config;


public class RenderHandler extends BasicGame {


	ArrayList<Renderer> rendererComponents = new ArrayList<Renderer>();
	
	Player player;
	
	public static GameContainer gameContainer;
	
	// Setup render context
	public RenderHandler() {
		
		super("KoopaECS|Engine");
		
	}


	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		
		g.setBackground(Config.backgroundColor);
		g.drawImage(player.baseEntity.renderer.texture, 20,20);
		
	}


	
	public void init(GameContainer gc) throws SlickException {
		
		player = new Player();
		gc = gameContainer;
		
	}


	
	public void update(GameContainer gc, int delta) throws SlickException {
		
		//player.playerControls. -- not feenished
		
	}

}

