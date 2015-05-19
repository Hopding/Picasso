package com.ajd1.picasso;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu {
	Stage stage;
	Scene startMenu;
	
	/**
	 * Constructor.
	 * 
	 * @param primaryStage (required) stage to be transformed into MainMenu
	 */
	public MainMenu(Stage primaryStage) {
		primaryStage.setResizable(false);
		Group root = new Group();
		stage = primaryStage;
		startMenu = new Scene(root, 500, 300);
		root.getChildren().add(new Button());
		
		//Create gradient background
		Rectangle colors = new Rectangle(startMenu.getWidth(), startMenu.getHeight(),
			     new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
			         Stop[]{
			            new Stop(0, Color.web("#f8bd55")),
			            new Stop(0.14, Color.web("#c0fe56")),
			            new Stop(0.28, Color.web("#5dfbc1")),
			            new Stop(0.43, Color.web("#64c2f8")),
			            new Stop(0.57, Color.web("#be4af7")),
			            new Stop(0.71, Color.web("#ed5fc2")),
			            new Stop(0.85, Color.web("#ef504c")),
			            new Stop(1, Color.web("#f2660f")),}));
			colors.widthProperty().bind(startMenu.widthProperty());
			colors.heightProperty().bind(startMenu.heightProperty());
			root.getChildren().add(colors);
			
			//Create stage selection drop down
			ComboBox selectStage = new ComboBox();
			selectStage.getItems().addAll(
					"Stage 1",
					"Stage 2",
					"Stage 3",
					"Stage 4"
					);
			selectStage.setValue("Stage 1");
			selectStage.setTranslateX(217.5);
			selectStage.setTranslateY(50);
			root.getChildren().add(selectStage);
			
			//Create start game button
			Button startGame = new Button("PLAY PICASSO");
			startGame.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Enemy.reset();
					RollingEnemy.reset();
					Platform.reset();
					HorizontalMovingPlatform.reset();
					Obstacle.reset();
					LifeRestorer.reset();
					if(selectStage.getValue() == "Stage 1")
						new StageOne(stage).display();
					if(selectStage.getValue() == "Stage 2")
						new StageTwo(stage).display();
					if(selectStage.getValue() == "Stage 3")
						new StageThree(stage).display();
					if(selectStage.getValue() == "Stage 4")
						new StageFour(stage).display();
				}
			});
			startGame.setTranslateX(215);
			startGame.setTranslateY(135);
			root.getChildren().add(startGame);
	}

	/**
	 * Display MainMenu on stage.
	 */
	public void display() {
			stage.setScene(startMenu);
			stage.centerOnScreen();
	}
}
