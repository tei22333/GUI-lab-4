package ui.toolbar.submenus;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import logic.GameState;
import ui.GameRunner;

public class ControlBar extends GridPane implements Observer {
	
	private Label cycleLabel;
	
	public ControlBar() {
		super();
		
		cycleLabel = new Label("Cycle 0");
		setHgrow(cycleLabel, Priority.ALWAYS);
		
		Button pauseButton = new Button("pause");
		pauseButton.setOnAction(e -> {
			GameRunner.instance.pause();
		});
		
		Button playButton = new Button("play");
		playButton.setOnAction(e -> {
			GameRunner.instance.unpause();
		});
		
		Button nextButton = new Button("next");
		nextButton.setOnAction(e -> {
			GameRunner.instance.update();
		});
		
		this.add(cycleLabel, 0, 0);
		this.add(pauseButton, 1, 0);
		this.add(playButton, 2, 0);
		this.add(nextButton, 3, 0);
		
		this.setStyle("-fx-border-width: 1px;");
		this.setStyle("-fx-border-color: gray;");
		
		GameRunner.instance.addObserver(this);
	}
	
	@Override
	protected void finalize() throws Throwable {
		GameRunner.instance.deleteObserver(this);
		super.finalize();
	}

	@Override
	public void update(Observable o, Object arg) {
		this.cycleLabel.setText("Cycle " + GameState.instance.getCycles());
	}
}
