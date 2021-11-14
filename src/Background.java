import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Background {
	int x;
	int y;
	int width;
	int height;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public Background(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		if (needImage) {
			loadImage("gameBackgroundTEST.png");
		}
	}

	void draw(Graphics f) {
		if (gotImage) {
			for (int i = 0; i < 3; i++) {
				f.drawImage(image, x + i * PrecariousPlatformsRunner.WIDTH, y, PrecariousPlatformsRunner.WIDTH,
						PrecariousPlatformsRunner.LENGTH, null);
			}
		} else {
			f.setColor(Color.GRAY);
			f.fillRect(0, 0, PrecariousPlatformsRunner.WIDTH, PrecariousPlatformsRunner.LENGTH);
		}
	}

	void update() {
		x = (-MovingObjectManager.player2.x % (width * 2)) / 3;
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
