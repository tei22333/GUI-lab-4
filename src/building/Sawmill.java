package building;

import building.base.Building;
import building.base.ItemProducer;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Sawmill extends Building implements ItemProducer {

	private static final int HARVEST_INTERVAL = 3;
	private boolean readyToProduceWood = false;
	private int cycle = 1;

	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/sawmill.png");
		target.getChildren().add(icon);

		// TODO: fill this boolean
		boolean readyToProduceWood = this.readyToProduceWood; // is this sawmill ready to produce wood?

		if (readyToProduceWood) {
			ItemIcon itemIcon = ItemType.WOOD.toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}

	@Override
	public boolean canProduceItem() {
		// TODO Auto-generated method stub
		return readyToProduceWood;
	}

	@Override
	public Item getProducedItem() {
		// TODO Auto-generated method stub
		if(this.canProduceItem()) {
			this.readyToProduceWood = false;
			this.cycle = 1;
			return Item.wood();
		}
		return null;
	}

	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if(this.cycle == this.HARVEST_INTERVAL) {
			this.readyToProduceWood = true;
		}
		else {
			this.cycle ++ ;
		}
	}
}
