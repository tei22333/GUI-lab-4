package ui.toolbar.submenus.build;

import java.lang.reflect.Constructor;

import building.base.Building;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ui.UIState;

public class BuildButton extends VBox {
	Class<?> building;
	public BuildButton(Class<?> building) {
		super();
		
		this.building = building;
		
		Label nameLabel = new Label(building.getSimpleName());
		Button buildButton = new Button("Build");
		buildButton.setPadding(new Insets(0));
		
		buildButton.setOnAction(e -> {
			UIState.instance.setSelectedBuilding(this.createBuilding());
		});
		
		nameLabel.setWrapText(true);
		
		this.getChildren().add(nameLabel);
		this.getChildren().add(buildButton);
		
		this.setMinWidth(50);
		this.setMaxWidth(50);
		this.setMinHeight(100);
		
		this.setStyle("-fx-border-width: 1px;");
		this.setStyle("-fx-border-color: yellow;");

	}
	
	public Building createBuilding() {
		Building building = null;
		try {
			Constructor<?> constructor;
			constructor = this.building.getConstructor();
			building = (Building) constructor.newInstance();
		} catch (Exception e) {}
		
		return building;
	}
}