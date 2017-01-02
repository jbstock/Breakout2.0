package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.sun.javafx.geom.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle{
	
	private int speed;
	
	public Ball(int size, Color color){
		super(size, color);
		this.relocate(320-4, 410);
		this.speed = 3;
	}//Ball

	public int getSpeed(){
		return speed;
	}//getSpeed

	//for speed increases from level to level
	public void increaseSpeed(){
		this.speed += 1;
	}//increaseSpeed
	
}//Ball
