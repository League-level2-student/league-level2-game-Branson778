import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ArrowDispenser extends MovingObject {
	public  BufferedImage image;
	public  boolean needImage = true;
	public  boolean gotImage = false;
ArrowDispenser(int x, int y, int width, int height, boolean facingRight) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.facingRight=facingRight;
		if(needImage) {
			if(facingRight==true) {
				loadImage("DispenserRight.png");
			}
			else {
				loadImage("DispenserLeft.png");
			}
			//if(facingLeft==false && facingRight==false) {
				//loadImage("gameBackground.png");
			//}
		}
	}
//public boolean facingLeft = false;
public boolean facingRight = false;
public Arrow getArrow() {
	return new Arrow(x, y+height/2-15, 34, 9,facingRight );
}
void draw(Graphics g) {
	if (gotImage) {
		g.drawImage(image, x, y, width, height, null);
	} else {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
}
/*
void arrowLeft(Arrow arrow) {
	facingRight = false;
	arrow.facingRight = false;
}
void arrowRight(Arrow arrow) {
	facingRight = true;
	arrow.facingRight = true;
}
*/
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
