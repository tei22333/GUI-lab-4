package building;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import building.base.Building;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import ui.BuildingIcon;

public class Chest extends Building implements ItemReceiver {
	private List<Item> items = new ArrayList<Item>();
	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/chest.png");
		target.getChildren().add(icon);

		Label numberOfItemsLabel = new Label();
		String numberOfItemsText = Integer.toString(this.getInventory().values().stream().reduce(0, (a, b) -> a + b));
		numberOfItemsLabel.setText(numberOfItemsText);
		StackPane.setAlignment(numberOfItemsLabel, Pos.TOP_CENTER);

		target.getChildren().add(numberOfItemsLabel);
	}

	/* getters & setters */

	public Map<ItemType, Integer> getInventory() {
		return this.count();
	}

	@Override
	public boolean canReceiveItem(ItemType ofType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void receiveItem(Item item) {
		items.add(item);
	}

	public Map<ItemType,Integer> count() {
		// TODO Auto-generated method stub
		Map<ItemType, Integer> Inventory = new HashMap<>();
		for (Item x : this.items) {
			ItemType c = x.getType();
			if(Inventory.containsKey(c)) {
				Inventory.replace(c, Inventory.get(c)+1);
			}
			else {
				Inventory.put(c, 1);
			}
		}
		return Inventory;
	}

	@Override
	public void operate() {
		// TODO Auto-generated method stub
		
	}

}