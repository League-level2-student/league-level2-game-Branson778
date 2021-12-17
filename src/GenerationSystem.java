import java.util.ArrayList;
import java.util.Random;

public class GenerationSystem {
	public static Random gen1 = new Random();
 public static ArrayList<PlatformObject> createPlatforms() {
	 ArrayList<PlatformObject> platforms = new ArrayList<PlatformObject>();
	int amount = gen1.nextInt(650)+1;
	 for(int i = 0; i < amount; i++ ) {
		 int ranX = gen1.nextInt(15000)+201;
		 int ranY = gen1.nextInt(211)+250;
		 int ranWidth = gen1.nextInt(51)+25;
		 int ranHeight = gen1.nextInt(71)+15;
		 PlatformObject platform1 = new PlatformObject(ranX,ranY,ranWidth,ranHeight,"Tileset_2EDIT6.png");
		 platforms.add(platform1);
	 }
	 return platforms;
 }
  public static ArrayList<DeathBlock> createDeathBlocks() {
	 ArrayList<DeathBlock> deathBlocks = new ArrayList<DeathBlock>();
	int amount = gen1.nextInt(390)+1;
	 for(int i = 0; i < amount; i++ ) {
		 int ranX = gen1.nextInt(15000)+201;
		 int ranY = gen1.nextInt(315)+100;
		 int ranWidth = gen1.nextInt(51)+25;
		 int ranHeight = gen1.nextInt(71)+15;
		 DeathBlock deathBlock1 = new DeathBlock(ranX,ranY,ranWidth,ranHeight);
		 deathBlocks.add(deathBlock1);
	 }
	 return deathBlocks;
  }
  public static ArrayList<Baddie> createBaddies() {
		 ArrayList<Baddie> baddies = new ArrayList<Baddie>();
			int amount = gen1.nextInt(240)+1;
			 for(int i = 0; i < amount; i++ ) {
				 int ranX = gen1.nextInt(15000)+201;
				 int ranY = gen1.nextInt(141)+10;
				 int ranWidth = gen1.nextInt(51)+25;
				 int ranHeight = gen1.nextInt(71)+15;
				 int ranBoolDecide = gen1.nextInt(2);
				 int ranMovement = 0;
				 boolean sideMove = false;
				 Baddie baddie1;
				 if(ranBoolDecide == 0) {
					 sideMove = true;
				 }
				 else if(ranBoolDecide == 1) {
					 sideMove = false;
				 } 
				 if(sideMove) {
				 ranMovement = gen1.nextInt(5000)+ranX;
				 baddie1 = new Baddie(ranX,ranY,ranWidth,ranHeight,ranX,ranMovement,sideMove);
				 }
				 else {
				 ranMovement = gen1.nextInt(215)+ranY;
				 baddie1 = new Baddie(ranX,ranY,ranWidth,ranHeight,ranY,ranMovement,sideMove);
				 }
				 baddies.add(baddie1);
			 }
			 return baddies; 
  } 
  public static ArrayList<ArrowDispenser> createDispensers() {
		 ArrayList<ArrowDispenser> dispensers = new ArrayList<ArrowDispenser>();
			int amount = gen1.nextInt(55)+1;
			 for(int i = 0; i < amount; i++ ) {
					// TODO Auto-generated method stub
				 int ranX = gen1.nextInt(15000)+7001;
				 int ranY = gen1.nextInt(201)+180;
				 int ranBoolDecide = gen1.nextInt(2);
				 boolean isFacingRight = false;
				 if(ranBoolDecide == 0) {
					 isFacingRight = true;
				 }
				 else if(ranBoolDecide == 1) {
					 isFacingRight = false;
				 }
				 ArrowDispenser dispenser1 = new ArrowDispenser(ranX,ranY,50,50, isFacingRight);
				 dispensers.add(dispenser1);
			 }
			 return dispensers;
  }
  public static ArrayList<PowerSoul> createPowerSouls() {
		 ArrayList<PowerSoul> souls = new ArrayList<PowerSoul>();
			int amount = gen1.nextInt(290)+1;
			 for(int i = 0; i < amount; i++ ) {
				 int ranX = gen1.nextInt(16000)+201;
				 int ranY = gen1.nextInt(315)+100;
				 PowerSoul soul1 = new PowerSoul(ranX,ranY,39,39);
				 souls.add(soul1);
			 }
			 return souls;
  }
}
