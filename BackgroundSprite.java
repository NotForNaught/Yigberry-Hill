package yigberryHill;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class BackgroundSprite implements Sprite {

	private ImageIcon background = new ImageIcon("./background.png");
	int x = -608;
	int y = -446;
	int width = 1800;
	int height = 1200;
	boolean isText = false;
	
	private List<Rectangle> blocks = new ArrayList<Rectangle>();
	
	public BackgroundSprite() {
		blocks.add(new Rectangle(-500, -250, 500, 512));		
	}
	
	
	public void setText(boolean isText) {
		this.isText = isText;
	}
	
	
	@Override
	public void update() {
	}
	
	
	public int getCharacterLocationX() {
		int xx = -(x) + 375;
		
		// x is Math.abs(background x + half window width)
		// y is Math.abs(background y + half window height)
		
		return xx;
	}
	
	public int getCharacterLocationY() {
		int yy = -(y) + 250;
		return yy;
	}

	
	public void update(Input input) {
		
		if (input.isDown() && y >= -700 && !isText) {
			y -= 2;
		}
		if (input.isUp() && y <= -300 && !isText && !Main.intersects(-500, -250, 500, 512, x, y, 100, 200)) {
			y += 2; 
		}
		if (input.isRight() && x >= -1049 && !isText && !Main.intersects(-500, -250, 500, 512, x, y, 100, 200)) {
			x -= 2;
		} 
		if (input.isLeft() && x <= 0 && !isText && !Main.intersects(-500, -250, 500, 512, x, y, 100, 200)) {
			x += 2;
		}
		
	}
	//-790 x -320 y

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(background.getImage(), x, y, width, height, null);		
	}

}
