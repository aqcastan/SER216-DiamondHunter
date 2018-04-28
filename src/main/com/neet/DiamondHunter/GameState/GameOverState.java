// Congratulations for finishing the game.
// Gives you a rank based on how long it took
// you to beat the game.

// Under two minutes = Speed Demon
// Under three minutes = Adventurer
// Under four minutes = Beginner
// Four minutes or greater = Bumbling Idiot

package main.com.neet.DiamondHunter.GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import main.com.neet.DiamondHunter.Main.GamePanel;
import main.com.neet.DiamondHunter.Manager.Content;
import main.com.neet.DiamondHunter.Manager.Data;
import main.com.neet.DiamondHunter.Manager.GameStateManager;
import main.com.neet.DiamondHunter.Manager.JukeBox;
import main.com.neet.DiamondHunter.Manager.Keys;

public class GameOverState extends GameState {
	
	private Color color;
	
	private int rank;
	private long ticks;
	private long[] playerTimes;
	
	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	public GameOverState(GameStateManager gsm, long[] playTimes) {
		super(gsm);
		playerTimes = playTimes;
	}
	
	public void init() {
		if (!gsm.isMultiPlayer()) {
			color = new Color(164, 198, 222);
			if(ticks < 3600) rank = 1;
			else if(ticks < 5400) rank = 2;
			else if(ticks < 7200) rank = 3;
			else rank = 4;
		}
		else {
			color = new Color(164, 198, 222);
		}
	}
	
	public void update() {}
	
	public void draw(Graphics2D g) {
		if (gsm.isMultiPlayer()) {
			g.setColor(color);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
			int y = 3;
			for (int i = 0; i <= 1; i++) {
				int minutes = (int) (playerTimes[i] / 1800);
				int seconds = (int) ((playerTimes[i] / 30) % 60);
				if(minutes < 10) {
					if(seconds < 10) {
						Content.drawString(g, "Player " + (i+1) + ": " + "0" + minutes + ":0" + (seconds - 1), 3, y);
					}
					else {
						Content.drawString(g, "Player " + (i+1) + ": " + "0" + minutes + ":" + (seconds - 1), 3, y);
					}
				}
				y += 10;
			}
			if (playerTimes[0] < playerTimes[1]) {
				Content.drawString(g, "Player 1 wins", 9, 50);
			}
			else if (playerTimes[0] > playerTimes[1]) {
				Content.drawString(g, "Player 2 wins", 9, 50);
			}
			else {
				Content.drawString(g, "Its a tie", 9, 50);
			}
			Content.drawString(g, "press any key", 9, 110);
		}
		else {
			g.setColor(color);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
			
			Content.drawString(g, "finish time", 20, 36);
			
			int minutes = (int) (ticks / 1800);
			int seconds = (int) ((ticks / 30) % 60);
			if(minutes < 10) {
				if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 44, 48);
				else Content.drawString(g, "0" + minutes + ":" + seconds, 44, 48);
			}
			else {
				if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 44, 48);
				else Content.drawString(g, minutes + ":" + seconds, 44, 48);
			}
			
			Content.drawString(g, "rank", 48, 66);
			if(rank == 1) Content.drawString(g, "speed demon", 20, 78);
			else if(rank == 2) Content.drawString(g, "adventurer", 24, 78);
			else if(rank == 3) Content.drawString(g, "beginner", 32, 78);
			else if(rank == 4) Content.drawString(g, "bumbling idiot", 8, 78);
			
			Content.drawString(g, "press any key", 12, 110);
		}
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) {
			gsm.setState(GameStateManager.MENU);
			JukeBox.play("collect");
		}
	}
	
}