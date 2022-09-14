package yigberryHill;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class YigberryHillKeyListener implements KeyListener {

	private Input input;
	private boolean on = false;
	
	public YigberryHillKeyListener(Input input) {
		this.input = input;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == ' ') {
			input.setSpacebar(true);
		}
	}

	//x = 130 y = 448
	
	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_W || c == KeyEvent.VK_UP) {
			input.setUp(true);
		} else if (c == KeyEvent.VK_S || c == KeyEvent.VK_DOWN) {
			input.setDown(true);
		} else if (c == KeyEvent.VK_A || c == KeyEvent.VK_LEFT) {
			input.setLeft(true);
		} else if (c == KeyEvent.VK_D || c == KeyEvent.VK_RIGHT) {
			input.setRight(true);
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
                int c = e.getKeyCode();
		if(c == KeyEvent.VK_W || c == KeyEvent.VK_UP) {
			input.setUp(false);
		} else if (c == KeyEvent.VK_S || c == KeyEvent.VK_DOWN) {
			input.setDown(false);
		} else if (c == KeyEvent.VK_A || c == KeyEvent.VK_LEFT) {
			input.setLeft(false);
		} else if (c == KeyEvent.VK_D || c == KeyEvent.VK_RIGHT) {
			input.setRight(false);
		} 
	}

}
