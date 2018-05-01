package test;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.com.neet.DiamondHunter.Main.Game;
import main.com.neet.DiamondHunter.Main.GamePanel;

public class test_2_2 {
    
    Robot robot = null;
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
    
    @After
    public void tearDown() throws Exception {
        gp = null;
    }

    @Test
    public void MovePauseTest() {
        try {
            System.out.println("Launched game");
            Thread.sleep(7000);
            System.out.println("In Main Menu");
            
            
            
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("Started game");
            
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                
            }
            
            
            gp = Game.getGamePanel();
            assertTrue(gp.getGameStateManager().getPlayer().getx() == 280);
            assertTrue(gp.getGameStateManager().getPlayer().gety() == 280);
            
            //Moves player, checks coordinates
            System.out.println("Moving right\n");
            keyPress(KeyEvent.VK_RIGHT);
            assertTrue(gp.getGameStateManager().getPlayer().getx() == 296);
            assertTrue(gp.getGameStateManager().getPlayer().gety() == 280);
            
            System.out.println("Moving down\n");
            keyPress(KeyEvent.VK_DOWN);
            assertTrue(gp.getGameStateManager().getPlayer().getx() == 296);
            assertTrue(gp.getGameStateManager().getPlayer().gety() == 296);
            
            System.out.println("Moving left\n");
            keyPress(KeyEvent.VK_LEFT);
            assertTrue(gp.getGameStateManager().getPlayer().getx() == 280);
            assertTrue(gp.getGameStateManager().getPlayer().gety() == 296); 
            
            System.out.println("Moving up\n");
            keyPress(KeyEvent.VK_UP);
            assertTrue(gp.getGameStateManager().getPlayer().getx() == 280);
            assertTrue(gp.getGameStateManager().getPlayer().gety() == 280);
            
            try{
                Thread.sleep(2000);
            } catch(Exception e) {
                
            }            
            
            System.out.println("Pausing");
            keyPress(KeyEvent.VK_ESCAPE);
            
            assertTrue(gp.getGameStateManager().getCurrentState() == 2);
            assertTrue(gp.getGameStateManager().getPaused());
            
            Game.disposePanel();
            thread = null;
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void keyPress(int keyPress) {
        robot.keyPress(keyPress);
        robot.keyRelease(keyPress);
    }
}