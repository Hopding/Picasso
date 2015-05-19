package com.ajd1.picasso;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class HorizontalMovingPlatform extends Platform {
	//Static ArrayList to which all instances of HorizontalMovingPlatform will add themselves
	protected static ArrayList hMPArrayList = new ArrayList<HorizontalMovingPlatform>();

	/**
	 * Constructor.
	 * 
	 * @param componentsGroup (required defines the group to which this platform will be added
	 * @param xCoord (required) defines x coordinate of upper left corner of platform
	 * @param yCoord (required) defines y coordinate of upper left corner of platform
	 * @param endXCoord (required) defines the point to which platform will travel
	 * @param movementSpeed (required) defines speed at which platform will travel
	 * @param width (required) defines width of platform (width increases to the right of upper left corner)
	 * @param height (default is 10) defines height of platform (height increases downward from upper left corner)
	 * @param color (default is ORANGERED) defines color of platform
	 */
	public HorizontalMovingPlatform(Group componentsGroup, double xCoord, double yCoord, double endXCoord, Duration movementSpeed, 
			double width, double height, Color color) {
		//Call super class' constructor
		super(componentsGroup, xCoord, yCoord, width, height, color);
		
		//Add HorizontalMovingplatform to ArrayList and remove from Platform ArrayList
		hMPArrayList.add(0, this);
		super.platformsArray.remove(this);
		
		//Create TranslateTransition for HorizontalMovingplatform and call play()
		TranslateTransition tt = new TranslateTransition(movementSpeed, component);
		tt.setFromX(xCoord);
		tt.setToX(endXCoord - width);
		tt.setCycleCount(Animation.INDEFINITE);
		tt.setAutoReverse(true);
		tt.play();
	}
	
	/**
	 * Constructor.
	 * 
	 * @param componentsGroup (required defines the group to which this platform will be added
	 * @param xCoord (required) defines x coordinate of upper left corner of platform
	 * @param yCoord (required) defines y coordinate of upper left corner of platform
	 * @param endXCoord (required) defines the point to which platform will travel
	 * @param movementSpeed (required) defines speed at which platform will travel
	 * @param width (required) defines width of platform (width increases to the right of upper left corner)
	 */
	public HorizontalMovingPlatform(Group componentsGroup, double xCoord, double yCoord, double endXCoord, Duration movementSpeed, 
			double width) {
		//Call super class' constructor
		super(componentsGroup, xCoord, yCoord, width);
		component.setFill(Color.ORANGERED);
		
		//Add HorizontalMovingplatform to ArrayList and remove from Platform ArrayList
		hMPArrayList.add(0, this);
		super.platformsArray.remove(this);
		
		//Create TranslateTransition for HorizontalMovingplatform and call play()
		TranslateTransition tt = new TranslateTransition(movementSpeed, component);
		tt.setFromX(xCoord);
		tt.setToX(endXCoord - width);
		tt.setCycleCount(Animation.INDEFINITE);
		tt.setAutoReverse(true);
		tt.play();
	}
	
	/**
	 * Get an ArrayList containing all instances of HorizontaMovingPlatform
	 * @return returns an ArrayList containing all instances of HorizontalMovingPlatform
	 */
	public static ArrayList<HorizontalMovingPlatform> gethMPArrayList() {
		return hMPArrayList;
	}
	
	/**
	 * Must be called before creating new stage!
	 */
	public static void reset() {
		hMPArrayList.clear();
	}
}
