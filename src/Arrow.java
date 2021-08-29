import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Arrow extends MovingObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public boolean facingLeft = false;
	public boolean facingRight = true;
	int speed = 9;
	Arrow(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		if(needImage) {
			if(facingRight==true) {
				loadImage("arrowRight.png");
			}
			if(facingLeft==true) {
				loadImage("arrowLeft.png");
			}
			if(facingLeft==false && facingRight==false) {
				loadImage("gameBackground.png");
			}
		}
	}
void update() {
	if(facingLeft==true) {
		moveLeft();
	}
	if(facingRight==true) {
		moveRight();
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
		g.drawImage(image, x, y, width, height, null);
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
