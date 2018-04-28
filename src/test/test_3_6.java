package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.junit.Before;
import org.junit.Test;

import main.com.neet.DiamondHunter.Main.Game;
import main.com.neet.DiamondHunter.Main.GamePanel;

public class test_3_6 {
    
    Robot robot = null;
    int currentX, currentY, originalX, originalY;
    GamePanel gp;
    Thread thread;

    @Before
    public void setUp() throws Exception {
        
        try {
            robot = new Robot();
            robot.setAutoDelay(175); //175 for normal game speed
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        
        thread = new Thread(new Runnable() {
            public void run() {
                Game.main(null);
            }

        });
        
        thread.run();
    }

    @Test
    public void PlayStateTestNonMovementKeys() {
        try {
            System.out.println("Launched game");
            Thread.sleep(7000);
            System.out.println("In Main Menu");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("Started game");
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                
            }
            
            gp = Game.getGamePanel();
            originalX = gp.getGameStateManager().getPlayer().getx();
            originalY = gp.getGameStateManager().getPlayer().gety();
            
            System.out.println(originalX);
            System.out.println(originalY);
            
            
            System.out.println("\nTesting inputs");
            
            try{
                Thread.sleep(2000);
            } catch(Exception e) {
                
            }
            
            for (int i = 65; i <= 90; i++) keyPress(i);     //Tests all letter keys
            for (int i = 48; i <= 47; i++) keyPress(i);     //Tests all number keys     
            keyPress(KeyEvent.VK_BACK_QUOTE);
            keyPress(KeyEvent.VK_MINUS);
            keyPress(KeyEvent.VK_EQUALS);
            keyPress(KeyEvent.VK_BACK_SLASH);
            keyPress(KeyEvent.VK_SEMICOLON);
            keyPress(KeyEvent.VK_QUOTE);
            keyPress(KeyEvent.VK_COMMA);
            keyPress(KeyEvent.VK_PERIOD);
            keyPress(KeyEvent.VK_SLASH);
            
            
            currentX = gp.getGameStateManager().getPlayer().getx();
            currentY = gp.getGameStateManager().getPlayer().gety();
            
            System.out.println(currentX);
            System.out.println(currentY);
            
            
            assertTrue(gp.getGameStateManager().getCurrentState() == 2);
            assertTrue(originalX == currentX);
            assertTrue(originalY == currentY);
            
            Game.disposePanel();
            thread = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void keyPress(int keyPress) {
        robot.keyPress(keyPress);
        robot.keyRelease(keyPress);
        System.out.println(keyPress);
        assertTrue(gp.getGameStateManager().getPlayer().getx() == originalX);
        assertTrue(gp.getGameStateManager().getPlayer().gety() == originalY);
        
    }
}