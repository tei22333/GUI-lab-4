package building;

import building.base.Building;
import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.Direction;
import logic.Field;
import ui.BuildingIcon;
import ui.ItemIcon;

public class ConveyorBelt extends Building implements ItemReceiver, ItemProducer {
	private Direction direction;
	private boolean ckertrans = false;
	private Item ItemOnBelt;
	public ConveyorBelt(Direction direction) {
		this.direction = direction;
	}

	
	@Override
	public void beforeCycle() {
		if (this.ItemOnBelt == null) {
			this.ckertrans = false;
		}
		else {
			this.ckertrans = true;
		}
	}
	
	/* getters & setters */
	public Item getItemOnBelt() {
		if(this.ItemOnBelt!= null) {
			return this.ItemOnBelt;
		}
		return null;
	}
	
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public void render(StackPane target) {
		
		BuildingIcon icon = new BuildingIcon("file:res/belt.png");
		
		switch(this.getDirection()) {
		case RIGHT:
			icon.setRotate(90);
			break;
		case LEFT:
			icon.setRotate(270);
			break;
		case DOWN:
			icon.setRotate(180);
			break;
		default:
			break;
		}
		
		target.getChildren().add(icon);
		
		Item itemOnBelt = this.getItemOnBelt();
		
		if(itemOnBelt != null) {
			ItemIcon itemIcon = itemOnBelt.getType().toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}


	@Override
	public boolean canProduceItem() {
		// TODO Auto-generated method stub
		if (this.ItemOnBelt != null && this.ckertrans) {
			return true;
		}
		return false;
	}


	@Override
	public Item getProducedItem() {
		Item x = this.ItemOnBelt;
		// TODO Auto-generated method stub
		if (this.canProduceItem()) {
			this.ItemOnBelt = null;
			//this.carrying = false;
			return x;
		}
		return null;
	}


	@Override
	public boolean canReceiveItem(ItemType ofType) {
		// TODO Auto-generated method stub
		if (this.ItemOnBelt == null) {
			return true;
		}
		return false;
	}


	@Override
	public void receiveItem(Item item) {
		// TODO Auto-generated method stub
		this.ItemOnBelt = item;
	}


	@Override
	public void operate() {
		Building BB = Field.instance.getBuildingInBack(this.direction) ;
		// TODO Auto-generated method stub
		if (this.ItemOnBelt != null) {
			Building bf = Field.instance.getBuildingInFront(this.direction);
			if (bf instanceof ItemReceiver) {
				if(((ItemReceiver) bf).canReceiveItem(this.ItemOnBelt.getType())) {
					((ItemReceiver) bf).receiveItem(this.ItemOnBelt);
				}
			}
		}
		else {
			if (this.ItemOnBelt == null && BB instanceof ItemProducer) {
				if(((ItemProducer) BB).canProduceItem()){
					this.receiveItem(((ItemProducer) BB).getProducedItem());
				}
			}
		}
	}
}
