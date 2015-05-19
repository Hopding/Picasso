package com.ajd1.picasso;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class HealthHUD {
	Group HUDGroup = new Group();	
	ArrayList<Polygon> healthCount = new ArrayList<Polygon>();
	int healthCountPos;
	int x = 13;
	int y = 11;
	
	public HealthHUD(Group root, int lifeCount) {
		root.getChildren().add(HUDGroup);
		for (int i = 0; i <= lifeCount; i++) {
			Polygon p = new Polygon();
			healthCount.add(p);
			healthCount.trimToSize();
			p.getPoints().addAll(new Double[]{3.0, 1.0, 4.0, 0.0, 
								5.0, 0.0, 6.0, 1.0, 6.0, 2.0, 3.0, 
								5.0, 0.0, 2.0, 0.0, 1.0, 1.0, 0.0, 
								2.0, 0.0, 3.0, 1.0});
			p.setFill(Color.RED);
			p.setTranslateX(x);
			p.setTranslateY(y);
			p.setScaleX(5);
			p.setScaleY(5);
			HUDGroup.getChildren().add(p);
			x = x + 35;
		}
		healthCountPos = healthCount.size() - 1;
	}
	
	public void removeHealth() {
		if (healthCountPos > -1) {
			HUDGroup.getChildren().remove(healthCount.get(healthCountPos));
			healthCount.remove(healthCount.size() - 1);
			healthCount.trimToSize();
			healthCountPos--;
			x = x - 35;
		}
	}
	
	public void addHealth() {
		Polygon p = new Polygon();
		healthCount.add(p);
		healthCount.trimToSize();
		p.getPoints().addAll(new Double[]{3.0, 1.0, 4.0, 0.0, 
							5.0, 0.0, 6.0, 1.0, 6.0, 2.0, 3.0, 
							5.0, 0.0, 2.0, 0.0, 1.0, 1.0, 0.0, 
							2.0, 0.0, 3.0, 1.0});
		p.setFill(Color.RED);
		p.setTranslateX(x);
		p.setTranslateY(y);
		p.setScaleX(5);
		p.setScaleY(5);
		HUDGroup.getChildren().add(p);
		x = x + 35;
		healthCountPos++;
	}
}
