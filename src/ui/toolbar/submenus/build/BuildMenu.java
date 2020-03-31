package ui.toolbar.submenus.build;

import building.Anvil;
import building.Chest;
import building.ConveyorBelt;
import building.Drill;
import building.Furnace;
import building.Generator;
import building.Sawmill;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuildMenu extends VBox {
	public BuildMenu() {
		super();
		Label title = new Label("Build Menu");
		
		this.getChildren().add(title);
		this.getChildren().add(new BuildButtons());
		
		this.setStyle("-fx-border-width: 1px;");
		this.setStyle("-fx-border-color: green;");
	}
}

class BuildButtons extends HBox {
	public BuildButtons() {
		super();
		Class<?>[] buildings = {
				Sawmill.class, Drill.class, Generator.class, Furnace.class, Anvil.class, Chest.class
		};
		
		for(int i=0; i<buildings.length; i++) {
			this.getChildren().add(new BuildButton(buildings[i]));
		}
		
		this.getChildren().add(new BuildButtonWithDirections(ConveyorBelt.class));
	}
}
