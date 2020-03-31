package building;

import building.base.Building;
import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;

public class Anvil extends Building implements ItemProducer, ItemReceiver {
	private static final int CRAFT_DELAY = 5;
	private static final int ENERGY_CONSUMPTION = 15;
	private int cycle = 1;
	private static boolean ready = false, hasWood = false, hasIronPlate = false;

	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/anvil.png");
		target.getChildren().add(icon);

		HBox status = new HBox();
		StackPane.setAlignment(status, Pos.TOP_CENTER);

		// TODO: fill this booleans
		boolean ready = this.ready; // is this anvil ready (finished crafting iron sword)?
		boolean hasWood = this.hasWood; // does this anvil has wood on it?
		boolean hasIronPlate = this.hasIronPlate; // does this anvil has an iron plate on it?
		if (ready) {
			status.getChildren().add(ItemType.IRON_SWORD.toItemIcon());
		} else {
			if (hasWood) {
				status.getChildren().add(ItemType.WOOD.toItemIcon());
			}
			if (hasIronPlate) {
				status.getChildren().add(ItemType.IRON_PLATE.toItemIcon());
			}
		}
		target.getChildren().add(status);
	}

	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if (hasWood && hasIronPlate && this.cycle < CRAFT_DELAY) {
			this.cycle++;
			// GameState.instance.consumeElectricity(ENERGY_CONSUMPTION);
		} else if (CRAFT_DELAY == this.cycle && (GameState.instance.getElectricity() > this.CRAFT_DELAY * this.ENERGY_CONSUMPTION)) {
			GameState.instance.consumeElectricity(CRAFT_DELAY * ENERGY_CONSUMPTION);
			this.ready = true;
		}
	}

	@Override
	public boolean canReceiveItem(ItemType ofType) {
		if (ofType.equals(ItemType.WOOD) && !hasWood) {
			return true;
		}
		if (ofType == ItemType.IRON_PLATE && !hasIronPlate) {
			return true;
		}
		return false;
	}

	@Override
	public void receiveItem(Item item) {
		if (this.canReceiveItem(item.getType())) {
			if (item.getType() == ItemType.WOOD) {
				this.hasWood = true;
			}
			if (item.getType() == ItemType.IRON_PLATE) {
				this.hasIronPlate = true;
			}
		}
	}

	@Override
	public boolean canProduceItem() {
		if (this.ready) {
			return true;
		}
		return false;
	}

	@Override
	public Item getProducedItem() {
		if (this.canProduceItem()) {
			this.cycle = 0;
			this.hasWood = false;
			this.hasIronPlate = false;
			this.ready = false;
			// TODO Auto-generated method stub
			return Item.ironSword();

		}
		return null;
	}
}
