package item;

public class Item {

	private ItemType type;
	
	public Item(ItemType type) {
		this.type = type;
	}
	
	public ItemType getType() {
		return this.type;
	}
	
	/* utility functions */
	public static Item wood() {
		return new Item(ItemType.WOOD);
	}
	
	public static Item iron() {
		return new Item(ItemType.IRON);
	}
	
	public static Item ironPlate() {
		return new Item(ItemType.IRON_PLATE);
	}
	
	public static Item ironSword() {
		return new Item(ItemType.IRON_SWORD);
	}
}
