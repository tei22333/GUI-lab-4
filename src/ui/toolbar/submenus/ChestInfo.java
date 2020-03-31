package ui.toolbar.submenus;

import java.util.Observable;
import java.util.Observer;

import building.Chest;
import building.base.Building;
import item.ItemType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.Cell;
import ui.GameRunner;
import ui.UIState;

public class ChestInfo extends VBox implements Observer {
	Chest chest;
	
	private class ChestInfoItem extends HBox {
		public ChestInfoItem(ItemType type, int amount) {
			super();
			
			Label typeLabel = new Label(type.name().toString());
			Label amountLabel = new Label(Integer.toString(amount));
			
			StackPane space = new StackPane();
			HBox.setHgrow(space, Priority.ALWAYS);
			
			this.getChildren().addAll(typeLabel, space, amountLabel);
		}
	}
	
	public ChestInfo() {
		super();
		this.getChildren().add(new Label("Select a chest to view its items"));
		UIState.instance.addObserver(this);
		GameRunner.instance.addObserver(this);
		
		this.setStyle("-fx-border-width: 1px;");
		this.setStyle("-fx-border-color: purple;");
	}
	
	private void setChest(Chest chest) {
		this.chest = chest;
		this.updateInfo();
	}
	
	private void updateInfo() {
		this.getChildren().clear();
		if(this.chest.getInventory().isEmpty()) {
			this.getChildren().add(new Label("no item in chest"));
		}
		for(ItemType type: this.chest.getInventory().keySet()) {
			this.getChildren().add(new ChestInfoItem(type, this.chest.getInventory().get(type)));
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof UIState) {
			Cell selectedCell = UIState.instance.getSelectedCell();
			if(selectedCell != null) {
				Building buildingOnCell = selectedCell.getBuildingOnCell();
				if(buildingOnCell != null && buildingOnCell instanceof Chest) {
					this.setChest((Chest) selectedCell.getBuildingOnCell());
				}
			}
		} else if (o instanceof GameRunner) {
			if(this.chest != null) {
				this.updateInfo();
			}
		}
	}
}
