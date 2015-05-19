package com.ajd1.picasso;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Enemy {
	//Field members to make up Enemy
	protected Polygon pointySquareOne;
	protected Polygon pointySquareTwo;
	
	//Field member to make up Enemy field
	//and Color
	protected Circle enemyField;
	protected Color enemyColor;
	
	//Field members for Enemy's RotateTransitions
	protected RotateTransition rTOne;
	protected RotateTransition rTTwo;
	
	//Static ArrayList for all Enemies to add themselves to
	protected static ArrayList enemiesArray = new ArrayList<Enemy>();
	
	/**
	 * Constructor. 
	 *
	 * @param componentsGroup (required) defines group to which Enemy will be added
	 * @param xCoord (required) defines x coordinate of Enemy
	 * @param yCoord (required) defines y coordinate of Enemy
	 * @param color (required) defines color of Enemy
	 * @param spinOrNot (required) defines whether or not Enemy will spin - default is no spin 
	 */
	public Enemy(Group componentsGroup, double xCoord, double yCoord, Color color, boolean spinOrNot) {
		this(componentsGroup, xCoord, yCoord, color);
		
		//add this enemy to passed ArrayList
		enemiesArray.add(0, this);
		
		//If Enemy is set to spin, add both RotationTransition to a ParallelTransition
		//and begin ParallelTransition
		if (spinOrNot) {
			ParallelTransition pt = new ParallelTransition();
			pt.getChildren().addAll(rTOne, rTTwo);
			pt.setCycleCount(Animation.INDEFINITE);
			pt.play();
		}
 	}
	
	/**
	 * Constructor. 
	 *
	 * @param componentsGroup (required) defines group to which Enemy will be added
	 * @param xCoord (required) defines x coordinate of Enemy
	 * @param yCoord (required) defines y coordinate of Enemy
	 * @param color (required) defines color of Enemy
	 */
	public Enemy(Group componentsGroup, double xCoord, double yCoord, Color color) {
		//Set enemyColor field to passed in value
		enemyColor = color;
		
		//set up enemy's field
		enemyField = new Circle(7, 7, 10);
		enemyField.setFill(Color.PINK);
		enemyField.setOpacity(0.0);
		enemyField.setTranslateX(xCoord);
		enemyField.setTranslateY(yCoord - 27);
		enemyField.setScaleX(1.6);
		enemyField.setScaleY(1.6);
		
		//set up first pointy square
		pointySquareOne = new Polygon();
		pointySquareOne.getPoints().addAll(new Double[]{6.0, 2.0, 7.0, 0.0, 8.0, 2.0, 
											  12.0, 6.0, 14.0, 7.0, 12.0, 8.0, 
											  8.0, 12.0, 7.0, 14.0, 6.0, 12.0, 
											  2.0, 8.0, 0.0, 7.0, 2.0, 6.0});
		pointySquareOne.setTranslateX(xCoord);
		pointySquareOne.setTranslateY(yCoord - 27);
		pointySquareOne.setScaleX(3);
		pointySquareOne.setScaleY(3);
		pointySquareOne.setRotate(45);
		pointySquareOne.setFill(color);
		pointySquareOne.setRotate(65);
		
		//set up rotation transition for first square
		rTOne = new RotateTransition(Duration.millis(2500), pointySquareOne);
		rTOne.setByAngle(360);
		rTOne.setCycleCount(Animation.INDEFINITE);
		rTOne.setAutoReverse(false);
	
		//set up second pointy square
		pointySquareTwo = new Polygon();
		pointySquareTwo.getPoints().addAll(new Double[]{6.0, 2.0, 7.0, 0.0, 8.0, 2.0, 
											  12.0, 6.0, 14.0, 7.0, 12.0, 8.0, 
											  8.0, 12.0, 7.0, 14.0, 6.0, 12.0, 
											  2.0, 8.0, 0.0, 7.0, 2.0, 6.0});
		pointySquareTwo.setTranslateX(xCoord);
		pointySquareTwo.setTranslateY(yCoord - 27);
		pointySquareTwo.setScaleX(3);
		pointySquareTwo.setScaleY(3);
		pointySquareTwo.setFill(color);
		pointySquareTwo.setRotate(20);
		
		//set up rotation transition for second square
		rTTwo = new RotateTransition(Duration.millis(2500), pointySquareTwo);
		rTTwo.setByAngle(-360);
		rTTwo.setCycleCount(Animation.INDEFINITE);
		rTTwo.setAutoReverse(false);
		
		//add first square, second square, and enemy field to 
		//root of passed in scene
		componentsGroup.getChildren().add(pointySquareOne);
		componentsGroup.getChildren().add(pointySquareTwo);
		componentsGroup.getChildren().add(enemyField);
 	}
	
	/**
	 * Get the Bounds of Enemy
	 *@return the bounds of the enemy
	 */
	public Bounds getBounds() {
		return enemyField.getBoundsInParent();
	}
	
	/**
	 * Get color of the Enemy
	 * @return the enemy's color
	 */
	public Color getColor() {
		return enemyColor;
	}
	
	/**
	 * Get an ArrayList containing all instances of Enemy.
	 * @return return an ArrayList containing all instances of Enemy
	 */
	public static ArrayList<Enemy> getEnemiesArrayList() {
		return enemiesArray;
	}
	
	/**
	 * Must be called before creating a new stage!
	 */
	public static void reset() {
		enemiesArray.clear();
	}
}
