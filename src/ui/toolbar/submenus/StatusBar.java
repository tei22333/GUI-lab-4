package ui.toolbar.submenus;

import java.util.Observable;
import java.util.Observer;

import building.base.Building;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import ui.UIState;

public class StatusBar extends HBox implements Observer {
	Label statusLabel;
	Button cancelButton;
	
	public StatusBar() {
		super();
		statusLabel = new Label("status??");
		cancelButton = new Button("cancel");
		cancelButton.setDisable(true);
		cancelButton.setPadding(new Insets(0));
		cancelButton.setOnAction(e -> UIState.instance.clearSelectedBuilding());
		UIState.instance.addObserver(this);
		
		StackPane space = new StackPane();
		setHgrow(space, Priority.ALWAYS);
		
		this.getChildren().addAll(statusLabel, space, cancelButton);
		
		this.setStatusLabel(null);
	}
	
	private void setStatusLabel(Building building) {
		if(building == null) {
			statusLabel.setText("Select a building to build.");
		} else {
			String buildingName = building.getClass().getSimpleName();
			statusLabel.setText("Select cell to build " + buildingName);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Building selectedBuilding = UIState.instance.getSelectedBuilding();
		this.setStatusLabel(selectedBuilding);
		cancelButton.setDisable(selectedBuilding == null);
	}

}
