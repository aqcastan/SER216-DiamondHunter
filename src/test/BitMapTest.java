package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.com.neet.DiamondHunter.Entity.Player;
import main.com.neet.DiamondHunter.TileMap.Tile;
import main.com.neet.DiamondHunter.TileMap.TileMap;

public class BitMapTest {
	
	@Test
	public void TestBorder() {
		TileMap testMngr = new TileMap(16);
		testMngr.loadTiles("/Tilesets/testtileset.gif");
		testMngr.loadMap("/Maps/testmap.map");
		Player testPlayer = new Player(testMngr,0);
		testPlayer.setPosition(0, 0);
		
		System.out.print("Start of top row: ");
		for(int i = 0; i < testMngr.getNumRows(); i++) {
			if(i == 0 || i == testMngr.getNumRows()-1) {
				for(int j = 0; j < testMngr.getNumCols(); j++) {
					testPlayer.setPosition(i,j); //set player location
					testMngr.setPositionImmediately(testPlayer.getx(),testPlayer.gety()); //set map pointer location
					
					System.out.print("Is Blocked = " + testMngr.getType(testPlayer.getx(), testPlayer.gety()));
					System.out.print(" ("+testPlayer.getx()+", "+testPlayer.gety()+") | "); //player position
					
					
					System.out.print("Is Blocked = " + testMngr.getType(testMngr.getx(), testMngr.gety()));
					System.out.print(" ("+testMngr.getx()+", "+testMngr.gety()+") || "); //map pointer position
					assertTrue(testMngr.getType(testPlayer.getx(), testPlayer.gety()) == Tile.BLOCKED 
							&& testMngr.getx() == testPlayer.getx() && testMngr.gety() == testPlayer.gety());
					assertTrue(testMngr.getType(testMngr.getx(), testMngr.gety()) == Tile.BLOCKED 
							&& testMngr.getx() == testPlayer.getx() && testMngr.gety() == testPlayer.gety());
				}
				System.out.println();
			}
			else {
				
				//setting position of player on left edge of the map
				testPlayer.setPosition(i,0);
				System.out.print("Left Side: Is Blocked = " + testMngr.getType(testPlayer.getx(), testPlayer.gety()));
				System.out.print(" ("+testPlayer.getx()+", "+testPlayer.gety()+") | ");
				
				//setting position of map pointer based on player position on left edge
				testMngr.setPositionImmediately(testPlayer.getx(),testPlayer.gety());
				System.out.print(testMngr.getType(testPlayer.getx(), testPlayer.gety()));
				System.out.print(" ("+testPlayer.getx()+", "+testPlayer.gety()+") || ");
			
				//checking if current player tile is blocked
				assertTrue(testMngr.getType(testPlayer.getx(), testPlayer.gety()) == Tile.BLOCKED 
						&& testMngr.getx() == testPlayer.getx() && testMngr.gety() == testPlayer.gety());
				assertTrue(testMngr.getType(testMngr.getx(), testMngr.gety()) == Tile.BLOCKED 
						&& testMngr.getx() == testPlayer.getx() && testMngr.gety() == testPlayer.gety());
				
				//setting position of player on the right edge of the map
				testPlayer.setPosition(i,testMngr.getNumCols()-1);
				System.out.print("Right Side: Is Blocked = " + testMngr.getType(testPlayer.getx(), testPlayer.gety()));
				System.out.print(" ("+testPlayer.getx()+", "+testPlayer.gety()+") | ");
				
				//setting position of map pointer based on player position on right edge 
				testMngr.setPositionImmediately(testPlayer.getx(),testPlayer.gety());
				System.out.print(testMngr.getType(testPlayer.getx(), testPlayer.gety()));
				if(i == testMngr.getNumCols()-1)
					System.out.println(" ("+testPlayer.getx()+", "+testPlayer.gety()+") : End of top row");
				else
					System.out.println(" ("+testPlayer.getx()+", "+testPlayer.gety()+") || ");

				//checking if current player tile is blocked
				assertTrue(testMngr.getType(testPlayer.getx(), testPlayer.gety()) == Tile.BLOCKED 
						&& testMngr.getx() == testPlayer.getx() && testMngr.gety() == testPlayer.gety());
				assertTrue(testMngr.getType(testMngr.getx(), testMngr.gety()) == Tile.BLOCKED 
						&& testMngr.getx() == testPlayer.getx() && testMngr.gety() == testPlayer.gety());
			}
		}
	}
}
