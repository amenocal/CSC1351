import java.applet.Applet;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Applet1 extends Applet {

	int pressed = 0;
	
	public void init() {
		setBackground(Color.white);
		addKeyListener(new KeyAdapter() {

			public void KeyPressed(KeyEvent ke) {
				pressed = ke.getKeyCode();
				if(pressed == 'r'){
					System.out.println("Red");
				}
				setBackground(Color.red);
				repaint();
			}
		});
	}
	public void paint(Graphics g){
	if( pressed != 0){
	g.drawString("Letter pressed: " + pressed , 0,10);
	}
   }

}
