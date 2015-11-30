package net.KoopaECS;

import org.newdawn.slick.SlickException;


public class Main {
	
	public static void main(String[] args){
		
		
		Program program;
		
		try {
			
			program = new Program();
			
			program.run();
			
		} catch (SlickException e) { e.printStackTrace(); }

		
	}
	
}
