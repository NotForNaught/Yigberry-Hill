package yigberryHill;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class TextBoxSprite implements Sprite {


	ImageIcon textbox = new ImageIcon("./textbox.png");
	private String words1 = "";
	private String words2 = "";
	int counter = 1000;
	char[] wordsanimation = null;
	Font font = new Font("Victor's Pixel Font", Font.PLAIN, 40);
	boolean on = false;
	String message = "";

	public void updateText(String s, String t) {
		if (on) {
			on = false;
			words1 = "";
			words2 = "";
		} else {
			on = true;
			words1 = s;
			words2 = t;
		}
	}
	
	public void update() {
	}

	@Override
	public void paint(Graphics g) {
		if (on) {
		 	g.drawImage(textbox.getImage(), 7, 290, 740, 225, null);	
			g.setFont(font);
		 	g.setColor(Color.BLACK);
		 	g.drawString(words1, 50, 390);
			g.drawString(words2, 50, 435);
		}
	}

}