package net.KoopaECS.Entities;

import net.KoopaECS.Components.InputController;


public class Player {
	
	public BaseEntity baseEntity;
	public InputController playerControls;
	
	
	
	public Player(){
		
		this.baseEntity = new BaseEntity("img");
		
	}
	
	
	
}
