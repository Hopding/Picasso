package com.ajd1.picasso;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameOverMenu {
	Stage stage;
	Scene gameOverScene;
	
	/**
	 * Constructor
	 * 
	 * @param primaryStage (required) stage to be transformed into GameOverMenu
	 */
	public GameOverMenu(Stage primaryStage) {
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});
		Group root = new Group();
		stage = primaryStage;
		gameOverScene = new Scene(root, 500, 300);
		root.getChildren().add(new Button());
		
		Rectangle background = new Rectangle(gameOverScene.getWidth(), gameOverScene.getHeight());
		background.setFill(Color.BLACK);
		root.getChildren().add(background);
			
		Label gameOverMessage = new Label("Game Over");
		gameOverMessage.setTextFill(Color.RED);
		gameOverMessage.setFont(new Font("Arial", 40));
		gameOverMessage.setTranslateX(145);
		gameOverMessage.setTranslateY(50);
		root.getChildren().add(gameOverMessage);
			
		//Create start game button
		Button mainMenuBut = new Button("RETURN TO MAIN MENU");
		mainMenuBut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				 Stage newWindow = new Stage(); 
				 newWindow.setTitle("PICASSO");
				 newWindow.show();
				new MainMenu(newWindow).display();
				stage.close();
			}
		});
		mainMenuBut.setTranslateX(180);
		mainMenuBut.setTranslateY(135);
		root.getChildren().add(mainMenuBut);
	}
	
	/**
	 * Display GameOverMenu on stage.
	 */
	public void display() {
			stage.setScene(gameOverScene);
			stage.centerOnScreen();
	}
}
