package game;

import java.awt.Color;
import java.util.Random;

import hsa2.GraphicsConsole;

public class Enemy {
	int x,y;
	int size = 50;
	int buffer_width = 800;
	int mull = 1;
	
	Random rand = new Random();
	
	GraphicsConsole gc;
	
	Enemy(GraphicsConsole gc, int height, int mull){
		this.x = gc.getDrawWidth() / 2;
		this.y = height;
		this.gc = gc;
		this.mull = mull;
	}
	
	public void draw() {
		
		// Draw guns
		this.gc.setColor(Color.gray);
		this.gc.fillRect(this.x - 16, this.y + this.size - 20, 4, 10);
		this.gc.fillRect(this.x + 12, this.y + this.size - 20, 4, 10);
				
		// Draw ship
		this.gc.setColor(Color.green);
		int[] x_points = {this.x - (this.size/2),  this.x,  this.x + (this.size/2)};
		int[] y_points = {this.y, this.y + this.size, this.y};
		this.gc.fillPolygon(x_points, y_points, 3);
		
		// Draw tail fin
		this.gc.setColor(Color.red);
		this.gc.fillRect(this.x - 2, this.y + 10, 4, 10);	
		
		
	}
	
	public boolean update(int line_of_fire) {
		if ((line_of_fire - this.size / 2) <= this.x && this.x <= (line_of_fire + this.size / 2)) {
			return true;
		}else {
			// x += random -5 - 5
//			if(this.x <= gc.getDrawWidth() - this.buffer_width / 2) {
////				this.x += rand.nextInt(10);
//				this.mull = -1;
////				this.x += 10;
//			} else if(this.x >= this.buffer_width / 2) {
////				this.x += rand.nextInt(10) - 20;
//				this.mull = 1;
////				this.x -= 10;
//			} //else {
//				this.x += 5 * this.mull; //rand.nextInt(20) - 10;
//			}
			
			if (this.x <= 55) {
				this.mull = 1;
			}
			if (this.x >= this.gc.getDrawWidth() - 55) {
				this.mull = -1;
			}
			
			this.x += 5 * this.mull;
			
			return false;
		}
	}

}
