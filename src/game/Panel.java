package game;

import java.awt.Color;

import hsa2.GraphicsConsole;

public class Panel {
	GraphicsConsole gc;
	
	boolean left_button, right_button, shoot = false;
	
	Panel(GraphicsConsole gc){
		this.gc = gc;
	}
	
	public void draw() {
		gc.setColor(Color.darkGray);
		gc.fillRect(0, gc.getDrawHeight() - 200, gc.getDrawWidth(), 200);
		
		gc.setColor(new Color(255,0,50));
		gc.fillRect(0, gc.getDrawHeight() - 200, gc.getDrawWidth(), 10);
		
		gc.setColor(new Color(80, 240, 100));
		gc.fillRect(200, gc.getDrawHeight() - 180, 300, 170);
		
		gc.setColor(new Color(255,0,50));
		gc.fillRect(160, gc.getDrawHeight() - 170, 30, 20);
		gc.fillRect(160, gc.getDrawHeight() - 110, 30, 20);
		
		gc.setColor(Color.gray);
		int[] x_left_button_bg = {gc.getDrawWidth() - 310, gc.getDrawWidth() - 160, gc.getDrawWidth() - 160};
		int[] y_left_button_bg = {gc.getDrawHeight() - 100, gc.getDrawHeight() - 10, gc.getDrawHeight() - 180};
		gc.fillPolygon(x_left_button_bg, y_left_button_bg, 3);
		
		int[] x_right_button_bg = {gc.getDrawWidth() - 10, gc.getDrawWidth() - 150, gc.getDrawWidth() - 150};
		int[] y_right_button_bg = {gc.getDrawHeight() - 100, gc.getDrawHeight() - 10, gc.getDrawHeight() - 180};
		gc.fillPolygon(x_right_button_bg, y_right_button_bg, 3);
		
		gc.fillRect(gc.getDrawWidth() - 500, gc.getDrawHeight() - 180, 170, 170);
		
		gc.setColor(Color.yellow);
		if(this.left_button) {
			int[] x_left_button = {gc.getDrawWidth() - 310, gc.getDrawWidth() - 160, gc.getDrawWidth() - 160};
			int[] y_left_button = {gc.getDrawHeight() - 100, gc.getDrawHeight() - 10, gc.getDrawHeight() - 180};
			gc.fillPolygon(x_left_button, y_left_button, 3);
		}
		
		if(this.right_button) {
			int[] x_right_button = {gc.getDrawWidth() - 10, gc.getDrawWidth() - 150, gc.getDrawWidth() - 150};
			int[] y_right_button = {gc.getDrawHeight() - 100, gc.getDrawHeight() - 10, gc.getDrawHeight() - 180};
			gc.fillPolygon(x_right_button, y_right_button, 3);
		}
		
		if (this.shoot) {
			gc.fillRect(gc.getDrawWidth() - 490, gc.getDrawHeight() - 170, 150, 150);
		}
		
		this.left_button = false;
		this.right_button = false;
		this.shoot = false;
	}
	
	public void update(int key) {
		if (key == 37 ) {
			this.left_button = true;
		}
		if (key == 39 ) {
			this.right_button = true;
		}
		if (key == 32) {
			this.shoot = true;
		}
	}

}
