// The GameStateManager does exactly what its
// name says. It contains a list of GameStates.
// It decides which GameState to update() and
// draw() and handles switching between different
// GameStates.

package main.com.neet.DiamondHunter.Manager;

import java.awt.Graphics2D;

import main.com.neet.DiamondHunter.Entity.Player;
import main.com.neet.DiamondHunter.GameState.GameOverState;
import main.com.neet.DiamondHunter.GameState.GameState;
import main.com.neet.DiamondHunter.GameState.IntroState;
import main.com.neet.DiamondHunter.GameState.MenuState;
import main.com.neet.DiamondHunter.GameState.PauseState;
import main.com.neet.DiamondHunter.GameState.PlayState;


public class GameStateManager {
	
	private boolean paused;
	private PauseState pauseState;
	private Player player;
    private MenuState menuState;
	
	private GameState[] gameStates;
	private int currentState;
	private int previousState;
	private int levelState;
	
	public static final int NUM_STATES = 4;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int PLAY = 2;
	public static final int GAMEOVER = 3;
	private static int LEVEL;
	
	
	public GameStateManager() {
		
		JukeBox.init();
		
		
		paused = false;
		pauseState = new PauseState(this);
		
		gameStates = new GameState[NUM_STATES];
		setState(INTRO);
		
	}
	public void setLevel(int i) {
			LEVEL = i;
	}
	public int getLevel() {
		return LEVEL;
	}
	
	public void setState(int i) {
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
		if(i == INTRO) {
			gameStates[i] = new IntroState(this);
			gameStates[i].init();
		}
		else if(i == MENU) {
		    menuState = new MenuState(this);
            gameStates[i] = menuState;
            gameStates[i].init();
            menuState = (MenuState) gameStates[i];
            System.out.println("bleh");
		}
		else if(i == PLAY) {
		    PlayState state = new PlayState(this);
            gameStates[i] = state;
            gameStates[i].init();
            player = state.getPlayer();
		}
		else if(i == GAMEOVER) {
			gameStates[i] = new GameOverState(this);
			gameStates[i].init();
		}
	}
	
	public void unloadState(int i) {
		gameStates[i] = null;
	}
	
	public void setPaused(boolean b) {
		paused = b;
	}
	
	public void update() {
		if(paused) {
			pauseState.update();
		}
		else if(gameStates[currentState] != null) {
			gameStates[currentState].update();
		}
	}
	
	public void draw(Graphics2D g) {
		if(paused) {
			pauseState.draw(g);
		}
		else if(gameStates[currentState] != null) {
			gameStates[currentState].draw(g);
		}
	}
	
	public int getCurrentState() {return currentState;}
	public Player getPlayer() {return player;}
	public boolean getPaused() {return paused;}
	public MenuState getMenuState() {return menuState;}
}