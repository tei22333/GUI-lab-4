package ui;

import java.util.Observable;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import logic.GameState;

public class GameRunner extends Observable {
	private static final long UPDATE_INTERVAL = 500;

	public static final GameRunner instance = new GameRunner();
	
	private Timeline gameLoop;
	private boolean paused = false;

	public void update() {
		GameState.instance.update();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void pause() {
		paused = true;
	}
	
	public void unpause() {
		paused = false;
	}
	
	public void stop() {
		gameLoop.stop();
	}
	
	public void start() {		
		gameLoop = new Timeline(new KeyFrame(Duration.millis(UPDATE_INTERVAL), e -> {
			if(!paused) {
				update();
			}
		}));
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		gameLoop.play();
	}
}
