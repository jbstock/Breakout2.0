package cs1302.fxgame;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle{
<<<<<<< HEAD

	private double paddleSpeed = 4;
	
=======
	private double paddleSpeed = 4;
>>>>>>> master
	public Paddle (double width, double height, Paint fill){
		super(width, height, fill);
		this.relocate(320-width/2 , 438);
	}//Paddle
<<<<<<< HEAD
	
=======

>>>>>>> master
	public double getPaddleSpeed(){
		return paddleSpeed;
	}
	public void increasePaddleSpeed(){
		paddleSpeed += 0.5;
	}
}//Paddle
