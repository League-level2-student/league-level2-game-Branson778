import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
Player player = new Player(0, 0, 15, 15);
MovingObjectManager mobm = new MovingObjectManager();
Timer frameDraw;
GamePanel(){
	frameDraw = new Timer(1000/60, this);
	frameDraw.start();
}
	@Override
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_SPACE || e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("JUMP");
		}
		if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_CONTROL || e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DUCK");
		}
		if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("MOVE LEFT");
			mobm.player2.walkLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("MOVE RIGHT");
			mobm.player2.walkRight();
		}
		if(e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_E) {
			System.out.println("TOGGLE SPRINT");
		}
	}
	void drawGame(Graphics f){
	f.setColor(Color.GRAY);
	f.fillRect(0, 0, 800, 500);
		mobm.draw(f);
	}
	void updateGame(){
		
	}
	
	@Override
	public void paintComponent(Graphics h) {
		drawGame(h);
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent frameUpdate) {
		// TODO Auto-generated method stub
		repaint();
	}
	public static void main(String[] args) {
		
	}

}
