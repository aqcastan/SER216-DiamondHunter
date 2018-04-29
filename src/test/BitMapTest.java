package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.com.neet.DiamondHunter.TileMap.Tile;
import main.com.neet.DiamondHunter.TileMap.TileMap;

public class BitMapTest {
	TileMap testMngr = new TileMap(16);
	
	@Test
	public void test() {
		//testMngr.loadTiles("Resources/Tilesets/testtileset.gif");
		testMngr.loadMap("C:\\Users\\Me\\Documents\\College\\ASU\\SER\\SER 216\\Project\\SER216-DiamondHunter\\Resources\\Maps\\testmap.map");
		for(int i = 0; i < testMngr.getNumRows(); i++) {
			if(i == 0 || i == testMngr.getNumRows()-1) {
				for(int j = 0; j < testMngr.getNumCols(); j++) {
					testMngr.setPositionImmediately(i, j);
					System.out.println("("+testMngr.getx()+", "+testMngr.gety()+")");
					assertTrue(testMngr.getType(i, j) == Tile.BLOCKED);
				}
			}
			else {
				testMngr.setPositionImmediately(i, 0);
				System.out.println("("+testMngr.getx()+", "+testMngr.gety()+")");
				testMngr.setPositionImmediately(i, testMngr.getNumCols()-1);
				System.out.println("("+testMngr.getx()+", "+testMngr.gety()+")");
				assertTrue(testMngr.getType(i,0) == Tile.BLOCKED);
				assertTrue(testMngr.getType(i,testMngr.getNumCols()-1) == Tile.BLOCKED);
			}
		}
	}

}
