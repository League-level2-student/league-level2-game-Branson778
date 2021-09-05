import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class MovingObjectManager implements ActionListener {
Player player2 = new Player(50, 400, 50, 50);
ArrayList<Arrow> arrows = new ArrayList<Arrow>();
ArrayList<ArrowDispenser> dispensers = new ArrayList<ArrowDispenser>();
Timer arrowFire = new Timer(1250, this);
int debugInt;

void  draw (Graphics h) {
	player2.draw(h);
	for (int i = 0; i < arrows.size(); i++) {
		arrows.get(i).draw(h);
	}
	//h.setColor(Color.RED);
	//h.fillRect(50, 50, 15, 15);
}
MovingObjectManager(){
	
}
void update(){
	player2.update();
	for (int i = 0; i < arrows.size(); i++) {
		arrows.get(i).update();
	}
}
void startObjects() {
	arrowFire.start();
	dispensers.add(new ArrowDispenser(500,300,50,50));
}
void addArrow(Arrow arrow) {
	arrows.add(arrow);
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addArrow(dispensers.get(0).getArrow());
}
}
