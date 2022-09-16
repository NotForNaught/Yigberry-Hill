package yigberryHill;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class YigberryHillPanel extends JPanel {

	private List<Sprite> sprites;

	public void setSprites(List<Sprite> sprites) {
		this.sprites = sprites;
	}
	
	public void paint(Graphics g) {
		if (sprites != null) {
			for (Sprite sprite : sprites) {
				sprite.paint(g);
			}
		}
	}	
}