
package cs1302.fxgame;

import com.michaelcotterell.game.Game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	Stage intro = new Stage();
    	BorderPane bp = new BorderPane();
    	bp.setStyle("-fx-background-color: black;");
    	Text gameIntro = new Text("BREAKOUT");
    	String gameIntroString = new String ("BREAKOUT");
    	Button startGame = new Button("Press to Start");
    	startGame.setStyle("-fx-background-color: transparent;");
    	gameIntro.setFont(Font.font("Arial", 100));
    	gameIntro.setFill(Color.YELLOWGREEN);
    	startGame.setFont(Font.font("Arial", 25));
    	startGame.setTextFill(Color.YELLOWGREEN);
    	bp.setCenter(gameIntro);
    	bp.setBottom(startGame);

    	BorderPane.setAlignment(startGame, Pos.CENTER);

    	Scene introScene = new Scene(bp, 640, 480);
    	intro.setScene(introScene);
    	intro.setResizable(false);
    	
    	//from http://www.java2s.com/Code/Java/JavaFX/Texttypingeffect.htm
    	final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(4000));
            }
            	protected void interpolate(double frac) {
                final int length = gameIntroString.length();
                final int n = Math.round(length * (float) frac);
                gameIntro.setText(gameIntroString.substring(0, n));
            }
        };
        
        animation.play();
        
    	intro.show();
    	
    	TestGame game = new TestGame(primaryStage);
        primaryStage.setTitle(game.getTitle());
        primaryStage.setScene(game.getScene());
        primaryStage.setResizable(false);
        startGame.setOnAction(e -> {
        	 intro.close();
        	 primaryStage.show();
             game.run();
        });


    } // start
    
    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver

