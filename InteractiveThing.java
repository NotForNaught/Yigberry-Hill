package yigberryHill;

public class InteractiveThing {
	
	private int x;
	private int y;
	private String messageline1;
	private String messageline2;

	public InteractiveThing(int x, int y, String messageline1, String messageline2) {
		this.x = x;
		this.y = y;
		this.messageline1 = messageline1;
		this.messageline2 = messageline2;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public String getMessageline1() {
		return messageline1;
	}	
	
	public String getMessageline2() {
		return messageline2;
	}

}