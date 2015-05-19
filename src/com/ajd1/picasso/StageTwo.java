package com.ajd1.picasso;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StageTwo extends GameLoop {
	Rectangle background;

	public StageTwo(Stage primaryStage) {
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
		new LifeRestorer(componentsGroup, 1040, 510);
		
		//Adding Platforms
		new Platform(componentsGroup, 275, scene.getHeight() - 40, 100, 10, Color.BLACK);
		new Platform(componentsGroup, 350, scene.getHeight() - 80, 75, 10, Color.BLACK);
		new Platform(componentsGroup, 550, scene.getHeight() - 40, 100, 10, Color.BLACK);
		new Platform(componentsGroup, 500, scene.getHeight() - 80, 75, 10, Color.BLACK);
		new Platform(componentsGroup, scene.getWidth() - 100, scene.getHeight() - 75, 100, 10, Color.BLACK);
		new Platform(componentsGroup, scene.getWidth() - 100, scene.getHeight() - 150, 100, 10, Color.BLACK);
		new Platform(componentsGroup, scene.getWidth() - 100, scene.getHeight() - 225, 100, 10, Color.BLACK);
		new Platform(componentsGroup, scene.getWidth() - 100, scene.getHeight() - 300, 100, 10, Color.BLACK);
		new Platform(componentsGroup, 0, scene.getHeight() - 300, scene.getWidth() - 200, 10, Color.BLACK);
		new Platform(componentsGroup, 0, scene.getHeight() - 450, 400, 10, Color.BLACK);
		new Platform(componentsGroup, scene.getWidth() - 100, scene.getHeight() - 535, 100, 10, Color.BLACK);
		
		//Adding HorizontalMovingPlatforms
		new HorizontalMovingPlatform(componentsGroup, 0, scene.getHeight() - 375, scene.getWidth() - 400, Duration.millis(5000), 100, 10, Color.ORANGE);
		new HorizontalMovingPlatform(componentsGroup, 0, scene.getHeight() - 535, scene.getWidth() - 250, Duration.millis(4000), 100, 10, Color.ORANGE);

		//Adding RollingEnemies
		new RollingEnemy(componentsGroup, 25, scene.getHeight() - 300, scene.getWidth() - 250, Duration.millis(4000), Color.RED);
		new RollingEnemy(componentsGroup, 25, scene.getHeight() - 450, 350, Duration.millis(3000), Color.RED);
		
		//Adding Enemies
		new Enemy(componentsGroup, 457.5, 625, Color.PURPLE, true);
		new Enemy(componentsGroup, 457.5, 675, Color.PINK, true);
		new Enemy(componentsGroup, 950, 220, Color.GREEN, true);
		new Enemy(componentsGroup, 900, 220, Color.GRAY, true);
		new Enemy(componentsGroup, 850, 220, Color.BROWN, true);
		
		//Adding EndOfStagePoint
		endPoint = new EndOfStagePoint(componentsGroup, scene.getWidth() - 50, scene.getHeight() - 575);
		
		//Adding main character block
		mainChar = new MainCharacter(componentsGroup, background.getWidth(), background.getHeight(), 2);
		mainChar.reposition(0, scene.getHeight() - 40);
		
		//Adding HealthHUD
		hHUD = new HealthHUD(root, mainChar.getLives());
	}
}
