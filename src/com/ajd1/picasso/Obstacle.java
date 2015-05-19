package com.ajd1.picasso;

import java.util.ArrayList;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Obstacle extends RectangleComponent {
//	Rectangle obstacle;
	static ArrayList obstacles = new ArrayList<Obstacle>();
	
	public Obstacle(Group componentsGroup, double xCoord, double yCoord, double width, double height) {
		component = new Rectangle();
		component.setFill(Color.PURPLE);
		component.setWidth(width);
		component.setHeight(height);
		component.setTranslateX(xCoord);
		component.setTranslateY(yCoord);
		componentsGroup.getChildren().add(component);
		obstacles.add(0, this);
	}
	
	public static ArrayList<Obstacle> getObstacleArrayList() {
		return obstacles;
	}
	
	/**
	 * Must be called before creating new Stage!
	 */
	public static void reset() {
		obstacles.clear();
	}
}
