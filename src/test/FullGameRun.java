package test;

import main.com.neet.DiamondHunter.Main.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FullGameRun {
    
    Robot robot = null;
    Stack<Character> moves;
    int moveNum;

    @Before
    public void setUp() throws Exception {
        
        moves = new Stack<Character>();
        moveNum = 0;
        
        try {
            robot = new Robot();
            robot.setAutoDelay(175); //150 for normal game speed
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
    public void fullGameRuneTest() {
        try {
            System.out.println("Launched game");
            Thread.sleep(7000);
            System.out.println("In Main Menu");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("Started game");
            Thread.sleep(2000);
            down(3, false);right(3, false);down(4, false);panelPause(false);//Gets first diamond, go to next screen with diamond
            System.out.println();     
            left(1, false);down(5, false);right(2, false);down(1, false);right(3, false);//panelPause(false);   //Gets second diamond, go to next screen with diamond
            System.out.println();
            right(4, false);up(5, false);right(2, false);up(2, false);panelPause(false); //Gets third diamond, go to next screen with diamond
            System.out.println();
            up(1, false);left(5, false);up(3, false);right(2, false);down(1, false);right(3, false);up(2, false);left(1, false);up(3, false);//panelPause(false);
            System.out.println();
            up(2, false);right(7, false);up(1, false);down(4, false);//panelPause(false);
            System.out.println();
            down(8, false);//panelPause(false);
            System.out.println();
            down(2, false);right(1, false);//panelPause(false);System.out.println("Got axe");
            rollBackMoves(44);
            down(1, false);up(1, false);space();up(2, false);right(2, false);up(2, false); panelPause(false);
            System.out.println();
            up(1, false);left(2, false);panelPause(false);
            System.out.println();
            rollBackMoves(0);
            System.out.println();
            left(1, false);right(1, false);left(1, false);space();left(2, false);panelPause(false);
            System.out.println();
            left(2, false);
            System.out.println();
            rollBackMoves(1);
            System.out.println();
            down(4, false);panelPause(false);panelPause(false);
            System.out.println();
            down(5, false);left(2, false);down(3, false);panelPause(false);
            System.out.println();
            down(1, false);left(2, false);panelPause(false);
            System.out.println();
            left(1, false);down(1, false); left(3, false); down(1, false); space(); down(2, false); left(4, false);panelPause(false);
            System.out.println();
            left(3, false);up(6, false);panelPause(false);
            System.out.println();
            up(3, false);right(4, false);panelPause(false);
            System.out.println();
            right(1, false);up(2, false);right(2, false);up(1, false);space();up(2, false);panelPause(false);
            System.out.println();
            up(2, false);left(2, false);up(1, false);left(2, false);panelPause(false);
            System.out.println();
            left(5, false);up(2, false);right(2, false);down(1, false);up(1, false);space();up(3, false);panelPause(false);
            System.out.println();
            up(3, false);right(4, false);panelPause(false);
            System.out.println();
            right(6, false);up(3, false);left(2, false);up(2, false);
            System.out.println();
            up(3, false);left(5, false);panelPause(false);
            System.out.println();
            left(4, false);right(5, false);panelPause(false);
            System.out.println();
            right(4, false);down(4, false);panelPause(false);
            System.out.println();
            down(5, false);right(4, false);panelPause(false);
            System.out.println();
            right(4, false);left(1, false);up(6, false);panelPause(false);
            System.out.println();
            up(3, false);right(5, false);panelPause(false);
            System.out.println();
            right(8, false);panelPause(false);
            System.out.println();
            right(2, false);panelPause(false);
            System.out.println();
            left(3, false);panelPause(false);
            System.out.println("\nQ");
            left(4, false);down(4, false);panelPause(false);
            System.out.println("\nR");
            left(4, false);down(3, false);right(1, false);down(2, false);panelPause(false);
            System.out.println("\nS");
            down(1, false);left(2, false);down(4, false);right(5, false);down(2, false);panelPause(false);
            System.out.println("\nT");
            down(4, false);left(5, false);down(2, false);left(2, false);panelPause(false);
            System.out.println("\nU");
            left(2, false);down(2, false);panelPause(false);
            System.out.println("\nV");
            down(3, false);right(5, false);left(5, false);up(4, false);panelPause(false);
            System.out.println("\nW");
            up(1, false);right(3, false); panelPause(false);
            System.out.println("\nX");
            right(4, false);up(2, false);right(4, false);panelPause(false);
            System.out.println("\nY");
            right(2, false);down(1, false);right(2, false);down(3, false);panelPause(false);
            System.out.println("\nZ");
            down(6, false);
            
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            Thread.sleep(000);
            if (!rollback) moves.push(new Character('p'));
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
