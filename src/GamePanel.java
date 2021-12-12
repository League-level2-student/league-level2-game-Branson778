import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	MovingObjectManager mobm = new MovingObjectManager();
	Player player = mobm.player2;
	Timer frameDraw;
	int debugInt;
	int backgroundX = 0;
	int backgroundY = 0;
	boolean theTrueStory = false;
	Background gameBackground = new Background(backgroundX, backgroundY - 80, PrecariousPlatformsRunner.WIDTH,
			PrecariousPlatformsRunner.LENGTH);
//PlatformObject po = new PlatformObject(0, 450, 800, 199);
//boolean ifJump = false;
//int velocity = 26;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean godMode = true;

	GamePanel() {
		frameDraw = new Timer(1000 / 63, this);
		if (needImage) {
			loadImage("gameBackgroundTEST.png");
		}
		 playSound("jungleexcessive.wav");
			mobm.startObjects();
		frameDraw.start();
		// playSound("5325576581152768.wav");
	}

	@Override

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_SPACE
				|| e.getKeyCode() == KeyEvent.VK_UP) {
			// System.out.println("JUMP");
			// mobm.player2.jump();
			if (mobm.player2.isJumping == false) {
				mobm.player2.velocity = 26;
				mobm.player2.isJumping = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_CONTROL
				|| e.getKeyCode() == KeyEvent.VK_DOWN) {
			// System.out.println("DUCK");
			mobm.player2.duck(true);
			// mobm.player2.isDucking=true;
			// mobm.player2.previousY=mobm.player2.y;
			// mobm.player2.y+=25;
		}
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			// System.out.println("MOVE LEFT");
			mobm.player2.walkLeft(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// System.out.println("MOVE RIGHT");
			mobm.player2.walkRight(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_E) {
			// System.out.println("TOGGLE SPRINT ON");
			// mobm.player2.speed=7;
			mobm.player2.isSprinting = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// mobm.theTrueStory = true;
			mobm.theTrueStory();
		}
	}

	void drawBackground(Graphics f) {
		/*
		 * if (gotImage) { for(int i = 0; i < 3; i++) { f.drawImage(image, backgroundX +
		 * i*PrecariousPlatformsRunner.WIDTH, backgroundY,
		 * PrecariousPlatformsRunner.WIDTH, PrecariousPlatformsRunner.LENGTH, null); } }
		 * else { f.setColor(Color.GRAY); f.fillRect(0, 0,
		 * PrecariousPlatformsRunner.WIDTH, PrecariousPlatformsRunner.LENGTH); }
		 */

	}

	void drawGame(Graphics f) {
		// f.setColor(Color.GRAY);
		// f.fillRect(0, 0, 800, 500);
		// drawBackground(f);
		gameBackground.draw(f);
		mobm.draw(f);
		// po.draw(f);
	}

	void updateGame() {
		gameBackground.update();
		mobm.update();
		// for(i = 0; i < )
		// po.update();
		if (player.isActive == false && godMode == false) {
			// System.out.println("player/dead");
		}
	}

	@Override
	public void paintComponent(Graphics h) {
		drawGame(h);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_CONTROL
				|| e.getKeyCode() == KeyEvent.VK_DOWN) {
			// System.out.println("DUCK RELSEASED");
			mobm.player2.duck(false);
			// mobm.player2.isDucking=false;
			// unmobm.player2.y=mobm.player2.previousY;
			// mobm.player2.targetHeight=50;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_E) {
			// System.out.println("TOGGLE SPRINT OFF");
			// mobm.player2.speed=4;
			mobm.player2.isSprinting = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			// System.out.println("MOVE LEFT");
			mobm.player2.walkLeft(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// System.out.println("MOVE RIGHT");
			mobm.player2.walkRight(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_SPACE
				|| e.getKeyCode() == KeyEvent.VK_UP) {
			// System.out.println("JUMP RELEASE");
			// mobm.player2.jump();
			// mobm.player2.isJumping = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent frameUpdate) {
		// TODO Auto-generated method stub
		updateGame();
		repaint();
	}

	private void playSound(String fileName) {
		String path = "src/" + fileName;
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.out.println("playSound error " + e.getMessage() + " for " + path);
				}
			}
		}

		).start();
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

}
