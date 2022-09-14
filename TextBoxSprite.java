package yigberryHill;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.io.File;
import java.text.AttributedString;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TextBoxSprite implements Sprite {


	ImageIcon textbox = new ImageIcon("./textbox.png");
	private boolean input = false;
	private String words1 = "";
	private String words2 = "";
	JPanel j = new JPanel();
	int counter = 1000;
	char[] wordsanimation = null;
	
	@Override
	public void update() {
	}
	
	public void update(Input input, JPanel j) {
		if (input.isSpacebar()) {
			this.input = true;
			this.j = j;
			System.out.println("Space");
			
		} else if(input.isSpacebar() == false) {
			this.input = false;
		}
	}
	Font font = new Font("Victor's Pixel Font", Font.PLAIN, 30);

	@Override
	public void paint(Graphics g) {
		if(input) {
			g.drawImage(textbox.getImage(), 7, 290, 740, 225, null);
			
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString("you went to mailbox", 50, 490);
			
			//g.drawString(words2, 50, 525);
			
			
		} 
	}

	public void setInput(boolean input) {
		this.input = input;
	}
	
}
