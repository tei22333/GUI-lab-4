package building;

import building.base.Building;
import building.base.ItemProducer;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Drill extends Building implements ItemProducer {

	private static final int HARVEST_INTERVAL = 4;
	private static final int ENERGY_CONSUMPTION = 5;
	private boolean readyToProduceIron = false;
	private int cycle = 1;

	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/drill.png");
		target.getChildren().add(icon);
		
		// TODO: fill this boolean
		boolean readyToProduceIron = this.readyToProduceIron;		// is this drill ready to produce iron?
		
		if(readyToProduceIron) {
			ItemIcon itemIcon = ItemType.IRON.toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}
	public void operate() {
		if (this.cycle == this.HARVEST_INTERVAL && (GameState.instance.getElectricity() > this.HARVEST_INTERVAL* this.ENERGY_CONSUMPTION)) {
			this.readyToProduceIron = true;
			GameState.instance.consumeElectricity(HARVEST_INTERVAL*ENERGY_CONSUMPTION);
		}
		else {
			this.cycle += 1;
		}
	}
	@Override
	public boolean canProduceItem() {
		// TODO Auto-generated method stub
		return this.readyToProduceIron;
	}
	@Override
	public Item getProducedItem() {
		if(this.readyToProduceIron) {
			this.readyToProduceIron = false;
			this.cycle = 0;
			return Item.iron();
		}
		return null;
	}
}
