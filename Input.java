package yigberryHill;

public class Input {
	private boolean down = false;
	private boolean up = false;
	private boolean left = false;
	private boolean right = false;
	private boolean spacebar = false;
	
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}	
	public boolean isSpacebar() {
		return spacebar;
	}
	public void setSpacebar(boolean spacebar) {
		this.spacebar = spacebar;
	}
	
}
