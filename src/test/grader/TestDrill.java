package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import building.Drill;
import item.ItemType;
import logic.Field;
import logic.GameState;
import test.base.GameTest;

public class TestDrill extends GameTest {
	Drill drill;
	private static final int TARGET_ENERGY_CONSUMPTION = 5;

	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		drill = new Drill();
		Field.instance.at(0, 0).placeBuildingOnCell(drill);
	}
	
	@Test
	void testOperate() {
		setUpElectricity();
		
		GameState.instance.update(4);
		
		assertElectricityConsumed(4 * TARGET_ENERGY_CONSUMPTION);
		
		assertTrue(drill.canProduceItem());
		assertEquals(ItemType.IRON, drill.getProducedItem().getType());
	}
}
