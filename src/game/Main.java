package game;

import java.awt.Color;

import hsa2.GraphicsConsole;

public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	/*
	 * game_state
	 * 0 = Loading
	 * 1 = Start screen
	 * 2 = Game
	 * 3 = Game end
	 */
	int game_state = 0;
	
	// Main graphicsconsole
	GraphicsConsole gc = new GraphicsConsole(1360, 900);
	
	// Game screens
	LoadingScreen loading = new LoadingScreen(gc);
	Background bg = new Background(gc);
	Panel controls = new Panel(gc);
	Player player = new Player(gc);
	
	Enemy enemy1 = new Enemy(gc, 230, 1);
	Enemy enemy2 = new Enemy(gc, 330, -1);
	
	int kills = 0;
	
	Main(){
		// Configure window
		gc.setLocationRelativeTo(null);
		gc.setAntiAlias(true);
		gc.enableMouse();
		
		// Set up the loading screen
		loading.init();
		
		// Loading screen loop
		while(loading.tick()) {
			gc.sleep(1);
		}
		
		// Main game loop
		gc.setBackgroundColor(Color.black);
		gc.clear();
		while (true) {
			synchronized (gc) {
				int key = gc.getKeyCode();
				gc.clear();
				bg.show();
				controls.update(key);
				controls.draw();
				player.update(key);
				player.draw();
				
				int lazerpoint = 0;
				if(player.cooldown >= 80) {
					lazerpoint = player.x;
				}
				
				if(enemy1.update(lazerpoint)) {
					System.out.println("Hit the target!");
					this.kills += 1;
				}
				enemy1.draw();
				
				if(enemy2.update(lazerpoint)) {
					System.out.println("Hit the target!");
					this.kills += 1;
				}
				enemy2.draw();
				
				// Draw kill count
				gc.setColor(Color.black);
				gc.drawString("Kills: " + this.kills, 210, gc.getDrawHeight() - 160);
				
				
			}
			gc.sleep(3);
		}
		
	}

}
