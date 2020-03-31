package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import building.ConveyorBelt;
import item.Item;
import item.ItemType;
import logic.Direction;
import logic.Field;
import logic.GameState;
import test.base.GameTest;

public class TestConveyorBelt extends GameTest {
	ConveyorBelt belt;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		belt = new ConveyorBelt(Direction.RIGHT);
		Field.instance.at(0, 0).placeBuildingOnCell(belt);
	}

	@Test
	void testCanReceiveItem() {
		assertTrue(belt.canReceiveItem(ItemType.WOOD));
	}
	
	@Test
	void testGetItemOnBelt() {
		Item item = Item.ironPlate();
		belt.receiveItem(item);
		assertEquals(item, belt.getItemOnBelt());
	}
	
	@Test
	void testCanProduceItem() {
		assertFalse(belt.canProduceItem());
		
		belt.receiveItem(Item.wood());
		assertFalse(belt.canProduceItem());
		GameState.instance.update();
		
		assertTrue(belt.canProduceItem());
	}
	
	@Test
	void testGetProducedItem() {
		belt.receiveItem(Item.wood());
		GameState.instance.update();
		
		assertEquals(ItemType.WOOD, belt.getProducedItem().getType());
	}
}
