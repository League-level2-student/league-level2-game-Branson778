import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class PlatformObject {
//Normal Platforms
//Jump Through (Semi-Solid) Platforms
//Falling Platforms
//Arrow Trap
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	public  String imageField;
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	boolean touchingSide = false;
	boolean touchingBottom = false;
	boolean touchingTop = false;

	PlatformObject(int x, int y, int width, int height, String imageField) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.imageField = imageField;
		collisionBox = new Rectangle(x, y, width, height);
		if(needImage) {
			loadImage(imageField);
		}
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
		if(gotImage){
			int xDifferencial = x - MovingObjectManager.player2.x;
			g.drawImage(image, PrecariousPlatformsRunner.WIDTH/2 + xDifferencial, y, width, height, null);
	}
		else {
		g.setColor(Color.GRAY);
		// g.drawRect(800,500,800,299);
		int xDifferencial = x - MovingObjectManager.player2.x;
		g.fillRect(PrecariousPlatformsRunner.WIDTH / 2 + xDifferencial, y, width, height);
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
