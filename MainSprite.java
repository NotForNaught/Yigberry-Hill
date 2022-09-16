package yigberryHill;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class MainSprite implements Sprite {
	
	private int frameCounter = 0;

	ImageIcon mainchar =  new ImageIcon("./down1.png");
	ImageIcon down1 = new ImageIcon("./down1.png");
	ImageIcon down2 = new ImageIcon("./down2.png");
	ImageIcon down3 = new ImageIcon("./down3.png");
	ImageIcon down4 = new ImageIcon("./down4.png");
	ImageIcon up1 = new ImageIcon("./up1.png");
	ImageIcon up2 = new ImageIcon("./up2.png");
	ImageIcon up3 = new ImageIcon("./up3.png");
	ImageIcon up4 = new ImageIcon("./up4.png");
	ImageIcon right1 = new ImageIcon("./right1.png");
	ImageIcon right2 = new ImageIcon("./right2.png");
	ImageIcon right3 = new ImageIcon("./right3.png");
	ImageIcon right4 = new ImageIcon("./right4.png");	
	ImageIcon left1 = new ImageIcon("./left1.png");
	ImageIcon left2 = new ImageIcon("./left2.png");
	ImageIcon left3 = new ImageIcon("./left3.png");
	ImageIcon left4 = new ImageIcon("./left4.png");

	int frame = 1;
	
	ImageIcon plant = new ImageIcon("./pumpkins.png");
	int x = 608;
	int y = 448;
	
	@Override
	public void update() {
		frameCounter++;
	}
	
	public void update(Input input) {
		int frame = (frameCounter % 24) / 4 + 1;
		
		if (input.isDown()) {
			if (frame == 1) {
				mainchar = down1;
			} else if (frame == 2) {
				mainchar = down2;
			} else if (frame == 3) {
				mainchar = down3;
			} else if (frame == 4) {
				mainchar = down4;
			}
		}
		if (input.isLeft()) {
			if (frame == 1) {
				mainchar = left1;
			} else if (frame == 2) {
				mainchar = left2;
			} else if (frame == 3) {
				mainchar = left3;
			} else if (frame == 4) {
				mainchar = left4;
			}
		}
		if (input.isRight()) {
			if (frame == 1) {
				mainchar = right1;
			} else if (frame == 2) {
				mainchar = right2;
			} else if (frame == 3) {
				mainchar = right3;
			} else if (frame == 4) {
				mainchar = right4;
			}
		}
		if (input.isUp()) {
			if (frame == 1) {
				mainchar = up1;
			} else if (frame == 2) {
				mainchar = up2;
			} else if (frame == 3) {
				mainchar = up3;
			} else if (frame == 4) {
				mainchar = up4;
			}
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
		g.drawImage(mainchar.getImage(), 319, 186, 112, 128, null);

		//g.fillRect(345, 295, 10, 10);
	}
}