package com.ajd1.picasso;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Picasso extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});
		primaryStage.setTitle("PICASSO");
		new MainMenu(primaryStage).display();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
