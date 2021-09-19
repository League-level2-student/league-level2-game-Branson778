import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Player extends MovingObject {
 int jump = 7;
 int debugInt;
 int previousY;
 int targetHeight = 50;
 int velocity = 0;
 double stamina = 200;
 Font earlyStageStaminaFont = new Font("Arial", Font.PLAIN, 35);
 public boolean isJumping = false;
 public boolean goingLeft = false;
 public boolean goingRight = false;
 public boolean isSprinting = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public boolean isDucking = false;
	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		if(needImage) {
			loadImage("player.png");
		}
		speed = 4;
		//x=50;
		//y=50;
		//width=50;
		//height=50;
	}
	void draw (Graphics g) {
		if(gotImage) {
			g.drawImage(image, x, y, width, height, null);
		}
		else {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		}
		g.setFont(earlyStageStaminaFont);
		g.setColor(Color.YELLOW);
		g.drawString(stamina+"", 27, 50);
	}
 public void walkLeft(boolean left) {
	 goingLeft=left;
	// x-=speed;
	 System.out.println("walkLeft");
 }
 public void walkRight(boolean right) {
	 goingRight = right;
	 //x+=speed;
	 System.out.println("walkRight");
 }
 /*
  public void jump(int velocity) {
	  System.out.println("jump");
	  int newY;
	  newY = y-velocity;
	  Rectangle collider = new Rectangle(x,newY,width,height);
	  if(!MovingObjectManager.checkCollisionArea(collider)) {
		 y=newY; 
	  }
  }
  */
  void applyGravity() {
	  int newY;
	  newY = y-velocity;
	  Rectangle collider = new Rectangle(x,newY,width,height);
	  if(!MovingObjectManager.checkCollisionArea(collider)) {
		 y=newY; 
	  }
	  else{
		 velocity=0; 
		 isJumping = false;
	  }
		velocity = velocity-2;
		if(velocity<-26) {
			velocity = -26;
		}
  }
  public void duck(boolean shouldDuck) {
 if(isDucking==true && shouldDuck==false && height==targetHeight && isJumping==false) {
	 isDucking=false;
	targetHeight=50; 
	y=previousY;
 }
 if(isDucking==false && shouldDuck==true && height==targetHeight && isJumping==false) {
	 isDucking=true;
	 previousY=y;
	// y+=25;
	 targetHeight = 25;
 } 
 if(isDucking==true && shouldDuck==true) {
	 
 }
 if(isDucking==false && shouldDuck==false) {
	 
 }
  }
public void update() {
	super.update();
	//System.out.println("update");
	//if(isDucking==true) {
		//height = 25;
	//}
	//else{
		//height = 50;
	//}
	if(height<targetHeight) {
		height++;
		int heightDif=50-height;
		y=previousY+heightDif;
	}
	if(height>targetHeight) {
		height--;
		int heightDif=height-50;
		y=previousY-heightDif;
	}
	/*if(isJumping==true) {
		jump(velocity);
		velocity = velocity-2;
		if(velocity<-26) {
			isJumping = false;
			velocity = 26;
		}
	}
	*/
	applyGravity();
	if(isSprinting==true && stamina>0) {
		speed = 10;
		stamina--;
	}
	else {
		speed = 4;
		if(stamina<200 && isSprinting == false) {
			stamina+=0.5;
		}
	}
	if(isDucking==true) {
		speed-=2; 
	}
	//if(isSprinting==true && isDucking==true) {
	//	speed = 5;
	//}
	if(goingLeft==true) {
		//x-=speed;
		int newX = x-speed;
		Rectangle collider = new Rectangle(newX,y,width,height);
		if(!MovingObjectManager.checkCollisionArea(collider)) {
			x=newX;
		}
	}
	if(goingRight==true) {
		//x+=speed;
		int newX = x+speed;
		Rectangle collider = new Rectangle(newX,y,width,height);
		if(!MovingObjectManager.checkCollisionArea(collider)) {
			x=newX;
		}
	}
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
