package game;

import java.awt.Color;

import hsa2.GraphicsConsole;

public class Player {
	public int x,y;
	int size = 50;
	int buffer_width = 800;
	boolean shoot = false;
	public int cooldown = 0;
	
	GraphicsConsole gc;
	
	Player(GraphicsConsole gc){
		this.x = gc.getDrawWidth() / 2;
		this.y = gc.getDrawHeight() - 230;
		this.gc = gc;
	}
	
	public void draw() {
		if ((this.shoot && this.cooldown <= 0) || this.cooldown >= 80) {
			this.gc.setColor(Color.red);
			this.gc.drawLine(this.x - 16, 0, this.x - 14, this.y);
			this.gc.drawLine(this.x + 12, 0, this.x + 14, this.y);
			this.shoot = false;
		}
		this.cooldown -= 1;
		
		// Draw guns
		this.gc.setColor(Color.gray);
		this.gc.fillRect(this.x - 16, this.y - this.size + 20, 4, 10);
		this.gc.fillRect(this.x + 12, this.y - this.size + 20, 4, 10);
				
		// Draw ship
		this.gc.setColor(Color.green);
		int[] x_points = {this.x - (this.size/2),  this.x,  this.x + (this.size/2)};
		int[] y_points = {this.y, this.y - this.size, this.y};
		this.gc.fillPolygon(x_points, y_points, 3);
		
		// Draw tail fin
		this.gc.setColor(Color.red);
		this.gc.fillRect(this.x - 2, this.y - 10, 4, 10);	
		
		
	}
	
	public void update(int key) {
		if (this.cooldown < 80) {
			if (key == 37 && this.x > (this.gc.getDrawWidth() - this.buffer_width) / 2) {
				this.x -= 10;
			}
			if (key == 39 && this.x < this.gc.getDrawWidth() - ((this.gc.getDrawWidth() - this.buffer_width) / 2)) {
				this.x += 10;
			}
		}
		
		if (this.gc.getKeyChar() == 32) {
			this.shoot = true;
			this.cooldown = 100;
		}
	}

}
