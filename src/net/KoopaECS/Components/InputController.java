package net.KoopaECS.Components;

import org.newdawn.slick.Input;

import net.KoopaECS.Handlers.RenderHandler;

public class InputController {
	
	public Input keyboardInput = RenderHandler.gameContainer.getInput();
	
	
	
	public InputController(){
	}
	
	public void updateControlls(){
			if(keyboardInput.isKeyPressed(Input.KEY_A)){
				
		}
		
	}


}
