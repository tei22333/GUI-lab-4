package ui.field;

import building.base.Building;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import logic.Field;
import ui.GameRunner;
import ui.UIState;

public class FieldUI extends GridPane {
	public FieldUI() {
		super();
	
		for(int i=0; i<Field.FIELD_HEIGHT; i++) {
			for(int j=0; j<Field.FIELD_WIDTH; j++) {
				CellUI cell = new CellUI(Field.instance.at(j, i));
				setConstraints(cell, j, i, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, null);
				cell.update(GameRunner.instance, null);

				final int x = j;
				final int y = i;
				cell.setOnMouseClicked(e -> {
					System.out.println("Clicked cell " + x + " " + y);
					Building building = UIState.instance.getSelectedBuilding();
					if(building != null) {
						Field.instance.at(x, y).placeBuildingOnCell(building);
						UIState.instance.clearSelectedBuilding();
						cell.update(GameRunner.instance, null);
					} else {
						UIState.instance.clearSelectedBuilding();
						UIState.instance.setSelectedCell(Field.instance.at(x, y));
					}
				});
				this.getChildren().add(cell);
			}
		}
		
		this.setStyle("-fx-border-width: 1px;");
		this.setStyle("-fx-border-color: blue;");
	}
}
