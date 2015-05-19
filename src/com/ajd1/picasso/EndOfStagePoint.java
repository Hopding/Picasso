package com.ajd1.picasso;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class EndOfStagePoint {
	Polygon endPoint;
	boolean spinning;
	
	/**
	 * Constructor. 
	 *
	 * @param componentsGroup (required) defines group to which EndOfStagePoint will be added
	 * @param xCoord (required) defines x coordinate at which EndOfStagePoint will be placed
	 * @param yCoord (required) defines y coordinate at which EndOfStagePoint will be placed
	 */
	public EndOfStagePoint(Group componentsGroup, double xCoord, double yCoord) {
		endPoint = new Polygon();
		endPoint.getPoints().addAll(new Double[]{3.0, 0.0, 5.0, 5.0, 0.0, 2.0, 6.0, 2.0, 1.0, 5.0, 3.0, 0.0});
		endPoint.setScaleX(10);
		endPoint.setScaleY(10);
		endPoint.setTranslateX(xCoord);
		endPoint.setTranslateY(yCoord);
		endPoint.setFill(Color.YELLOW);
		componentsGroup.getChildren().add(endPoint);
		
		ScaleTransition st = new ScaleTransition(Duration.millis(1500), endPoint);
		st.setByX(3f);
		st.setByY(3f);
		st.setAutoReverse(true);
		st.setCycleCount(Animation.INDEFINITE);
		st.play();
	}
	
	/**
	 * Cause EndOfStagePoint to begin spinning.
	 */
	public void spin() {
		if(!spinning) {
			RotateTransition rt = new RotateTransition(Duration.millis(1000), endPoint);
			rt.setByAngle(360);
			rt.setAutoReverse(false);
			rt.setCycleCount(Animation.INDEFINITE);
			rt.play();
			spinning = true;
		}
	}
	
	public Bounds getBounds() {
		return endPoint.getBoundsInParent();
	}
}