package net.KoopaECS.Framework;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	
	
	public Window(int x, int y, String title){
		setSize(x,y);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
	}
	
}
