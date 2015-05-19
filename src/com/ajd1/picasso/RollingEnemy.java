package com.ajd1.picasso;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class RollingEnemy extends Enemy {
	//Field members for Transitions
	protected ParallelTransition pT;
	protected TranslateTransition tTOne;
	protected TranslateTransition tTTwo;
	protected TranslateTransition tTThree;
	
	//Static ArrayList to which all instances of RollingEnemy will add themselves
	protected static ArrayList rollingEnemies = new ArrayList<RollingEnemy>();

	/**
	 * Constructor.
	 * 
	 * @param componentsGroup (required) group to which RollingEnemy will be added
	 * @param xCoord (required) defines x coordinate of RollingEnemy
	 * @param yCoord (required) defines y coordinate of RollingEnemy
	 * @param stopXCoord (required) defines x coordinate to which RollingEnemy will roll 
	 * @param speed (required) defines speed at which RollingEnemy will move
	 * @param color (required) defines color for RollingEnemy
	 */
	public RollingEnemy(Group componentsGroup, double xCoord, double yCoord, double stopXCoord, 
			Duration speed, Color color) {
		
		//Call super class' constructor
		super(componentsGroup, xCoord, yCoord, color);	
		
		//Add RollingEnemy to ArrayList and remove from Enemy ArrayList
		rollingEnemies.add(0, this);
		super.enemiesArray.remove(this);
		
		//Create TranslateTransition for pointySquareOne
		tTOne = new TranslateTransition(speed, super.pointySquareOne);
		tTOne.setFromX(xCoord);
		tTOne.setToX(stopXCoord);
		tTOne.setCycleCount(1);
		tTOne.setAutoReverse(false);
		
		//Create TranslateTransition for pointySquareTwo
		tTTwo = new TranslateTransition(speed, super.pointySquareTwo);
		tTTwo.setFromX(xCoord);
		tTTwo.setToX(stopXCoord);
		tTTwo.setCycleCount(1);
		tTTwo.setAutoReverse(false);
		
		//Create TranslateTransition for enemyField
		tTThree = new TranslateTransition(speed, super.enemyField);
		tTThree.setFromX(xCoord);
		tTThree.setToX(stopXCoord);
		tTThree.setCycleCount(1);
		tTThree.setAutoReverse(false);
		
		//Set up super class' rTOne RotateTransition
		rTOne = new RotateTransition(speed, pointySquareOne);
		rTOne.setByAngle(720);
		rTOne.setAutoReverse(false);
		
		//Set up super class' rTTwo RotateTransition
		rTTwo = new RotateTransition(speed, pointySquareTwo);
		rTTwo.setByAngle(720);
		rTTwo.setAutoReverse(false);;
		
		//Create ParallelTransition, add previously created/set up Transitions 
		//to it, and call play()
		pT = new ParallelTransition();
		pT.getChildren().addAll(rTOne, rTTwo, tTOne, tTTwo, tTThree);
		pT.setAutoReverse(true);
		pT.setCycleCount(Animation.INDEFINITE);
		pT.play();
	}
	
	/**
	 * Get an ArrayList containing all instances of RollingEnemy.
	 * @return return an ArrayList containing all instances of RollingEnemy
	 */
	public static ArrayList<RollingEnemy> getRollingEnemiesArrayList() {
		return rollingEnemies;
	}
	
	/**
	 * Must be called before creating new Stage!
	 */
	public static void reset() {
		rollingEnemies.clear();
	}
}
