import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class MovingObjectManager implements ActionListener {
static Player player2 = new Player(50, 400, 50, 50);
ArrayList<Arrow> arrows = new ArrayList<Arrow>();
static ArrayList<ArrowDispenser> dispensers = new ArrayList<ArrowDispenser>();
Timer arrowFire = new Timer(1000, this);
int debugInt;

void  draw (Graphics h) {
	player2.draw(h);
	for (int i = 0; i < arrows.size(); i++) {
		arrows.get(i).draw(h);
	}
	for (int i = 0; i < dispensers.size(); i++) {
		dispensers.get(i).draw(h);
	}
	//h.setColor(Color.RED);
	//h.fillRect(50, 50, 15, 15);
}
MovingObjectManager(){
	
}
void update(){
	player2.update();
	checkCollision();
	purgeObjects();
	for (int i = 0; i < arrows.size(); i++) {
		arrows.get(i).update();
	}
	for (int i = 0; i < dispensers.size(); i++) {
		//dispensers.get(i).update();
	}
}
void startObjects() {
	arrowFire.start();
	dispensers.add(new ArrowDispenser(200,400,50,50,true));
	dispensers.add(new ArrowDispenser(600,300,50,50,false));
}
void addArrow(Arrow arrow) {
	arrows.add(arrow);
}
void purgeObjects() {
	for (int i = 0; i < arrows.size(); i++) {
		if(arrows.get(i).isActive == false) {
			arrows.remove(i);
			System.out.println("arrow removed");
		}
	}
}
void checkCollision() {
	for (int i = 0; i < arrows.size(); i++) {
		if(arrows.get(i).collisionBox.intersects(player2.collisionBox)){
		arrows.get(i).isActive = false;
		player2.isActive = false;
		System.out.println("collisionBox instersection/arrow");
	}
	}
}
public static boolean checkCollisionArea(Rectangle collider) {
	for (int i = 0; i < dispensers.size(); i++) {
		if(dispensers.get(i).collisionBox.intersects(collider)) {
			System.out.println("collisionBox intersection/dispenser");
			return true;
		}
	}
	return false;
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	for(int i = 0; i < dispensers.size(); i++) {
	addArrow(dispensers.get(i).getArrow());
	}
}
}
