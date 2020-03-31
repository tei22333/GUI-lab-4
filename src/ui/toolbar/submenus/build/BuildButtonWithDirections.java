package ui.toolbar.submenus.build;

import java.lang.reflect.Constructor;

import building.base.Building;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.Direction;

public class BuildButtonWithDirections extends BuildButton {
	
	private Direction direction = Direction.UP;
	private Label directionLabel;
	
	public BuildButtonWithDirections(Class<?> building) {
		super(building);
		directionLabel = new Label("??");
		this.updateDirectionLabel();

		Button rotateButton = new Button("rotate");
		rotateButton.setPadding(new Insets(0));
		rotateButton.setOnAction(e -> this.rotate());
		
		this.getChildren().add(directionLabel);
		this.getChildren().add(rotateButton);
	}
	
	private void rotate() {
		this.direction = this.direction.rotateCW();
		this.updateDirectionLabel();
	}
	
	private void updateDirectionLabel() {
		this.directionLabel.setText(this.direction.toString());
	}
	
	@Override
	public Building createBuilding() {
		Building building = null;
		try {
			Constructor<?> constructor = this.building.getConstructor(Direction.class);
			building = (Building) constructor.newInstance(this.direction);
		} catch (Exception e) {}
		return building;
	}
}
