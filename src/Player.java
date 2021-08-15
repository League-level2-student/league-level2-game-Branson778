import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends MovingObject {
 int jump = 7;
 int debugInt;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		if(needImage) {
			loadImage("player.png");
		}
		speed = 12;
		x=50;
		y=50;
		width=50;
		height=50;
	}
	void draw (Graphics g) {
		if(gotImage) {
			g.drawImage(image, x, y, width, height, null);
		}
		else {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		}
	}
 public void walkLeft() {
	 x-=speed;
	 System.out.println("walkLeft");
 }
 public void walkRight() {
	 x+=speed;
	 System.out.println("walkRight");
 }
  public void jump(Graphics g, int velocity) {
	  System.out.println("jump");
	//  for (int i = 0; i < 7; i++) {
	//	y-=jump;
		//draw(g);
	//	System.out.println("jumpUp"+i);
//	}
	//  for (int i = 0; i < 7; i++) {
	//	y+=jump;
		//draw(g);
		//System.out.println("jumpDown"+i);
//	}
	  y=y-velocity;
	  draw(g);
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
