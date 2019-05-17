package game;

import java.awt.Color;

import hsa2.GraphicsConsole;

public class LoadingScreen {
	// Main graphicsconsole
	GraphicsConsole gc;
	
	// loading ticker
	int ticker = 0;
	int width = 480;
	
	LoadingScreen(GraphicsConsole gc){
		this.gc = gc;
	}
	
	public void init() {
		this.gc.setBackgroundColor(new Color(150,255,200));
		this.gc.clear();
		
		// Draw loading bar bg
		this.gc.setColor(Color.gray);
		this.gc.fillRect((this.gc.getDrawWidth() / 2) - (this.width / 2), (this.gc.getDrawHeight() / 2) + 100, this.width, 40);
	}
	
	public boolean tick() {
		this.ticker += 1;
		
		// Draw Rect
		this.gc.setColor(Color.blue);
		this.gc.fillRect((this.gc.getDrawWidth() / 2) - (this.width / 2), (this.gc.getDrawHeight() / 2) + 100, this.ticker, 40);
		
		return (this.ticker <= this.width);
	}
}
