package com.ajd1.picasso;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StageThree extends GameLoop {

	public StageThree(Stage primaryStage) {
		super(primaryStage, true);
		super.stageWidth = 2200;
		super.stageHeight = 700;
	}

	@Override
	public void initStage() {
		//Adding LifeRestorers
		new LifeRestorer(componentsGroup, 50, 650);
		new LifeRestorer(componentsGroup, 1670, 270);
		
		//Adding Platforms
		new Platform(componentsGroup, -50, scene.getHeight() - 100, 200, 10, Color.BLACK);
		new Platform(componentsGroup, 290, 600, 120, 10, Color.BLACK);
		new Platform(componentsGroup, 585, 600, 150, 10, Color.BLACK);
		new Platform(componentsGroup, 885, 600, 100, 10, Color.BLACK);
		new Platform(componentsGroup, 1050, 525, 50, 10, Color.BLACK);
		new Platform(componentsGroup, 950, 450, 50, 10, Color.BLACK);
		new Platform(componentsGroup, 850, 375, 50, 10, Color.BLACK);
		new Platform(componentsGroup, -30, 225, 1130, 10, Color.BLACK);
		new Platform(componentsGroup, 1350, 325, 50, 10, Color.BLACK);
		new Platform(componentsGroup, 1550, 450, 65, 10, Color.BLACK);
		new Platform(componentsGroup, 1650, 300, 50, 10, Color.BLACK);
		new Platform(componentsGroup, 1450, 225, 100, 10, Color.BLACK);
		new Platform(componentsGroup, 1450, 150, 500, 10, Color.BLACK);
		new Platform(componentsGroup, 2050, 125, 100, 10, Color.BLACK);
		new Platform(componentsGroup, 125, 650, 50, 10, Color.BLACK);
		
		//Adding HorizontalMovingPlatforms
		new HorizontalMovingPlatform(componentsGroup, 0, 300, 750, Duration.millis(3000), 50, 10, Color.ORANGERED);
		new HorizontalMovingPlatform(componentsGroup, 1750, 525, 2100, Duration.millis(2000), 50, 10, Color.ORANGERED);
		new HorizontalMovingPlatform(componentsGroup, 1850, 450, 2200, Duration.millis(2500), 50, 10, Color.ORANGERED);
		new HorizontalMovingPlatform(componentsGroup, 1750, 375, 2100, Duration.millis(2000), 50, 10, Color.ORANGERED);
		
		//Adding Enemies
		new Enemy(componentsGroup, 200, 225, Color.PURPLE, true);
		new Enemy(componentsGroup, 400, 225, Color.PURPLE, true);
		new Enemy(componentsGroup, 600, 225, Color.PURPLE, true);
		new Enemy(componentsGroup, 800, 225, Color.PURPLE, true);
		new Enemy(componentsGroup, 2050, 450, Color.PURPLE, true);
		
		//Adding RollingEnemies
		new RollingEnemy(componentsGroup, 0, scene.getHeight(), 2200, Duration.millis(2000), Color.RED);
		
		//Adding endPoint
		endPoint = new EndOfStagePoint(componentsGroup, 2100, 75);
		
		//Adding mainChar
		mainChar = new MainCharacter(componentsGroup, 2200, 700, 1);
		mainChar.reposition(25, scene.getHeight() - 140);
		
		//Adding HealthHUD
		hHUD = new HealthHUD(root, mainChar.getLives());
	}

	@Override
	public void initBackground() {
		Circle background = new Circle();
		background.setRadius(1400);
		background.setTranslateX(1100);
		background.setTranslateY(350);
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
		componentsGroup.getChildren().add(background);
		RotateTransition rt = new RotateTransition(Duration.millis(10000), background);
		rt.setByAngle(360);
		rt.setAutoReverse(false);
		rt.setCycleCount(Animation.INDEFINITE);
		rt.play();
	}
}
