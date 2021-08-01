import java.awt.Color;
import java.awt.Graphics;

public class Player extends MovingObject {
 int jump = 7;
	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 12;
		x=50;
		y=50;
		width=50;
		height=50;
	}
	void draw (Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
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
	  System.out.println("jump");
	  for (int i = 0; i < 7; i++) {
		y-=jump;
		System.out.println("jumpUp"+i);
	}
	  for (int i = 0; i < 7; i++) {
		y+=jump;
		System.out.println("jumpDown"+i);
	}
  }
  public void duck() {
	  height = 50;
	  height = 45;
	  height = 40;
	  height = 35;
	  height = 30;
	  height = 25;
	  height = 30;
	  height = 35;
	  height = 40;
	  height = 45;
	  height = 50;
  }
public void update() {
	
	
}
}
