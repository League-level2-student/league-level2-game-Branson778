import javax.swing.JFrame;

public class PrecariousPlatformsRunner {
	JFrame frame = new JFrame();
	public static final int WIDTH = 800;
	public static final int LENGTH = 500;
	GamePanel gamePanel = new GamePanel();
	
	public static void main(String[] args) {
PrecariousPlatformsRunner ppr = new PrecariousPlatformsRunner();
ppr.setup();
	}

	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH,LENGTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamePanel);
	}
}
