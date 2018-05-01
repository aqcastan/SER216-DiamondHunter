// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package main.com.neet.DiamondHunter.Main;

import javax.swing.JFrame;

public class Game {
	
    public static GamePanel gp = null;
    static JFrame window;
    
	public static void main(String[] args) {
		
		window = new JFrame("Diamond Hunter");
		
		gp = new GamePanel();

		window.add(gp);
		
		window.setResizable(false);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public static GamePanel getGamePanel() {return gp;}
	public static void disposePanel() {window.dispose();}
	
}
