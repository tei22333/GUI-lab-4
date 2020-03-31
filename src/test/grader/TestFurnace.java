package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import building.Furnace;
import item.Item;
import item.ItemType;
import logic.Field;
import logic.GameState;
import test.base.GameTest;

public class TestFurnace extends GameTest {
	
	private static final int TARGET_ENERGY_CONSUMPTION = 10;

	Furnace furnace;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		furnace = new Furnace();
		Field.instance.at(0, 0).placeBuildingOnCell(furnace);
	}
	
	@Test
	void testCanReceiveItem() {
		assertTrue(furnace.canReceiveItem(ItemType.IRON));
	}
	
	@Test
	void testOperate() {
		setUpElectricity();
		furnace.receiveItem(Item.iron());
		GameState.instance.update(3);
		assertElectricityConsumed(3 * TARGET_ENERGY_CONSUMPTION);
		assertTrue(furnace.canProduceItem());
		assertEquals(ItemType.IRON_PLATE, furnace.getProducedItem().getType());
	}
}
