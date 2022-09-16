package yigberryHill;

import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Main {

	private static int MIN_INTERACTIVE_DISTANCE = 150;

	public static void main(String[] args) throws FontFormatException, IOException, LineUnavailableException, UnsupportedAudioFileException, InterruptedException {
		Input input = new Input();
		List<Sprite> sprites = new ArrayList<Sprite>();
		List<InteractiveThing> things = getInteractiveThings();
		BackgroundSprite background = new BackgroundSprite();
		sprites.add(background);
		MainSprite main = new MainSprite();
		sprites.add(main);
		TextBoxSprite textbox = new TextBoxSprite();
		sprites.add(textbox);
		
		JFrame window = new JFrame("Yigberry Hill");
		YigberryHillPanel panel = new YigberryHillPanel();
		panel.addKeyListener(new YigberryHillKeyListener(input));
		panel.setFocusable(true);
		panel.requestFocus();
		window.setSize(750,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.getContentPane().add(panel);
		window.setVisible(true);
		
		//String words = "words";
		//char[] list = words.toCharArray();  converting strings to lists
				
		int ifLoop = 8040;
		
		long last = 0;
		while (true) {
			if (System.currentTimeMillis() - last > 17) {
				last = System.currentTimeMillis();
				String soundName = "backgroundmusic.wav";   
				if(ifLoop >= 7300) {
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					ifLoop = 0;
				} else {
					ifLoop++;
				}
				
				// handle input

				background.update(input);

				if (input.isSpacebar()) {
					int cx = background.getCharacterLocationX();
					int cy = background.getCharacterLocationY();

					InteractiveThing thing = getClosestUsableInteractiveThing(things, cx, cy);
					if (thing != null) {
						textbox.updateText(thing.getMessageline1(), thing.getMessageline2());
					}
				}
				// if we set this to false, we reset if somebody pushed spacebar every iteration
				input.setSpacebar(false);

				main.update(input);
				
				// update world
				for (Sprite s : sprites) {
					s.update();
				}
				
				// draw
				panel.setSprites(sprites);
				panel.repaint();
				
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException iExc) {
					// suppress, we don't care
				}
			}
		}
		
	}
	public static boolean intersects(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
		Rectangle r1 = new Rectangle(x1, y1, w1, h1);
		return r1.intersects(new Rectangle(x2, y2, w2, h2));
	}

	public static int distance(int x1, int y1, int x2, int y2) {
		double tosqrt = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
		return (int) Math.sqrt(tosqrt);
	}

	public static List<InteractiveThing> getInteractiveThings() {
		List<InteractiveThing> things = new ArrayList<InteractiveThing>();
		things.add(new InteractiveThing(500, 573, "You interacted with", "the mailbox."));
		things.add(new InteractiveThing(373, 548, "You interacted with", "the door."));
		return things;
	}

	public static InteractiveThing getClosestUsableInteractiveThing(List<InteractiveThing> things, int x, int y) {
		InteractiveThing result = null;
		int shortestDistance = Integer.MAX_VALUE;
		for (InteractiveThing thing : things) {
			int d = Main.distance(thing.getX(), thing.getY(), x, y);
			System.out.println("Spacebar pushed, distance is " + d);
			System.out.println("Thing is at " + thing.getX() + ", " + thing.getY());
			System.out.println("Character is at " + x + ", " + y); 
			if (d < MIN_INTERACTIVE_DISTANCE && d < shortestDistance) { 
				result = thing; 
				shortestDistance = d;
			}	
		}
		return result;
	}
}