package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import building.Sawmill;
import logic.Field;
import logic.GameState;
import test.base.GameTest;

public class TestSawmill extends GameTest {
	
	Sawmill sawmill;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		sawmill = new Sawmill();
		Field.instance.at(0, 0).placeBuildingOnCell(sawmill);
	}
	
	@Test
	void testOperate() {
		assertFalse(sawmill.canProduceItem());
		GameState.instance.update(3);
		assertTrue(sawmill.canProduceItem());
	}	
}
