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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StageCompleteMenu {
	Stage stage;
	Scene stageCompleteScene;
	
	/**
	 * Constructor.
	 * 
	 * @param primaryStage (required) stage to be transformed into StageCompleteMenu
	 */
	public StageCompleteMenu(Stage primaryStage) {
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});
		Group root = new Group();
		stage = primaryStage;
		stageCompleteScene = new Scene(root, 500, 300);
		root.getChildren().add(new Button());
		
		//Create gradient background
		Rectangle colors = new Rectangle(stageCompleteScene.getWidth(), stageCompleteScene.getHeight(),
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
			colors.widthProperty().bind(stageCompleteScene.widthProperty());
			colors.heightProperty().bind(stageCompleteScene.heightProperty());
			colors.setOpacity(1);
			root.getChildren().add(colors);
	
			
			Label stageCompleteMessage = new Label("Stage Complete!");
			stageCompleteMessage.setTextFill(Color.WHITE);
			stageCompleteMessage.setFont(new Font("Arial", 40));
			stageCompleteMessage.setTranslateX(110);
			stageCompleteMessage.setTranslateY(50);
			root.getChildren().add(stageCompleteMessage);
			
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
	 * Display StageCompleteMenu on stage
	 */
	public void displayStageCompleteMenu() {
			stage.setScene(stageCompleteScene);
			stage.centerOnScreen();
	}
}
