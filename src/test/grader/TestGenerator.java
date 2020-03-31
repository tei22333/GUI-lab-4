package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import building.Generator;
import item.Item;
import item.ItemType;
import logic.Field;
import logic.GameState;
import test.base.GameTest;

public class TestGenerator extends GameTest {
	Generator generator;

	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		generator = new Generator();
		Field.instance.at(0, 0).placeBuildingOnCell(generator);
	}
	
	@Test
	void testCanReceiveItem() {
		assertTrue(generator.canReceiveItem(ItemType.WOOD));
	}
	
	@Test
	void testOperate() {
		generator.receiveItem(Item.wood());
		GameState.instance.update();
		assertEquals(0, GameState.instance.getElectricity());
		GameState.instance.update(2);
		assertEquals(5, GameState.instance.getElectricity());
	}
}
