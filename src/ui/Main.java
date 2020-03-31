package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final double WINDOW_WIDTH = 900;
	private static final double WINDOW_HEIGHT = 600;	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Blacksmith's Factory");
		
		primaryStage.setWidth(WINDOW_WIDTH);
		primaryStage.setHeight(WINDOW_HEIGHT);
		
		Scene primaryScene = new Scene(new UIRoot());
		primaryStage.setScene(primaryScene);
		primaryStage.show();
		
		GameRunner.instance.start();
	}
	
	@Override
	public void stop() throws Exception {
		GameRunner.instance.stop();
		super.stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
