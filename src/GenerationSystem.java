import java.util.ArrayList;
import java.util.Random;

public class GenerationSystem {
	public static Random gen1 = new Random();
 public static ArrayList<PlatformObject> createPlatforms() {
	 ArrayList<PlatformObject> platforms = new ArrayList<PlatformObject>();
	int amount = gen1.nextInt(150)+1;
	 for(int i = 0; i < amount; i++ ) {
		 int ranX = gen1.nextInt(9000)+200;
		 int ranY = gen1.nextInt(400)+100;
		 int ranWidth = gen1.nextInt(75)+5;
		 int ranHeight = gen1.nextInt(80)+10;
		 PlatformObject platform1 = new PlatformObject(ranX,ranY,ranWidth,ranHeight,"Tileset_2EDIT6.png");
		 platforms.add(platform1);
	 }
	 return platforms;
 }
  public static ArrayList<DeathBlock> createDeathBlocks() {
	 ArrayList<DeathBlock> deathBlocks = new ArrayList<DeathBlock>();
	int amount = gen1.nextInt(100)+1;
	 for(int i = 0; i < amount; i++ ) {
		 int ranX = gen1.nextInt(9000)+200;
		 int ranY = gen1.nextInt(400)+100;
		 int ranWidth = gen1.nextInt(75)+5;
		 int ranHeight = gen1.nextInt(80)+10;
		 DeathBlock deathBlock1 = new DeathBlock(ranX,ranY,ranWidth,ranHeight);
		 deathBlocks.add(deathBlock1);
	 }
	 return deathBlocks;
  }
  public static ArrayList<Baddie> createBaddies() {
		 ArrayList<Baddie> baddies = new ArrayList<Baddie>();
			int amount = gen1.nextInt(75)+1;
			 for(int i = 0; i < amount; i++ ) {
				 int ranX = gen1.nextInt(9000)+200;
				 int ranY = gen1.nextInt(400)+100;
				 int ranWidth = gen1.nextInt(75)+5;
				 int ranHeight = gen1.nextInt(80)+10;
				 int ranMovement = gen1.nextInt(1000)+10;
				 int ranBoolDecide = gen1.nextInt(2);
				 boolean sideMove = false;
				 if(ranBoolDecide == 0) {
					 sideMove = true;
				 }
				 else if(ranBoolDecide == 1) {
					 sideMove = false;
				 }
				 Baddie baddie1 = new Baddie(ranX,ranY,ranWidth,ranHeight,ranX,ranMovement,sideMove);
				 baddies.add(baddie1);
			 }
			 return baddies; 
  } 
  public static ArrayList<ArrowDispenser> createDispensers() {
		 ArrayList<ArrowDispenser> souls = new ArrayList<ArrowDispenser>();
			int amount = gen1.nextInt(55)+1;
			 for(int i = 0; i < amount; i++ ) {
				 int ranX = gen1.nextInt(9000)+200;
				 int ranY = gen1.nextInt(400)+100;
				 int ranBoolDecide = gen1.nextInt(2);
				 boolean isFacingRight = false;
				 if(ranBoolDecide == 0) {
					 isFacingRight = true;
				 }
				 else if(ranBoolDecide == 1) {
					 isFacingRight = false;
				 }
				 ArrowDispenser dispenser1 = new ArrowDispenser(ranX,ranY,50,50, isFacingRight);
				 souls.add(dispenser1);
			 }
			 return souls;
  }
  public static ArrayList<PowerSoul> createPowerSouls() {
		 ArrayList<PowerSoul> souls = new ArrayList<PowerSoul>();
			int amount = gen1.nextInt(34)+1;
			 for(int i = 0; i < amount; i++ ) {
				 int ranX = gen1.nextInt(15000)+200;
				 int ranY = gen1.nextInt(400)+100;
				 PowerSoul soul1 = new PowerSoul(ranX,ranY,39,39);
				 souls.add(soul1);
			 }
			 return souls;
  }
}
