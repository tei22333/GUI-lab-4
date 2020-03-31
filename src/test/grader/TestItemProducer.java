package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;

public class TestItemProducer {
	@Test
	void testItemProducerMethods() {
		assertDoesNotThrow(() -> {
			ItemProducer.class.getMethod("canProduceItem");
			Method getProducedItem = ItemProducer.class.getMethod("getProducedItem");
			assertEquals(Item.class, getProducedItem.getReturnType());
		});
	}
	
	void testItemReceiverMethods() {
		assertDoesNotThrow(() -> {
			ItemReceiver.class.getMethod("canReceiveItem");
			ItemProducer.class.getMethod("canReceiveItem", ItemType.class);
		});

	}
}
