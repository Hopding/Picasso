package com.ajd1.picasso;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class LifeRestorer {
	Polygon lifeRestorer;
	Group componentsGrp;
	
	//Static ArrayList to which all instances of LifeRestorer will add themselves
	protected static ArrayList lifeRestorers = new ArrayList<LifeRestorer>();
	
	/**
	 * Constructor.
	 * 
	 * @param componentsGroup (required) group to which LifeRestorer will be added
	 * @param xCoord (required) defines x coordinate of LifeRestorer
	 * @param yCoord (required) defines y coordinate of LifeRestorer
	 */
	public LifeRestorer(Group componentsGroup, double xCoord, double yCoord) {
		componentsGrp = componentsGroup;
		lifeRestorer = new Polygon();
		lifeRestorers.add(0, this);
		lifeRestorer.getPoints().addAll(new Double[]{1.0, 6.0, 6.0, 
										6.0, 7.0, 5.0, 4.0, 1.0, 5.0, 
										1.0, 5.0, 0.0, 2.0, 0.0, 2.0, 
										1.0, 3.0, 1.0, 0.0, 5.0, 1.0, 6.0});
		lifeRestorer.setScaleX(6);
		lifeRestorer.setScaleY(6);
		lifeRestorer.setTranslateX(xCoord);
		lifeRestorer.setTranslateY(yCoord);
		lifeRestorer.setFill(Color.GOLDENROD);
		componentsGroup.getChildren().add(lifeRestorer);
		FadeTransition ft = new FadeTransition(Duration.millis(2000), lifeRestorer);
		ft.setFromValue(1);
		ft.setToValue(.7);
		ft.setCycleCount(Animation.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
	}
	
	/**
	 * Get bounds of LifeRestorer.
	 * @return the bounds of LifeRestorer in parent
	 */
	public Bounds getBounds() {
		return lifeRestorer.getBoundsInParent();
	}
	
	/**
	 * Remove LifeRestorer from it's parent node.
	 */
	public void delete() {
		componentsGrp.getChildren().remove(lifeRestorer);
	}
	
	/**
	 * Get an ArrayList containing all instances of LifeRestorer.
	 * @return returns an ArrayList containing all instances of LifeRestorer
	 */
	public static ArrayList<LifeRestorer> getLifeRestorerArrayList() {
		return lifeRestorers;
	}
	
	public static void reset() {
		lifeRestorers.clear();
	}
}
