import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MovingObjectManager implements ActionListener {
	static Player player2 = new Player(50, 350, 50, 50);
	static ArrayList<Arrow> arrows = new ArrayList<Arrow>();
	static ArrayList<PlatformObject> platforms = new ArrayList<PlatformObject>();
	static ArrayList<ArrowDispenser> dispensers = new ArrayList<ArrowDispenser>();
	static ArrayList<DeathBlock> deathBlocks = new ArrayList<DeathBlock>();
	static ArrayList<Baddie> baddies = new ArrayList<Baddie>();
	Timer arrowFire = new Timer(1000, this);
	int debugInt;

	void draw(Graphics h) {
		for (int i = 0; i < arrows.size(); i++) {
			arrows.get(i).draw(h);
		}
		for (int i = 0; i < baddies.size(); i++) {
			baddies.get(i).draw(h);
		}
		for (int i = 0; i < dispensers.size(); i++) {
			dispensers.get(i).draw(h);
		}
		for (int i = 0; i < platforms.size(); i++) {
			platforms.get(i).draw(h);
		}
		for (int i = 0; i < deathBlocks.size(); i++) {
			deathBlocks.get(i).draw(h);
		}
		player2.draw(h);
		// h.setColor(Color.RED);
		// h.fillRect(50, 50, 15, 15);
	}

	MovingObjectManager() {

	}

	void update() {
		player2.update();
		checkCollision();
		purgeObjects();
		for (int i = 0; i < arrows.size(); i++) {
			arrows.get(i).update();
		}
		for (int i = 0; i < dispensers.size(); i++) {
			// dispensers.get(i).update();
		}
		for (int i = 0; i < platforms.size(); i++) {
			platforms.get(i).update();
		}
		for (int i = 0; i < deathBlocks.size(); i++) {
			deathBlocks.get(i).update();
		}
		for (int i = 0; i < baddies.size(); i++) {
			baddies.get(i).update();
		}
	}

	void startObjects() {
		arrowFire.start();
		dispensers.add(new ArrowDispenser(200, 400, 50, 50, true));
		dispensers.add(new ArrowDispenser(600, 300, 50, 50, false));
		platforms.add(new PlatformObject(200, 300, 50, 50, "Tileset_2EDIT6.png"));
		platforms.add(new PlatformObject(-600, 0, 600, PrecariousPlatformsRunner.LENGTH, "Tileset_2EDIT6ROCK.png"));
		platforms.add(new PlatformObject(-600, 450, 100600, 199, "Tileset_2EDIT6FLOOR.png"));
		deathBlocks.add(new DeathBlock(150, 425, 50, 25));
		baddies.add(new Baddie(600, 400, 50, 50, 250, 600, true));
		baddies.add(new Baddie(250, 400, 50, 50, 250, 600, true));
		baddies.add(new Baddie(650, 400, 50, 50, 150, 400, false));
		baddies.add(new Baddie(650, 150, 50, 50, 150, 400, false));
	}

	void addArrow(Arrow arrow) {
		arrows.add(arrow);
	}

	void purgeObjects() {
		for (int i = 0; i < arrows.size(); i++) {
			if (arrows.get(i).isActive == false) {
				arrows.remove(i);
				// System.out.println("arrow removed");
			}
		}
		for (int i = 0; i < baddies.size(); i++) {
			if (baddies.get(i).isActive == false) {
				baddies.remove(i);
				// System.out.println("baddie removed");
			}
		}
	}

	void checkCollision() {
		for (int i = 0; i < arrows.size(); i++) {
			if (arrows.get(i).collisionBox.intersects(player2.collisionBox)) {
				arrows.get(i).isActive = false;
				player2.isActive = false;
				// System.out.println("collisionBox instersection/arrow");
			}
		}
		for (int i = 0; i < deathBlocks.size(); i++) {
			if (deathBlocks.get(i).collisionBox.intersects(player2.collisionBox)) {
				// System.out.println("collisionBox intersection/deathBlock player");
				player2.isActive = false;
			}
			for (int j = 0; j < arrows.size(); j++) {
				if (deathBlocks.get(i).collisionBox.intersects(arrows.get(j).collisionBox)) {
					// System.out.println("collisionBox intersection/deathBlock arrow");
					arrows.get(j).isActive = false;
				}
			}
		}
		for (int i = 0; i < baddies.size(); i++) {
			if (baddies.get(i).collisionBox.intersects(player2.collisionBox)) {
				// System.out.println("collisionBox interscetion/baddie player");
				player2.isActive = false;
			}
			for (int j = 0; j < arrows.size(); j++) {
				if (baddies.get(i).collisionBox.intersects(arrows.get(j).collisionBox)) {
					// System.out.println("collisionBox intersection/baddie arrow");
					arrows.get(j).isActive = false;
				}
			}
		}

		for (int i = 0; i < platforms.size(); i++) {
			for (int j = 0; j < arrows.size(); j++) {
				if (platforms.get(i).collisionBox.intersects(arrows.get(j).collisionBox)) {
					// System.out.println("collisionBox intersction/platform arrow");
					arrows.get(j).isActive = false;
				}
			}
		}
		for (int i = 0; i < dispensers.size(); i++) {
			for (int j = 0; j < arrows.size(); j++) {
				if (dispensers.get(i).collisionBox.intersects(arrows.get(j).collisionBox)) {
					// System.out.println("collisionBox intersction/dispenser arrow");
					// arrows.get(j).isActive = false;
				}
			}
		}
	}

	public static boolean checkCollisionArea(Rectangle collider) {
		for (int i = 0; i < dispensers.size(); i++) {
			if (dispensers.get(i).collisionBox.intersects(collider)) {
				// System.out.println("collisionBox intersection/dispenser player");
				return true;
			}
		}
		for (int i = 0; i < platforms.size(); i++) {
			if (platforms.get(i).collisionBox.intersects(collider)) {
				// System.out.println("collisionBox intersection/platform player");
				return true;
			}
		}
		return false;
	}

	public void playerBump() {
		for (int i = 0; i < platforms.size(); i++) {
			if (platforms.get(i).collisionBox.intersects(player2.collisionBox)) {

			}
		}
	}
	public void theTrueStory() {
		JOptionPane.showMessageDialog(null, "You are the enslaver, the true villian. The slaves are mindless, but still try to take revenge. No one can control the eternal flame, no even you. Everyone thinks you are their tried savior and they follow orders and try to kill you. Run as long as possible to survive for more time. Time is all you need.");
		player2.theTrueStory();
		for(int i = 0; i < deathBlocks.size(); i++) {
			deathBlocks.get(i).theTrueStory();
		}
		for(int i = 0; i < baddies.size(); i++) {
			baddies.get(i).theTrueStory();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dispensers.size(); i++) {
			addArrow(dispensers.get(i).getArrow());
		}
	}
}
