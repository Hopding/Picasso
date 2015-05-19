package com.ajd1.picasso;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StageOne extends GameLoop {
	Rectangle background;

	public StageOne(Stage primaryStage) {
		super(primaryStage, false);
		super.stageWidth = 1100;
		super.stageHeight = 700;
	}
	
	public void initBackground() {
		//Adding background
		background = new Rectangle(scene.getWidth(), scene.getHeight());
		background.setFill(new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
		         Stop[]{
	            new Stop(0, Color.web("#f8bd55")),
	            new Stop(0.14, Color.web("#c0fe56")),
	            new Stop(0.28, Color.web("#5dfbc1")),
	            new Stop(0.43, Color.web("#64c2f8")),
	            new Stop(0.57, Color.web("#be4af7")),
	            new Stop(0.71, Color.web("#ed5fc2")),
	            new Stop(0.85, Color.web("#ef504c")),
	            new Stop(1, Color.web("#f2660f")),}));
		background.widthProperty().bind(scene.widthProperty());
		background.heightProperty().bind(scene.heightProperty());
		componentsGroup.getChildren().add(background);
	}

	@Override
	public void initStage() {
		//Adding LifeRestorers
		new LifeRestorer(componentsGroup, 125, 515);
		
		//Adding platforms
		new Platform(componentsGroup, scene.getWidth()/2 + 100, scene.getHeight() - 75, 200);
		new Platform(componentsGroup, scene.getWidth()/2 - 300, scene.getHeight() - 75, 200);
		new Platform(componentsGroup, 50, scene.getHeight() - 150, 100);
		new Platform(componentsGroup, scene.getWidth() - 150, scene.getHeight() - 150, 100);
		new Platform(componentsGroup, 0, scene.getHeight() - 240, scene.getWidth(), 20, Color.GREENYELLOW);
		new Platform(componentsGroup, scene.getWidth()/2 - 100, scene.getHeight() - 400, 200, 10, Color.ORANGE);
		
		//Adding horizontally moving platforms
		new HorizontalMovingPlatform(componentsGroup, 0, scene.getHeight() - 325, scene.getWidth(), Duration.millis(10000), 150);
		
		//Adding enemies
		new Enemy(componentsGroup, scene.getWidth()/2 - 350, scene.getHeight(), Color.BLUE, true);
		new Enemy(componentsGroup, scene.getWidth()/2 + 350, scene.getHeight(), Color.PURPLE, true);
		
		//Adding EndOfStagePoint
		endPoint = new EndOfStagePoint(componentsGroup, scene.getWidth()/2, scene.getHeight() - 450);
		
		//Adding main character block
		mainChar = new MainCharacter(componentsGroup, background.getWidth(), background.getHeight(), 1);
		mainChar.reposition(scene.getWidth()/2 - 20, scene.getHeight() - 40);
		
		//Adding HealthHUD
		hHUD = new HealthHUD(root, mainChar.getLives());
	}
}
