package building;

import building.base.Building;
import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Furnace extends Building implements ItemProducer, ItemReceiver {

	private static final int CRAFT_DELAY = 3;
	private static final int ENERGY_CONSUMPTION = 10;
	private boolean readyToProduceIronPlate = false;
	private boolean hasIron = false;
	private int cycle = 1;

	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/furnace.png");
		target.getChildren().add(icon);

		// TODO: fill these booleans
		boolean readyToProduceIronPlate = this.readyToProduceIronPlate; // is this furnace ready to produce an iron
																		// plate?
		boolean hasIron = this.hasIron; // does this furnace has iron in it?

		ItemIcon itemIcon = null;
		if (readyToProduceIronPlate) {
			itemIcon = ItemType.IRON_PLATE.toItemIcon();
		} else if (hasIron) {
			itemIcon = ItemType.IRON.toItemIcon();
		}

		if (itemIcon != null) {
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}

	@Override
	public boolean canReceiveItem(ItemType ofType) {
		// TODO Auto-generated method stub
		if (ofType == ItemType.IRON) {
			if (!this.hasIron && (ofType == ItemType.IRON)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public void receiveItem(Item item) {
		if (canReceiveItem(item.getType())) {
			this.hasIron = true;
		}
		// TODO Auto-generated method stub
	}

	@Override
	public boolean canProduceItem() {
		// TODO Auto-generated method stub
		return this.readyToProduceIronPlate;
	}

	@Override
	public Item getProducedItem() {
		if (canProduceItem()) {
			this.cycle = 0;
			this.readyToProduceIronPlate = false;
			return Item.ironPlate();
		}
		return null;
	}

	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if (this.cycle == this.CRAFT_DELAY && (GameState.instance.getElectricity() > this.CRAFT_DELAY * this.ENERGY_CONSUMPTION)) {
			GameState.instance.consumeElectricity(CRAFT_DELAY * ENERGY_CONSUMPTION);
			this.readyToProduceIronPlate = true;
		} else {
			this.cycle++;
		}
	}

}