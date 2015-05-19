package com.ajd1.picasso;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StageFour extends GameLoop {

	public StageFour(Stage primaryStage) {
		super(primaryStage, true);
		super.stageWidth = 3300;
		super.stageHeight = 700;
	}

	@Override
	public void initStage() {
		//Adding Obstacles
		//3
		new Obstacle(componentsGroup, 0, 480, 320, 40);
		//4
		new Obstacle(componentsGroup, 280, 480, 40, 120);
		//5
		new Obstacle(componentsGroup, 320, 480, 760, 40);
		//6
		new Obstacle(componentsGroup, 1080, 620, 80, 80);
		//7
		new Obstacle(componentsGroup, 1120, 580, 80, 40);
		//8
		new Obstacle(componentsGroup, 1160, 540, 80, 40);
		//9
		new Obstacle(componentsGroup, 1200, 500, 160, 40);
		//10
		new Obstacle(componentsGroup, 80, 280, 40, 140);
		//11
		new Obstacle(componentsGroup, 80, 240, 160, 40);
		
		//13
		new Obstacle(componentsGroup, 200, 280, 40, 40);
		//15
		new Obstacle(componentsGroup, 320, 240, 40, 80);
		//17
		new Obstacle(componentsGroup, 440, 240, 40, 80);
		//14
		new Obstacle(componentsGroup, 200, 320, 280, 40);
		
		//21
		new Obstacle(componentsGroup, 1360, 240, 40, 300);
		//22
		new Obstacle(componentsGroup, 1400, 360, 600, 40);
		//23
		new Obstacle(componentsGroup, 2040, 280, 40, 360);
		//24
		new Obstacle(componentsGroup, 1440, 520, 600, 40);
		//25
		new Obstacle(componentsGroup, 2160, 640, 40, 60);
		//26
		new Obstacle(componentsGroup, 2640, 640, 40, 60);
		//27
		new Obstacle(componentsGroup, 2080, 560, 840, 40);
		//28
		new Obstacle(componentsGroup, 2400, 600, 40, 60);
		//29
		new Obstacle(componentsGroup, 5880, 600, 40, 60);
		//30
		new Obstacle(componentsGroup, 2960, 660, 40, 40);
		//31
		new Obstacle(componentsGroup, 3000, 620, 40, 80);
		//32
		new Obstacle(componentsGroup, 3040, 580, 40, 120);
		//33
		new Obstacle(componentsGroup, 3080, 540, 40, 160);
		//34
		new Obstacle(componentsGroup, 3120, 500, 40, 200);
		//35
		new Obstacle(componentsGroup, 3160, 460, 40, 240);
		//36
		new Obstacle(componentsGroup, 3200, 420, 120, 280);
		//69
		new Obstacle(componentsGroup, 1440, 560, 40, 80);
		//70
		new Obstacle(componentsGroup, 1520, 600, 40, 80);
		//71
		new Obstacle(componentsGroup, 1600, 600, 40, 80);
		//72
		new Obstacle(componentsGroup, 1360, 680, 240, 20);
		//73
		new Obstacle(componentsGroup, 1680, 560, 40, 80);
		//74
		new Obstacle(componentsGroup, 1720, 600, 120, 40);
		//75
		new Obstacle(componentsGroup, 1600, 680, 320, 20);
		//76
		new Obstacle(componentsGroup, 1880, 600, 40, 80);
		//77
		new Obstacle(componentsGroup, 1960, 560, 40, 100);
		
		//Adding Platforms
		//2
		new Platform(componentsGroup, 80, 605, 100);
		//12
		new Platform(componentsGroup, 0, 390, 80);
		//16
		new Platform(componentsGroup, 0, 300, 80);
		//18
		new Platform(componentsGroup, 665, 240, 40);
		//19
		new Platform(componentsGroup, 890, 240, 40);

		
		//Adding HorizontalMovingPlatforms
		//20
		new HorizontalMovingPlatform(componentsGroup, 1080, 240, 1240, Duration.millis(5000), 60);
		//Adding LifeRestorers
		//83
		new LifeRestorer(componentsGroup, 1260, 460);
		//84
		new LifeRestorer(componentsGroup, 1260, 660);		
		//Adding Enemys
		//40
		new Enemy(componentsGroup, 440, 600, Color.BLUE, true);
		//41
		new Enemy(componentsGroup, 800, 600, Color.BLUE, true);
		//42
		new Enemy(componentsGroup, 800, 480, Color.BLUE, true);
		//43
		new Enemy(componentsGroup, 400, 480, Color.BLUE, true);
		//45
		new Enemy(componentsGroup, 275, 290, Color.BLUE, true);
		//46
		new Enemy(componentsGroup, 395, 290, Color.BLUE, true);
		//47
		new Enemy(componentsGroup, 500, 290, Color.BLUE, false);
		//48
		new Enemy(componentsGroup, 570, 290, Color.BLUE, false);
		//49
		new Enemy(componentsGroup, 640, 290, Color.BLUE, false);
		//50
		new Enemy(componentsGroup, 720, 290, Color.BLUE, false);
		//51
		new Enemy(componentsGroup, 800, 290, Color.BLUE, false);
		//52
		new Enemy(componentsGroup, 880, 290, Color.BLUE, false);
		//53
		new Enemy(componentsGroup, 960, 290, Color.BLUE, false);
		//54
		new Enemy(componentsGroup, 1040, 290, Color.BLUE, false);
		//55
		new Enemy(componentsGroup, 1120, 290, Color.BLUE, false);
		//56
		new Enemy(componentsGroup, 1200, 290, Color.BLUE, false);
		//57
		new Enemy(componentsGroup, 1280, 290, Color.BLUE, false);
		//62
		new Enemy(componentsGroup, 1920, 520, Color.BLUE, true);
		//63
		new Enemy(componentsGroup, 1840, 440, Color.BLUE, true);
		//64
		new Enemy(componentsGroup, 1760, 520, Color.BLUE, true);
		//65
		new Enemy(componentsGroup, 1680, 440, Color.BLUE, true);
		//66
		new Enemy(componentsGroup, 1600, 520, Color.BLUE, true);
		//67
		new Enemy(componentsGroup, 1520, 440, Color.BLUE, true);
		//78
		new Enemy(componentsGroup, 2095, 640, Color.BLUE, true);
		//79
		new Enemy(componentsGroup, 2255, 640, Color.BLUE, true);
		//80
		new Enemy(componentsGroup, 2575, 640, Color.BLUE, true);
		//81
		new Enemy(componentsGroup, 2735, 640, Color.BLUE, true);
		//82
		new Enemy(componentsGroup, 1573, 680, Color.BLUE, true);
		
		//Adding RollingEnemys
		//38
		new RollingEnemy(componentsGroup, 320, 700, 560, Duration.millis(4000), Color.RED);
		//39
		new RollingEnemy(componentsGroup, 680, 700, 1000, Duration.millis(4000), Color.RED);
		//44
		new RollingEnemy(componentsGroup, 200, 480, 880, Duration.millis(4000), Color.RED);
		//58
		new RollingEnemy(componentsGroup, 1440, 360, 1600, Duration.millis(4000), Color.RED);
		//59
		new RollingEnemy(componentsGroup, 1560, 360, 1720, Duration.millis(4000), Color.RED);
		//60
		new RollingEnemy(componentsGroup, 1680, 360, 1840, Duration.millis(4000), Color.RED);
		//61
		new RollingEnemy(componentsGroup, 1800, 360, 1960, Duration.millis(4000), Color.RED);
		
		//Adding EndOfStagePoint
		//37
		endPoint = new EndOfStagePoint(componentsGroup, 3260, 300);
		
		//Adding MainCharacter
		mainChar = new MainCharacter(componentsGroup, 3300, 700, 3);
		mainChar.reposition(100, 560);
		
		//Adding HealthHUD
		hHUD = new HealthHUD(root, mainChar.getLives());
	}

	@Override
	public void initBackground() {
		background = new Rectangle(3300, 700, Color.TAN);
		componentsGroup.getChildren().add(background);
	}
	

}
