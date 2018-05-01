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

public class test_3_7 {
    
    Robot robot = null;
    Stack<Character> moves;
    int moveNum;
    Thread thread;

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
        
        thread = new Thread(new Runnable() {
            public void run() {
                Game.main(null);
            }

        });
        
        thread.run();
    }

    @Test
    public void GameOverStateTest() {
        try {
            System.out.println("Launched game");
            Thread.sleep(7000);
            System.out.println("In Main Menu");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("Started game");
            long start = System.nanoTime();
            Thread.sleep(2000);
            down(3, false);right(3, false);down(4, false);panelPause(false);//Gets first diamond, go to next screen with diamond
            System.out.println("\nA");     
            left(1, false);down(5, false);right(2, false);down(1, false);right(3, false);panelPause(false);   //Gets second diamond, go to next screen with diamond
            System.out.println("\nB");
            right(4, false);up(5, false);right(2, false);up(2, false);panelPause(false); //Gets third diamond, go to next screen with diamond
            System.out.println("\nC");
            up(1, false);left(5, false);up(3, false);right(2, false);down(1, false);right(3, false);up(2, false);left(1, false);up(3, false);panelPause(false);
            System.out.println("\nD");
            up(2, false);right(3, false);panelPause(false);
            System.out.println("\nD.A");
            right(4, false);up(1, false);down(4, false);panelPause(false);
            System.out.println("\nE");
            down(8, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            down(2, false);right(1, false);panelPause(false);System.out.println("Got axe");
            rollBackMoves(47);panelPause(false);
            down(1, false);up(1, false);space();up(2, false);right(2, false);up(2, false); panelPause(false);
            System.out.println(System.nanoTime() - start);
            up(1, false);left(2, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            rollBackMoves(9);panelPause(false);
            System.out.println(System.nanoTime() - start);
            up(3, false);left(3, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            left(1, false);right(1, false);left(1, false);space();left(2, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            left(2, false);right(2, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            right(3, false);down(4, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            down(5, false);left(2, false);down(3, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            down(1, false);left(2, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            left(1, false);down(1, false); left(3, false); down(1, false); space(); down(2, false); left(4, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            left(3, false);up(6, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            up(3, false);right(4, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            right(1, false);up(2, false);right(2, false);up(1, false);space();up(2, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            up(2, false);left(2, false);up(1, false);left(2, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            left(5, false);up(2, false);right(2, false);down(1, false);up(1, false);space();up(3, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            up(3, false);right(4, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            right(6, false);up(3, false);left(2, false);up(2, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            up(3, false);left(5, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            left(4, false);right(5, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            right(4, false);down(4, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            down(5, false);right(4, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            right(4, false);left(1, false);up(6, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            up(3, false);right(5, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            right(8, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            right(2, false);panelPause(false);
            System.out.println(System.nanoTime() - start);
            left(3, false);panelPause(false);
            System.out.println("\nQ");
            left(4, false);down(4, false);panelPause(false);
            System.out.println("\nR");
            down(3, false);left(1, false);down(3, false);right(1, false);down(2, false);panelPause(false);
            System.out.println();
            down(1, false);left(2, false);down(5, false);right(5, false);down(2, false);panelPause(false);
            System.out.println();
            down(4, false);left(4, false);down(2, false);left(3, false);panelPause(false);
            System.out.println();
            left(2, false);down(2, false);panelPause(false);
            System.out.println();
            down(1, false);right(3, false);panelPause(false);
            System.out.println();
            right(2, false);down(2, false);left(3, false);panelPause(false);
            System.out.println();
            left(2, false);up(4, false);panelPause(false);
            System.out.println();
            up(1, false);right(3, false);panelPause(false);
            System.out.println();
            right(4, false);up(2, false);right(4, false);panelPause(false);
            System.out.println();
            right(1, false);down(1, false);right(3, false);down(3, false);panelPause(false);
            System.out.println();
            down(6, false);panelPause(false);
            
            System.out.println("\nTesting all inputs except \"Enter\"");
            
            try{
                Thread.sleep(2000);
            } catch(Exception e) {
                
            }
            
            for (int i = 65; i <= 90; i++) keyPress(i);     //Tests all letter keys
            for (int i = 48; i <= 47; i++) keyPress(i);     //Tests all number keys     
            for (int i = 37; i <= 40; i++) keyPress(i);     //Tests arrow keys
            keyPress(KeyEvent.VK_BACK_QUOTE);
            keyPress(KeyEvent.VK_MINUS);
            keyPress(KeyEvent.VK_EQUALS);
            keyPress(KeyEvent.VK_BACK_SLASH);
            keyPress(KeyEvent.VK_SEMICOLON);
            keyPress(KeyEvent.VK_QUOTE);
            keyPress(KeyEvent.VK_COMMA);
            keyPress(KeyEvent.VK_PERIOD);
            keyPress(KeyEvent.VK_SLASH);
            
            
            GamePanel gp = Game.getGamePanel();
            assertTrue(gp.getGameStateManager().getCurrentState() == 3);
            
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