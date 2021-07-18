import java.awt.Color;
import java.awt.Graphics;

public class Player extends MovingObject {

	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 50;
		x=50;
		y=50;
	}
	void draw (Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 50);
	}
 public void walkLeft() {
	 x-=speed;
	 System.out.println("walkLeft");
 }
 public void walkRight() {
	 x+=speed;
	 System.out.println("walkRight");
 }
  public void jump() {
	  
  }
  public void duck() {
	  
  }
public void update() {
	
	
}
}
