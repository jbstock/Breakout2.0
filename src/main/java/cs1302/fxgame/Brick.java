package cs1302.fxgame;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Brick extends Rectangle {

	int lives;
	
	public Brick (Paint fill, double xloc, double yloc){
		//60x40 is default size
		super(60, 40, fill);
		this.lives = 3;
		this.relocate(xloc, yloc);
	}//Brick
	
	/**
	 * Changes color and "lives" of brick
	 */
	public void subtractLife() {
		lives--;
		if (lives == 2)
			this.setFill(Color.YELLOW);
		if (lives == 1)
			this.setFill(Color.ORANGERED);
		if (lives == 0)
			this.setFill(Color.TRANSPARENT);
	}//subtractLife
	
	
	public void resetLives(){
		lives = 3;
		this.setFill(Color.LIGHTBLUE);
	}
	
	public int getLives() {
		return lives;
	}
}//Brick
