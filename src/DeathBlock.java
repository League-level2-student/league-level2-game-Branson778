import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class DeathBlock {
	int x;
	int y;
	int width;
	int height;
	int anotherDebug;
	Rectangle collisionBox;
	boolean touchingSide = false;
	boolean touchingBottom = false;
	boolean touchingTop = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	DeathBlock(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);
		if(needImage) {
			loadImage("deathblock.png");
		}
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
		if(gotImage) {
			int xDifferencial = x - MovingObjectManager.player2.x;
			g.drawImage(image, PrecariousPlatformsRunner.WIDTH / 2 + xDifferencial, y, width, height, null);
		} else {
			g.setColor(Color.RED);
			int xDifferencial = x - MovingObjectManager.player2.x;
			g.fillRect(PrecariousPlatformsRunner.WIDTH / 2 + xDifferencial, y, width, height);
		}
		}
		//g.setColor(Color.RED);
		// g.drawRect(800,500,800,299);
		//int xDifferencial = x - MovingObjectManager.player2.x;
		//g.fillRect(PrecariousPlatformsRunner.WIDTH / 2 + xDifferencial, y, width, height);
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
	public void theTrueStory() {
		loadImage("player6.png");
	}
}
