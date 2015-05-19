package com.ajd1.picasso;

import java.util.ArrayList;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Platform extends RectangleComponent {
	
	//Static ArrayList for all instances of Platform to add themselves too
	protected static ArrayList platformsArray = new ArrayList<Platform>();
	
	/**
	 * Constructor.
	 * 
	 * @param componentsGroup (required) defines the group to which this component will be added.
	 * @param x (required) defines x coordinate of upper left corner of component
	 * @param y (required) defines y coordinate of upper left corner of component
	 * @param width (required) defines width of component (width increases to the right of upper left corner)
	 * @param height (default is 10) defines height of component (height increases downward from upper left corner)
	 * @param color (default is BLACK) defines color of component
	 */
	public Platform(Group componentsGroup, double x, double y, double width, double height, Color color) {
		this(componentsGroup, x, y, width);
		component.setHeight(height);
		component.setFill(color);
		platformsArray.add(0, this);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param componentsGroup (required) defines the group to which this component will be added.
	 * @param x (required) defines x coordinate of upper left corner of component
	 * @param y (required) defines y coordinate of upper left corner of component
	 * @param width (required) defines width of component (width increases to the right of upper left corner)
	 */
	public Platform(Group componentsGroup, double x, double y, double width) {
		//Set up component
		component = new Rectangle();
		component.setWidth(width);
		component.setHeight(10);
		component.setFill(Color.BLACK);
		component.setTranslateX(x);
		component.setTranslateY(y);
		
		//Add component to root of passed in scene
		componentsGroup.getChildren().add(component);
		
		//Add Platform ArrayList
		platformsArray.add(0, this);
	}
	
	/**
	 * Get an ArrayList containing all instances of Platform.
	 * @return returns an ArrayList containing all instances of Platform
	 */
	public static ArrayList<Platform> getPlatformsArrayList() {
		return platformsArray;
	}
	
	/**
	 * Must be called before creating new Stage!
	 */
	public static void reset() {
		platformsArray.clear();
	}
}
