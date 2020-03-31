package ui.toolbar.submenus;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.GameRunner;

public class ElectricityMeter extends HBox implements Observer {
	
	private Label value;
	
	public ElectricityMeter() {
		super();
		
		Label title = new Label("Electricity");
		
		StackPane spacing = new StackPane();
		
		value = new Label("0");
		value.setAlignment(Pos.BASELINE_RIGHT);
		
		setHgrow(spacing, Priority.ALWAYS);
		this.getChildren().add(title);
		this.getChildren().add(spacing);
		this.getChildren().add(value);
		
		this.setStyle("-fx-border-width: 1px;");
		this.setStyle("-fx-border-color: cyan;");
		
		GameRunner.instance.addObserver(this);
	}
	
	@Override
	protected void finalize() throws Throwable {
		GameRunner.instance.deleteObserver(this);
		super.finalize();
	}

	@Override
	public void update(Observable o, Object arg) {
		value.setText(Integer.toString(GameState.instance.getElectricity()));
	}
}
