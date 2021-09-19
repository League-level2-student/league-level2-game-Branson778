import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	MovingObjectManager mobm = new MovingObjectManager();
	Player player = mobm.player2;
Timer frameDraw;
int debugInt;
//PlatformObject po = new PlatformObject(0, 450, 800, 199);
//boolean ifJump = false;
//int velocity = 26;
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;	
GamePanel(){
	frameDraw = new Timer(1000/60, this);
	frameDraw.start();
	if(needImage) {
		loadImage("gameBackground.png");
	}
	mobm.startObjects();
}
	@Override
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_SPACE || e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("JUMP");
			//mobm.player2.jump();
			mobm.player2.isJumping = true;
			mobm.player2.velocity = 26;
		}
		if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_CONTROL || e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DUCK");
			mobm.player2.duck(true);
			//mobm.player2.isDucking=true;
			//mobm.player2.previousY=mobm.player2.y;
			//mobm.player2.y+=25;
		}
		if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT ) {
			System.out.println("MOVE LEFT");
			mobm.player2.walkLeft(true);
		}
		if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT ) {
			System.out.println("MOVE RIGHT");
			mobm.player2.walkRight(true);
		}
		if(e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_E) {
			System.out.println("TOGGLE SPRINT ON");
			//mobm.player2.speed=7;
			mobm.player2.isSprinting=true;
		}
	}
	void drawGame(Graphics f){
	//f.setColor(Color.GRAY);
	//f.fillRect(0, 0, 800, 500);
	if (gotImage) {
		f.drawImage(image, 0, 0, 800, 500, null);
	} else {
		f.setColor(Color.GRAY);
		f.fillRect(0, 0, 800, 500);
	}
	mobm.draw(f);
	//po.draw(f);
	}
	void updateGame(){
		mobm.update();
	//	for(i = 0; i < )
		//po.update();
		if(player.isActive == false) {
			
		}
	}
	
	@Override
	public void paintComponent(Graphics h) {
		drawGame(h);
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_CONTROL || e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DUCK RELSEASED");
			mobm.player2.duck(false);
			//mobm.player2.isDucking=false;
			//unmobm.player2.y=mobm.player2.previousY;
			//mobm.player2.targetHeight=50;
		}
		if(e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_E) {
			System.out.println("TOGGLE SPRINT OFF");
			//mobm.player2.speed=4;
			mobm.player2.isSprinting = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("MOVE LEFT");
			mobm.player2.walkLeft(false);
		}
		if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("MOVE RIGHT");
			mobm.player2.walkRight(false);
		}
		if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_SPACE || e.getKeyCode()==KeyEvent.VK_UP) {
		//	System.out.println("JUMP RELEASE");
			//mobm.player2.jump();
		//	mobm.player2.isJumping = false;
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
	public static void main(String[] args) {
		
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
