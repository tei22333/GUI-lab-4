package item;

import ui.ItemIcon;

public enum ItemType {
	WOOD,
	IRON,
	IRON_PLATE,
	IRON_SWORD;
	
	public ItemIcon toItemIcon() {
		switch(this) {
		case WOOD:
			return new ItemIcon("file:res/wood.png");
		case IRON:
			return new ItemIcon("file:res/iron.png");
		case IRON_PLATE:
			return new ItemIcon("file:res/ironplate.png");
		case IRON_SWORD:
			return new ItemIcon("file:res/ironsword.png");
		default:
			return new ItemIcon("file:res/wood.png");
		}
	}
}
