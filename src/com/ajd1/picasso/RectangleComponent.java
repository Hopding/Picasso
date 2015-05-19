package com.ajd1.picasso;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public abstract class RectangleComponent {
	Rectangle component;
	
	/**
	 * Get the lowest x coordinate of RectangleComponent.
	 * @return returns the lowest x coordinate of RectangleComponent
	 */
	public double getMinX() {
		return component.getBoundsInParent().getMinX();
	}
	
	/**
	 * Get the greatest x coordinate of RectangleComponent.
	 * @return returns the largest x coordinate of RectangleComponent
	 */
	public double getMaxX() {
		return component.getBoundsInParent().getMaxX();
	}
	
	/**
	 * Get the lowest y coordinate of RectangleComponent.
	 * @return returns the lowest y coordinate of RectangleComponent
	 */
	public double getMinY() {
		return component.getBoundsInParent().getMinY();
	}
	
	/**
	 * Get the largest y coordinate of RectangleComponent.
	 * @return returns the largest y coordinate of RectangleComponent
	 */
	public double getMaxY() {
		return component.getBoundsInParent().getMaxY();
	}
	
	/**
	 * Get Bounds of RectangleComponent.
	 * @return returns the Bounds of component in parent
	 */
	public Bounds getBounds() {
		return component.getBoundsInParent();
	}
	
}
