package yigberryHill;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.io.File;
import java.text.AttributedString;

import javax.swing.ImageIcon;

public class TextBoxSprite implements Sprite {


	ImageIcon textbox = new ImageIcon("./textbox.png");
	private boolean input = false;
	private String words1 = "";
	private String words2 = "";
	int counter = 1000;
	char[] wordsanimation = null;
	Font font = new Font("Victor's Pixel Font", Font.PLAIN, 30);
	boolean on = false;
	String message = "";

	public void updateText(String s) {
		if (on) {
			on = false;
			message = "";
		} else {
			on = true;
			message = s;
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
			g.drawString(message, 50, 490);
			
			//g.drawString(words2, 50, 525);
		} 
	}

}
