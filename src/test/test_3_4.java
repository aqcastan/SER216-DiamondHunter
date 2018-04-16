package test;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;

import main.com.neet.DiamondHunter.Main.Game;
import main.com.neet.DiamondHunter.Main.GamePanel;

public class test_3_4 {
    
    Robot robot = null;
    GamePanel gp;

    @Before
    public void setUp() throws Exception {
                
        try {
            robot = new Robot();
            robot.setAutoDelay(175); //175 for normal game speed
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        
        new Thread(new Runnable() {
            public void run() {
                Game.main(null);
            }

        }).run();
    }

    @Test
    public void PlayStateTest() {
        try {
            System.out.println("Launched game");
            Thread.sleep(7000);
            System.out.println("In Main Menu");
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                
            }
            
            System.out.println("\nTesting inputs");
            
            try{
                Thread.sleep(2000);
            } catch(Exception e) {
                
            }
            
            gp = Game.getGamePanel();
            
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
            
            assertTrue(gp.getGameStateManager().getCurrentState() == 1);
            assertTrue(gp.getGameStateManager().getMenuState().getCurrentOption() == 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void keyPress(int keyPress) {
        robot.keyPress(keyPress);
        robot.keyRelease(keyPress);
        System.out.println(keyPress);    
        assertTrue(gp.getGameStateManager().getMenuState().getCurrentOption() == 0);
    }
}