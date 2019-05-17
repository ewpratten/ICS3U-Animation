package game;

import java.awt.Color;
import java.util.Random;

import hsa2.GraphicsConsole;

public class Background {
	GraphicsConsole gc;
	Random rand = new Random();
	
	public class Star{
		int x,y,size, ticker;
		Star(int x, int y, int size, int ticker){
			this.x = x;
			this.y = y;
			this.size = size;
			this.ticker = ticker;
		}
	}
	
	int star_count = 100;
	Star[] stars = new Star[star_count];
	
	Background(GraphicsConsole gc){
		this.gc = gc;
		for(int i = 0; i < star_count; i++) {
			stars[i] = new Star(rand.nextInt(gc.getDrawWidth()), rand.nextInt(gc.getDrawHeight()), rand.nextInt(3), rand.nextInt(1800));
//			stars[i].x = rand.nextInt(60) + (gc.getDrawWidth() / 2) - 30;
//			stars[i].y = rand.nextInt(60) + (gc.getDrawHeight() / 2) - 30;
//			stars[i].size = rand.nextInt(30);
		}
	}
	
	public void show() {
		for(int i = 0; i < this.stars.length; i++) {
			
			this.stars[i].ticker += 1;
			
			if (this.stars[i].ticker > 1800) {
				this.stars[i].x = rand.nextInt(gc.getDrawWidth());
				this.stars[i].y = rand.nextInt(gc.getDrawHeight());
				this.stars[i].size = rand.nextInt(3);
				this.stars[i].ticker = rand.nextInt(1800);
			}
			
			gc.setColor(Color.white);
			gc.fillOval(this.stars[i].x, this.stars[i].y, this.stars[i].size, this.stars[i].size);
		}
	}

}
