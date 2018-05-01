package test;

import static org.junit.Assert.*;

import java.awt.Robot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.glass.events.KeyEvent;

import main.com.neet.DiamondHunter.Entity.Player;
import main.com.neet.DiamondHunter.GameState.GameState;
import main.com.neet.DiamondHunter.GameState.PlayState;
import main.com.neet.DiamondHunter.Main.Game;

public class TimerTest {
	Robot robot;
	long sysStartTime;
	long sysEndTime;
	long duration;
	int gameTime;

	@Before
	public void setUp() throws Exception {
		robot = null;
		try {
			robot = new Robot(); //Robot will automate key presses for testing purposes
			robot.setAutoDelay(175); //Wait 175 ms until key press
		}
		catch(Exception e) {
			System.out.println("ahhh you made me ink...");
		}
		new Thread(new Runnable() { //Create new game thread
			public void run() {
				Game.main(null);
			}
		}).run();
		
		robot.keyPress(KeyEvent.VK_ENTER); //skips intro
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000); //Delay 3 seconds
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER); //Launch game
		Thread.sleep(2000);
		sysStartTime = System.nanoTime();
		Thread.sleep(10000); //Wait 10 seconds
		robot.keyPress(KeyEvent.VK_ESCAPE); //Pause
		sysEndTime = System.nanoTime();	
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		gameTime = Math.round((Game.gp.gsm.playState.player.getTicks() / 30) % 60); //Get current game time
		duration = (sysEndTime - sysStartTime)/1000000000; //Record times
		System.out.println("SystemTime: " + duration);
		System.out.println("GameTime: " + gameTime);
		//Repeat
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		sysStartTime = System.nanoTime();		
		Thread.sleep(10000);
//		sysEndTime = System.nanoTime();
//		System.out.println("SystemTime: " + duration);
		gameTime = Math.round((Game.gp.gsm.playState.player.getTicks() / 30) % 60); //Get current game time
		sysEndTime = System.nanoTime();
		duration = duration + ((sysEndTime - sysStartTime)/1000000000);
		System.out.println("SystemTime: " + duration);
		System.out.println("GameTime: " + gameTime);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(duration == gameTime);
	}

}
