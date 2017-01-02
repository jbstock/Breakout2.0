package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestGame extends Game {
	
	int score = 0;
	public static int playerLives = 3;
	
	static Brick[][] bricks = new Brick[4][8];
	
	//bricks setup
	private void brickSetup() {
		double startX = 55.00;
		double startY = 50.00;
		double startY2 = 95.00;
		double startY3 = 140.00;
		double startY4 = 185.00;
		double XInterval = 65.00;
		
		//row 1
		Brick b1 = new Brick(Color.LIGHTBLUE, startX + XInterval*0, startY);
		Brick b2 = new Brick(Color.LIGHTBLUE, startX + XInterval*1, startY);
		Brick b3 = new Brick(Color.LIGHTBLUE, startX + XInterval*2, startY);
		Brick b4 = new Brick(Color.LIGHTBLUE, startX + XInterval*3, startY);
		Brick b5 = new Brick(Color.LIGHTBLUE, startX + XInterval*4, startY);
		Brick b6 = new Brick(Color.LIGHTBLUE, startX + XInterval*5, startY);
		Brick b7 = new Brick(Color.LIGHTBLUE, startX + XInterval*6, startY);
		Brick b8 = new Brick(Color.LIGHTBLUE, startX + XInterval*7, startY);
	
		//row 2
		Brick b9  = new Brick(Color.LIGHTBLUE, startX + XInterval*0, startY2);
		Brick b10 = new Brick(Color.LIGHTBLUE, startX + XInterval*1, startY2);
		Brick b11 = new Brick(Color.LIGHTBLUE, startX + XInterval*2, startY2);
		Brick b12 = new Brick(Color.LIGHTBLUE, startX + XInterval*3, startY2);
		Brick b13 = new Brick(Color.LIGHTBLUE, startX + XInterval*4, startY2);
		Brick b14 = new Brick(Color.LIGHTBLUE, startX + XInterval*5, startY2);
		Brick b15 = new Brick(Color.LIGHTBLUE, startX + XInterval*6, startY2);
		Brick b16 = new Brick(Color.LIGHTBLUE, startX + XInterval*7, startY2);
		
		//row 3
		Brick b17 = new Brick(Color.LIGHTBLUE, startX + XInterval*0, startY3);
		Brick b18 = new Brick(Color.LIGHTBLUE, startX + XInterval*1, startY3);
		Brick b19 = new Brick(Color.LIGHTBLUE, startX + XInterval*2, startY3);
		Brick b20 = new Brick(Color.LIGHTBLUE, startX + XInterval*3, startY3);
		Brick b21 = new Brick(Color.LIGHTBLUE, startX + XInterval*4, startY3);
		Brick b22 = new Brick(Color.LIGHTBLUE, startX + XInterval*5, startY3);
		Brick b23 = new Brick(Color.LIGHTBLUE, startX + XInterval*6, startY3);
		Brick b24 = new Brick(Color.LIGHTBLUE, startX + XInterval*7, startY3);
		
		//row 4
		Brick b25 = new Brick(Color.LIGHTBLUE, startX + XInterval*0, startY4);
		Brick b26 = new Brick(Color.LIGHTBLUE, startX + XInterval*1, startY4);
		Brick b27 = new Brick(Color.LIGHTBLUE, startX + XInterval*2, startY4);
		Brick b28 = new Brick(Color.LIGHTBLUE, startX + XInterval*3, startY4);
		Brick b29 = new Brick(Color.LIGHTBLUE, startX + XInterval*4, startY4);
		Brick b30 = new Brick(Color.LIGHTBLUE, startX + XInterval*5, startY4);
		Brick b31 = new Brick(Color.LIGHTBLUE, startX + XInterval*6, startY4);
		Brick b32 = new Brick(Color.LIGHTBLUE, startX + XInterval*7, startY4);
		
		//row1
		bricks[0][0] = b1; bricks[0][1] = b2; bricks[0][2] = b3; bricks[0][3] = b4; bricks[0][4] = b5; bricks[0][5] = b6; bricks[0][6] = b7; bricks[0][7] = b8;
		//row2
		bricks[1][0] = b9; bricks[1][1] = b10; bricks[1][2] = b11; bricks[1][3] = b12; bricks[1][4] = b13; bricks[1][5] = b14; bricks[1][6] = b15; bricks[1][7] = b16; 
		//row3
		bricks[2][0] = b17; bricks[2][1] = b18; bricks[2][2] = b19; bricks[2][3] = b20; bricks[2][4] = b21; bricks[2][5] = b22; bricks[2][6] = b23; bricks[2][7] = b24; 
		//row4
		bricks[3][0] = b25; bricks[3][1] = b26; bricks[3][2] = b27; bricks[3][3] = b28; bricks[3][4] = b29; bricks[3][5] = b30; bricks[3][6] = b31; bricks[3][7] = b32; 
	}
	
	private void checkCollision(){
		boolean vertCont = false;
		boolean horCont = false;
		for (int i = 0; i < bricks.length; i++)
		{
			for (int j = 0; j < bricks[i].length; j ++)
			{
				if (bricks[i][j] != null)
				{
					Bounds brickBounds = bricks[i][j].getBoundsInParent();
					Bounds ballBounds = ball.getBoundsInParent();
					double brickTop = brickBounds.getMinY();
					double brickBottom = brickBounds.getMaxY();
					double brickLeft = brickBounds.getMinX();
					double brickRight = brickBounds.getMaxX();
					if (brickBounds.intersects(ballBounds))
					{
						bricks[i][j].subtractLife();
						if (bricks[i][j].getLives() == 0)
						{
							bricks[i][j] = null;
							score++;


						}
						boolean dirChg = false;
						//Left brick collision
						if (ballBounds.getMaxX() >= brickLeft && ballBounds.getMinX() < brickLeft && dX > 0 && !vertCont)
						{
							dX*=-1;
							ball.setLayoutX(ball.getLayoutX() + dX/2);
							dirChg = true;
							vertCont = true;


						}
						//Right brick collision
						if (ballBounds.getMinX() <= brickRight && ballBounds.getMaxX() > brickRight && dX < 0 && !vertCont)
						{
							dX*=-1;
							ball.setLayoutX(ball.getLayoutX() + dX/2);
							dirChg = true;
							vertCont = true;

						}

						//Top & Bottom brick collisions
						if(!dirChg && !horCont) {
							dY*=-1;
							ball.setLayoutY(ball.getLayoutY() + dY/2);
							horCont = true;
						}

					}
				}
			}
		}
	}

	private boolean hasWon() {
		for (int i = 0; i < bricks.length; i++)
		{
			for (int j = 0; j < bricks[i].length; j++)
			{
				if (bricks[i][j] != null)
					return false;
			}
		}
		return true;
	}
	
	private void gameReset() {
		this.brickSetup();
		for (int i = 0; i < bricks.length; i++)
		{
			for (int j = 0; j < bricks[i].length; j++)
			{
				bricks[i][j].resetLives();
				this.getSceneNodes().getChildren().add(bricks[i][j]);
			}
		}
		ball.relocate(320-4, 410);
		ball.increaseSpeed();
		paddle.increasePaddleSpeed();
		if((int)(Math.random()*100) < 50)
			dX = ball.getSpeed() * -1;
		else
			dX = ball.getSpeed();
		dY = ball.getSpeed();
	}

	private void checkForGameOver() {
		
		if (playerLives == 0)
		{
			this.stop();
			stage.close();
			Stage exit = new Stage();
	    	BorderPane bp = new BorderPane();
	    	bp.setStyle("-fx-background-color: black;");
	    	Text gameOver = new Text("Game Over! Your Score: " + score);
	    	Button quit = new Button("Press to Quit");
	    	quit.setStyle("-fx-background-color: transparent;");
	    	gameOver.setFont(Font.font("Arial", 40));
	    	gameOver.setFill(Color.YELLOWGREEN);
	    	quit.setFont(Font.font("Arial", 25));
	    	quit.setTextFill(Color.YELLOWGREEN);
	    	bp.setCenter(gameOver);
	    	bp.setBottom(quit);
	    	
	    	BorderPane.setAlignment(quit, Pos.CENTER);

	    	Scene exitScene = new Scene(bp, 640, 480);
	    	exit.setScene(exitScene);
	    	exit.setResizable(false);
	    	exit.show();
	    	quit.setOnAction(e -> System.exit(0));
		}
	}
	
    // rectangle to hold the background
    private Rectangle bg = new Rectangle(0, 0, 640, 480) {{
         setFill(Color.BLACK); 
    }};

    //ball setup
    private Ball ball = new Ball(8, Color.WHITE){{
    	 setTranslateX(10);
         setTranslateY(20);
    }};
    
    //paddle setup
    private Paddle paddle = new Paddle(150, 20, Color.WHITE) {{
    	 setTranslateX(10);
         setTranslateY(20);
    }};
    
    //scoreDisplay setup
    private Text scoreDisplay = new Text() {{
    	setFill(Color.WHITE);
    	relocate(5,5);
    }};
    
    //livesDisplay setup
    private Text livesDisplay = new Text() {{
    	setFill(Color.WHITE);
    	relocate(585, 5);
    }};
    
    /**
     * Constructs a new test game.
     * @param stage the primary stage
     */
    public TestGame(Stage stage) {
        super(stage, "Breakout!", 60, 640, 480);
        this.brickSetup();
        getSceneNodes().getChildren().addAll(bg, ball, paddle, scoreDisplay, livesDisplay, 
        		bricks[0][0],bricks[0][1],bricks[0][2],bricks[0][3],bricks[0][4],bricks[0][5],bricks[0][6],bricks[0][7],
        		bricks[1][0],bricks[1][1],bricks[1][2],bricks[1][3],bricks[1][4],bricks[1][5],bricks[1][6],bricks[1][7],
        		bricks[2][0],bricks[2][1],bricks[2][2],bricks[2][3],bricks[2][4],bricks[2][5],bricks[2][6],bricks[2][7],
        		bricks[3][0],bricks[3][1],bricks[3][2],bricks[3][3],bricks[3][4],bricks[3][5],bricks[3][6],bricks[3][7]);
    } // TestGame

	private double dX = ball.getSpeed();
	private double dY = ball.getSpeed();


    @Override
    public void update(Game game, GameTime gameTime) {
        scoreDisplay.setText("Score: "+ score);
        livesDisplay.setText("Lives: " + playerLives);
        
<<<<<<< HEAD
        boolean paddleRight = false;
        boolean paddleLeft = false;
        
    	if (game.getKeyManager().isKeyPressed(KeyCode.LEFT) && paddle.getTranslateX() - paddle.getPaddleSpeed() >= -250){
            paddle.setTranslateX(paddle.getTranslateX() - paddle.getPaddleSpeed());
            paddleLeft = true;
        }
    	if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT) && paddle.getTranslateX() + paddle.getPaddleSpeed() <= 250){
            paddle.setTranslateX(paddle.getTranslateX() + paddle.getPaddleSpeed());
            paddleRight = true;
=======
    	if (game.getKeyManager().isKeyPressed(KeyCode.LEFT) && paddle.getTranslateX() - paddle.getPaddleSpeed() >= -250){
            paddle.setTranslateX(paddle.getTranslateX() - paddle.getPaddleSpeed());
        }
    	if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT) && paddle.getTranslateX() + paddle.getPaddleSpeed() <= 250){
            paddle.setTranslateX(paddle.getTranslateX() + paddle.getPaddleSpeed());
>>>>>>> master
        }

    	this.checkCollision();
    	if (hasWon())
		{
			gameReset();
		}
		this.checkForGameOver();
    	
		//Basic idea gotten from http://stackoverflow.com/questions/20022889/how-to-make-the-ball-bounce-off-the-walls-in-javafx

    	Bounds bounds = game.getSceneBounds();
		Bounds paddleBounds = paddle.getBoundsInLocal();
		Bounds ballBounds = ball.getBoundsInLocal();
		
	
		//Paddle Check
		boolean contactOnSides = false;
		boolean contactOnTop = false;
		if(paddleBounds.intersects(ballBounds)) {
			contactOnTop = ball.getBoundsInParent().getMaxY() >= (paddle.getBoundsInParent().getMinY()) && ball.getBoundsInParent().getMinX() + ball.getRadius() >= (paddle.getBoundsInParent().getMinX()) && ball.getBoundsInParent().getMaxX() - ball.getRadius() <= (paddle.getBoundsInParent().getMaxX());
		}
		else{
			contactOnSides = true;
		}

		//Sides Check
		boolean atRightBorder = ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius());
		boolean atLeftBorder = ball.getLayoutX() <= (bounds.getMinX() - ball.getRadius());
		boolean atBottomBorder = ball.getBoundsInParent().getMinY() >= paddle.getBoundsInParent().getMinY();
		boolean atTopBorder = ball.getLayoutY() <= (bounds.getMinY() - ball.getRadius());

		if (atRightBorder || atLeftBorder) dX *= -1;
		if (atTopBorder) dY *= -1;

		if(contactOnTop) {
			dY *= -1;
<<<<<<< HEAD
			if (paddleRight && dX < 0)
				dX *= -1;
			if (paddleLeft && dX > 0)
				dX *= -1;
=======
>>>>>>> master
			ball.setLayoutY(ball.getLayoutY() + dY/2);
		}
		if(contactOnSides) {
			dX *= -1;
			ball.setLayoutX(ball.getLayoutX() + dX/2);
		}
		//if(contactOnLeft || contactOnRight) dX *= -1;
		ball.setLayoutX(ball.getLayoutX() + dX);
		ball.setLayoutY(ball.getLayoutY() + dY);
		if(atBottomBorder) {
			playerLives -= 1;
			ball.relocate(320-4, 410);
			if((int)(Math.random()*100) < 50)
				dX = ball.getSpeed() * -1;
			paddle.setTranslateX(10);
			paddle.setTranslateX(20);


		}
		
	} // update

} // TestGame

