import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Arrow extends MovingObject{
	public  BufferedImage image;
	public  boolean needImage = true;
	public  boolean gotImage = false;	
//	public boolean facingLeft = false;
	public boolean facingRight = true;
	int speed = 9;
	Arrow(int x, int y, int width, int height, boolean facingRight) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.facingRight=facingRight;
		if(needImage) {
			if(facingRight==true) {
				loadImage("arrowRight.png");
			}
			else {
				loadImage("arrowLeft.png");
			}
			//if(facingLeft==false && facingRight==false) {
				//loadImage("gameBackground.png");
			//}
		}
	}
void update() {
	super.update();
	if(facingRight==true) {
		moveRight();
	}
	else {
		moveLeft();
	}
}
void moveLeft() {
	x-=speed;
}
void moveRight() {
	x+=speed;
}
void draw(Graphics g) {
	if (gotImage) {
		int xDifferencial = x - MovingObjectManager.player2.x;
		g.drawImage(image, PrecariousPlatformsRunner.WIDTH/2 + xDifferencial, y, width, height, null);
	} else {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
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
