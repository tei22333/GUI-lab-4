package building.base;

import item.Item;
import item.ItemType;

public interface ItemReceiver {
	// delete the following line and FILL CODE
	/*THIS SHOULD FAIL TO COMPILE*/
	public boolean canReceiveItem(ItemType ofType);
	public void receiveItem(Item item);
}