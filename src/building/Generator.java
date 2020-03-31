package building;

import building.base.Building;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Generator extends Building implements ItemReceiver {

	private static final int GENERATION_DELAY = 3;
	private static final int GENERATED_ELECTRICITY = 5;
	private boolean hasWood = false;
	private int cycle = 1;

	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/generator.png");
		target.getChildren().add(icon);

		// TODO: fill this boolean
		boolean hasWood = this.hasWood; // does this generator has wood in it?

		if (hasWood) {
			ItemIcon itemIcon = ItemType.WOOD.toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}

	@Override
	public boolean canReceiveItem(ItemType ofType) {
		if (ofType == ItemType.WOOD) {
			if (!this.hasWood) {
				return true;
			}
			// TODO Auto-generated method stub
			return false;
		}
		return false;
	}

	@Override
	public void receiveItem(Item item) {
		// TODO Auto-generated method stub
		if (this.canReceiveItem(item.getType())) {
			this.hasWood = true;
		}
	}

	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if (this.cycle == this.GENERATION_DELAY && this.hasWood) {
			GameState.instance.generateElectricity(this.GENERATED_ELECTRICITY);
			this.hasWood = false;
			this.cycle = 1;
		}
		else {
			this.cycle++;
		}
	}

}
