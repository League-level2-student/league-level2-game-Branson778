import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class PowerSoul extends MovingObject {
	public  BufferedImage image;
	public  boolean needImage = true;
	public  boolean gotImage = false;
	PowerSoul(int x, int y, int width, int height) {
		super(x, y, width, height);
		if(needImage) {
			loadImage("powerSoul.png");
		}
	}
	void draw(Graphics g){
		if(gotImage) {
			int xDifferencial = x - MovingObjectManager.player2.x;
			g.drawImage(image, PrecariousPlatformsRunner.WIDTH / 2 + xDifferencial,y, width, height, null);
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
