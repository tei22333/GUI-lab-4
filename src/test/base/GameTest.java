package test.base;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import logic.Field;
import logic.GameState;

public class GameTest {
	
	private int initialElectricity;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		GameState.instance.reset();
		Field.instance.clearField();
		initialElectricity = 0;
	}
	
	protected void setUpElectricity(int amount) {
		GameState.instance.generateElectricity(amount);
		initialElectricity = amount;
	}
	
	protected void setUpElectricity() {
		this.setUpElectricity(1000);
	}
	
	protected void assertElectricityConsumed(int consumedAmount) {
		assertEquals(initialElectricity - consumedAmount, GameState.instance.getElectricity());
	}
}
