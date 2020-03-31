package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import building.Anvil;
import item.Item;
import item.ItemType;
import logic.Field;
import logic.GameState;
import test.base.GameTest;

public class TestAnvil extends GameTest{
	
	private static final int TARGET_ENERGY_CONSUMPTION = 15;
	
	Anvil anvil;
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		anvil = new Anvil();
		Field.instance.at(0, 0).placeBuildingOnCell(anvil);
	}
	
	@Test
	void testOperate() {
		setUpElectricity();
		anvil.receiveItem(Item.ironPlate());
		anvil.receiveItem(Item.wood());
		
		GameState.instance.update(5);
		
		assertElectricityConsumed(5 * TARGET_ENERGY_CONSUMPTION);
		assertTrue(anvil.canProduceItem());
		assertEquals(ItemType.IRON_SWORD, anvil.getProducedItem().getType());
	}
	
	@Test
	void testCanReceiveItem() {
		assertTrue(anvil.canReceiveItem(ItemType.WOOD));
		assertTrue(anvil.canReceiveItem(ItemType.IRON_PLATE));
	}
}
