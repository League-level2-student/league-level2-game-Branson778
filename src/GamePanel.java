import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Font;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	MovingObjectManager mobm = new MovingObjectManager();
	Player player = mobm.player2;
	Timer frameDraw;
	int debugInt;
	int backgroundX = 0;
	int backgroundY = 0;
	boolean theTrueStory = false;
	Background gameBackground = new Background(backgroundX, backgroundY - 80, PrecariousPlatformsRunner.WIDTH,PrecariousPlatformsRunner.LENGTH);
//PlatformObject po = new PlatformObject(0, 450, 800, 199);
//boolean ifJump = false;
//int velocity = 26;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean godMode = false;
	boolean godModeBan = false;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font overFont = new Font("Arial", Font.PLAIN, 75);
	Font titleFont = new Font("Arial", Font.PLAIN, 45);
	Font textFont = new Font("Arial", Font.PLAIN, 20);
	Font smolFont = new Font("Arial", Font.PLAIN, 15);

	GamePanel() {
		frameDraw = new Timer(1000 / 63, this);
		if (needImage) {
			loadImage("gameBackgroundTEST.png");
		}
		 playSound("jungleexcessive.wav");
			//mobm.startObjects();
		frameDraw.start();
		// playSound("5325576581152768.wav");
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenu(g);
		} else if (currentState == GAME) {
			drawGame(g);
		} else if (currentState == END) {
			drawEnd(g);
		}
	}

	public void drawMenu(Graphics g) {
		stopGame();
		g.setColor(Color.BLUE);
		g.fillRect(0,0,PrecariousPlatformsRunner.WIDTH,PrecariousPlatformsRunner.LENGTH);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("Welcome to Precarious Platforms!", 53,90);
		g.drawString("Backstory:", 290, 160);
		g.setFont(smolFont);
		g.drawString("You feel as your colors fade, someone is controlling the endless fire. Your memories start to slip away from you. ", 10, 185);
		g.drawString("But, before fully being consumed, you see what happens to your friends and family. They become slaves to a single", 10, 200);
		g.drawString("being. Shocked you start running, forgetting your past and only remember, free them all. You now burn in the colors of",10,215);
		g.drawString("light searching for the slaver of your people. Running far enough will bring you there. But where in the eternal jungle, the", 10, 230);
		g.drawString("temple of the endless fire is, is a mystery to you. Someone is controlling your people and you must stop them and", 10, 245);
		g.drawString("show them this won’t happen again.", 10, 260);
		g.setFont(titleFont);
		g.drawString("Controls:", 290, 295);
		g.setFont(smolFont);
		g.drawString("W, Up Arrow, or Space to jump. A or Left Arrow to move left. D or Right Arrow to move right. Shift or E to sprint. S,", 20, 320);
		g.drawString(" Control, or Down Arrow to crouch.", 270, 335);
		g.drawString("Try to avoid arrows, red squares, and living rocks.", 223, 360);
		g.setFont(textFont);
		g.drawString("Secerts exist! Try to find them all!",234, 395 );
		g.drawString("Press W, Up Arrow, or Space to start.", 216, 450);
		g.drawString("Lag may occur when game is started.", 220, 515);
	
	}

	public void drawEnd(Graphics g) {
		stopGame();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,PrecariousPlatformsRunner.WIDTH,PrecariousPlatformsRunner.LENGTH);
		g.setColor(Color.RED);
		g.setFont(overFont);
		g.drawString("You Died!",234, 140);
		g.setFont(textFont);
		g.drawString("Score: "+ player.score, 350, 190);
		g.drawString("Remember to avoid arrows, red squares, and living rocks.", 150, 250);
		g.drawString("Press W, Up Arrow, or Space to restart.", 216, 320);
		g.drawString("Lag may occur when game is restarted.", 220, 390);
		if(theTrueStory==true) {
			g.setColor(Color.WHITE);
			g.drawString("You found a secert! It came with some lore:", 195, 435);
			g.setFont(smolFont);
			g.drawString("You are the enslaver, the true villian. The slaves are mindless, but still try to take revenge. No one can control the ",10,450);
			g.drawString("eternal flame, not even you. Everyone thinks you are their tried savior and they follow orders and try to kill you. ",10,465);
			g.drawString("Run as long as possible to survive for more time. Time is all you need.",10,480);
		}
	}
	
	public void stopGame() {
		mobm.arrowFire.stop();
		mobm.platforms = new ArrayList<PlatformObject>();
		mobm.deathBlocks = new ArrayList<DeathBlock>();
		mobm.souls = new ArrayList<PowerSoul>();
		mobm.dispensers = new ArrayList<ArrowDispenser>();
		mobm.baddies = new ArrayList<Baddie>();
		mobm.portal = new ArrayList<Portal>();
		mobm.screenscroll = new ArrayList<ScreenscrollMonster>();
		player.isActive=true;
	}

	@Override

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_SPACE|| e.getKeyCode() == KeyEvent.VK_UP) {
			// System.out.println("JUMP");
			// mobm.player2.jump();
			if (mobm.player2.isJumping == false&&currentState==GAME) {
				mobm.player2.velocity = 26;
				mobm.player2.isJumping = true;
			}
			else if (currentState==MENU) {
				currentState=GAME;
				mobm.startObjects();
				player.x=50;
				player.y=350;
			}
			else if(currentState==END) {
				currentState=GAME;
				mobm.startObjects();
				player.x=50;
				player.y=350;
				//System.out.println("Working");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_CONTROL|| e.getKeyCode() == KeyEvent.VK_DOWN) {
			// System.out.println("DUCK");
			if(currentState==GAME) {
			mobm.player2.duck(true);
			}
			// mobm.player2.isDucking=true;
			// mobm.player2.previousY=mobm.player2.y;
			// mobm.player2.y+=25;
		}
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			// System.out.println("MOVE LEFT");
			if(currentState==GAME) {
			mobm.player2.walkLeft(true);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// System.out.println("MOVE RIGHT");
			if(currentState==GAME) {
			mobm.player2.walkRight(true);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_E) {
			// System.out.println("TOGGLE SPRINT ON");
			// mobm.player2.speed=7;
			if(currentState==GAME) {
			mobm.player2.isSprinting = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// mobm.theTrueStory = true;
			if(currentState==GAME) {
			mobm.theTrueStory();
			theTrueStory=true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SLASH) {
			if(godMode==false && godModeBan == false&&currentState==GAME) {
			godMode = true;
			JOptionPane.showMessageDialog(null, "Enjoy Godmode!");
			}
			else if (godMode==true && godModeBan == false&&currentState==GAME) {
				godMode = false;
				JOptionPane.showMessageDialog(null, "Don't Be Greedy. There Is No Super Godmode. You Are Banned From Godmode For This Session Of Gameplay!");
				godModeBan = true;
			}
			else if (godModeBan == true&&currentState==GAME) {
				JOptionPane.showMessageDialog(null, "We Told You. You Are Banned From Godmode For This Session Of Gameplay! No Exceptions! Unless You Hack The Game, But Then Why Would You Use These Cheat Codes, Just Set The Values In The Game Code!");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {
			if(godModeBan == false&&currentState==GAME) {
				JOptionPane.showMessageDialog(null, "You Found A Secert. It Could Be Useful Later.");
			}
			else if(godModeBan== true&&currentState==GAME) {
				JOptionPane.showMessageDialog(null, "You Found The Exception That Works Every Time. You Can Use This Button To Unban Godmode Any Time You Are Banned. Now, DON'T BE GREEDY!");
			godModeBan=false;
			}
			else {
				JOptionPane.showMessageDialog(null, "If You Are Seeing This You Somehow Broke The Game. Hats Off To You.");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ADD) {
			if(currentState==GAME) {
			player.x += 150000;
			}
			//debug for generation remove before finishing
		}
		if (e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
			if(currentState==GAME) {
			player.x += 105;
			}
			//became easter egg
		}
		if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
			if(currentState==GAME) {
			player.y -= 75;
			}
			//became easter egg
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
			currentState = END;
			//System.out.println("DEATHTEST");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_CONTROL
				|| e.getKeyCode() == KeyEvent.VK_DOWN) {
			// System.out.println("DUCK RELSEASED");
			if(currentState==GAME) {
			mobm.player2.duck(false);
			}
			// mobm.player2.isDucking=false;
			// unmobm.player2.y=mobm.player2.previousY;
			// mobm.player2.targetHeight=50;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_E) {
			// System.out.println("TOGGLE SPRINT OFF");
			// mobm.player2.speed=4;
			if(currentState==GAME) {
			mobm.player2.isSprinting = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			// System.out.println("MOVE LEFT");
			if(currentState==GAME) {
			mobm.player2.walkLeft(false);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// System.out.println("MOVE RIGHT");
			if(currentState==GAME) {
			mobm.player2.walkRight(false);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_SPACE|| e.getKeyCode() == KeyEvent.VK_UP) {
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
		if (currentState == MENU) {
			
		} else if (currentState == GAME) {
			updateGame();
		} else if (currentState == END) {
			
		}
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
					//clip.start();
					clip.loop(clip.LOOP_CONTINUOUSLY);
					while(currentState==GAME||currentState==MENU) {
						continue;
					}
					clip.stop();
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
