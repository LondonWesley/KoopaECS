package net.KoopaECS.Handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import net.KoopaECS.Entities.Player;

public class LevelHandler {
	
	
	
	
	public void levelLoad(String level) throws FileNotFoundException, URISyntaxException{
		
		//URL path = ClassLoader.getSystemResource(level);
		//if(path==null) {
		     //The file was not found, insert error handling here
		//}
		File f = new File(ClassLoader.getSystemResource(level).toURI());
		Scanner _reader = new Scanner(f);
		
		while(_reader.hasNext()){
			buildLevel(_reader);
		}
			_reader.close();
	}
	
	
	

	
	
	public void levelDelete(){
		
		
		
	}
	
	
	public void buildLevel(Scanner reader){
		
		int entityID 	= reader.nextInt();
		int entityPosX 	= reader.nextInt();
		int entityPosY	= reader.nextInt();
		String entityTexture = reader.nextLine();
		
		if(entityID == 1){
			
			Player player = new Player(entityPosX, entityPosY, entityTexture);
			
		
		}
		
	}
	
	
}
