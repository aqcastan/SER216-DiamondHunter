package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import main.com.neet.DiamondHunter.Main.Game;
import main.com.neet.DiamondHunter.Main.GamePanel;

public class test_3_6 {
    
    Robot robot = null;
    Stack<Character> moves;
    int moveNum, currentX, currentY, originalX, originalY;
    GamePanel gp;

    @Before
    public void setUp() throws Exception {
        
        moves = new Stack<Character>();
        moveNum = 0;
        
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
    
    private void down(int times, boolean rollback) {
        if (times == 0) return;
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        System.out.print("down ");
        if (!rollback) {
            moves.push(new Character('u'));
            moveNum++;
            System.out.print(moveNum + " ");
        }
        down(--times, false);
    }
    
    private void up(int times, boolean rollback) {
        if (times == 0) return;
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
        System.out.print("up ");
        if (!rollback) {
            moves.push(new Character('d'));
            moveNum++;
            System.out.print(moveNum + " ");
        }
        up(--times, false);
    }
    
    private void left(int times, boolean rollback) {
        if (times == 0) return;
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_LEFT);
        System.out.print("left ");
        if (!rollback) {
            moves.push(new Character('r'));
            moveNum++;
            System.out.print(moveNum + " ");
        }
        left(--times, false);
    }
    
    private void right(int times, boolean rollback) {
        if (times == 0) return;
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        System.out.print("right ");
        if (!rollback) {
            moves.push(new Character('l'));
            moveNum++;
            System.out.print(moveNum + " ");
        }
        right(--times, false);
    }
    
    private void space() {
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        System.out.print("space ");
    }
    
    private void panelPause(boolean rollback) {
        try {
            Thread.sleep(1000);
            if (!rollback) {
                char prevMove = moves.pop();
                moves.push(new Character('p'));
                moves.push(prevMove);
                moveNum++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void rollBackMoves(int i) {
        while (moveNum > i) {
            char move = moves.pop().charValue();
            moveNum--;
            System.out.print(moveNum + " ");
            if (move == 'd') down(1, true);
            if (move == 'u') up(1, true);
            if (move == 'r') right(1, true);
            if (move == 'l') left(1, true);
            if (move == 'p') panelPause(true); 
        }
    }

}