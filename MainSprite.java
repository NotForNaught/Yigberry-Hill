package yigberryHill;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class MainSprite implements Sprite {

	ImageIcon mainchar = new ImageIcon("./character.png");
	ImageIcon plant = new ImageIcon("./pumpkins.png");
	int x = 608;
	int y = 448;
	
	@Override
	public void update() {
	}
	
	public void update(Input input) {
		if (input.isUp()) {
			y += 2;
			System.out.println(Integer.toString(y));
		}
		if (input.isDown()) {
			y -= 2;
			System.out.println(Integer.toString(y));
		}
		if (input.isLeft()) {
			x -= 2;
			System.out.println(Integer.toString(x));
		}
		if (input.isRight()) {
			x += 2;
			System.out.println(Integer.toString(x));
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(mainchar.getImage(), 325, 150, 100, 200, null);

		//g.fillRect(345, 295, 10, 10);
	}
}