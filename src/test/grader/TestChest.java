package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import building.Chest;
import item.ItemType;
import logic.Field;
import test.base.GameTest;

public class TestChest extends GameTest {
	Chest chest;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		chest = new Chest();
		Field.instance.at(0, 0).placeBuildingOnCell(chest);
	}
	
	@Test
	void testCanReceiveItem() {
		assertTrue(chest.canReceiveItem(ItemType.WOOD));
		assertTrue(chest.canReceiveItem(ItemType.IRON));
		assertTrue(chest.canReceiveItem(ItemType.IRON_PLATE));
		assertTrue(chest.canReceiveItem(ItemType.IRON_SWORD));
	}
}
