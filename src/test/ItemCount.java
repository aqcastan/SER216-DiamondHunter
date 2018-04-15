package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.com.neet.DiamondHunter.Entity.Item;
import main.com.neet.DiamondHunter.GameState.PlayState;
import main.com.neet.DiamondHunter.Main.GamePanel;
import main.com.neet.DiamondHunter.Manager.GameStateManager;

public class ItemCount {
	GamePanel gp;
	GameStateManager gsm;
	PlayState ps;
	int PLAYSTATE = 2;
	int diamonds = 15;
	int diamondCount = 0;
	int axeType = 1;
	int itemCount = 2;
	int boatType = 0;
	ArrayList<Item> items; 
	@Before
	public void setUp() throws Exception {
		gsm = new GameStateManager();
		gsm.setState(PLAYSTATE);
		ps = new PlayState(gsm);
		ps.init();
		diamondCount = ps.getDiamonds();
		items = ps.getItems();
	}

	@After
	public void tearDown() throws Exception {
		gsm = null;
		ps = null;
	}

	@Test
	public void test() {
		System.out.print("Testing.....");
		assertTrue(diamondCount == diamonds);
		assertTrue(items.size() == itemCount);
		assertTrue(items.get(0).getType() == axeType);
		assertTrue(items.get(1).getType() == boatType);
	}

}
