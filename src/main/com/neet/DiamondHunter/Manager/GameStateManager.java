// The GameStateManager does exactly what its
// name says. It contains a list of GameStates.
// It decides which GameState to update() and
// draw() and handles switching between different
// GameStates.

package main.com.neet.DiamondHunter.Manager;

import java.awt.Graphics2D;

import main.com.neet.DiamondHunter.GameState.GameOverState;
import main.com.neet.DiamondHunter.GameState.GameState;
import main.com.neet.DiamondHunter.GameState.IntroState;
import main.com.neet.DiamondHunter.GameState.MenuState;
import main.com.neet.DiamondHunter.GameState.PauseState;
import main.com.neet.DiamondHunter.GameState.PlayState;


public class GameStateManager {
	
	private boolean paused;
	private PauseState pauseState;
	public static PlayState playState;
	private GameState[] gameStates;
	private int currentState;
	private int previousState;
	private static int players = 1;
	private boolean multiPlayer = false;
	private long[] ticks = new long[2];

	public boolean isMultiPlayer() {
		return multiPlayer;
	}
	public void setMultiPlayer(boolean multiPlayer) {
		this.multiPlayer = multiPlayer;
	}
	public static final int NUM_STATES = 4;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int PLAY = 2;
	public static final int GAMEOVER = 3;
	
	public GameStateManager() {
		
		JukeBox.init();
		
		paused = false;
		pauseState = new PauseState(this);
		
		gameStates = new GameState[NUM_STATES];
		setState(INTRO);
		
	}
	public int getPlayers() {
		return players;
	}
	public void setPlayers(int num) {
		this.players = num;
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
			gameStates[i] = new MenuState(this);
			gameStates[i].init();
		}
		else if(i == PLAY) {
			if (isMultiPlayer()) {
				playState = new PlayState(this, true);
			}
			else { 
				playState = new PlayState(this, false);
			}
			gameStates[i] = playState;
			gameStates[i].init();
		}
		else if(i == GAMEOVER) {
			if (isMultiPlayer()) {
				if (players == 1) {
					players++;
					ticks[0] = Data.getTime();
					gameStates[i] = new PlayState(this, true);
					gameStates[i].init();
				}
				else {
					ticks[1] = Data.getTime();
					gameStates[i] = new GameOverState(this, ticks);
					gameStates[i].init();
				}
			}
			else {
				gameStates[i] = new GameOverState(this);
				gameStates[i].init();
			}
		}
	}
	public GameState getState() {
		return gameStates[currentState];
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
	
}
