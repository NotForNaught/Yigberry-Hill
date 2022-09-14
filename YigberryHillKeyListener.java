package yigberryHill;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class YigberryHillKeyListener implements KeyListener {

	private Input input;
	private boolean on = false;
	BackgroundSprite isText = new BackgroundSprite();
	Main main = new Main();
	
	public YigberryHillKeyListener(Input input) {
		this.input = input;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == ' ' && !on && main.distance(isText.getX(), -130, isText.getY(), -448) <= 477) {
			input.setSpacebar(true);
			on = true;
		} else if (e.getKeyChar() == ' ' && on) {
			input.setSpacebar(false);
			on = false;
		}
	}

	//x = 130 y = 448
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			input.setUp(true);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			input.setDown(true);
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			input.setLeft(true);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			input.setRight(true);
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			input.setUp(false);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			input.setDown(false);
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			input.setLeft(false);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			input.setRight(false);
		} 
	}

}
