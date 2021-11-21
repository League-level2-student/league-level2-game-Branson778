import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PrecariousPlatformsRunner {
	// Now an infinite runner instead of an infinite platformer.
	JFrame frame = new JFrame();
	public static final int WIDTH = 800;
	public static final int LENGTH = 600;
	GamePanel gamePanel = new GamePanel();
	int debugInt;

	public static void main(String[] args) {
		PrecariousPlatformsRunner ppr = new PrecariousPlatformsRunner();
		ppr.setup();
	}

	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, LENGTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamePanel);
		frame.setTitle("Precarious Platforms");
        JOptionPane.showMessageDialog(frame, "Your feel as your colors fade, someone is controlling the endless fire. Your memories start to slip away from you. But, before fully being consumed, you see what happens to yours friends and family. They become slaves to a single being. \n Shocked you start running forgetting your past and only remember, free them all. You now burn in the colors of light searching for the slaver of your people. Running far enough will bring you there. \n But where in the eternal jungle, the temple of the endless fire is, is a mystery to you. Someone is controlling your people and you must stop them and show them this won’t happen again.");
	}
}
