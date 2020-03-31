package building.base;

import javafx.scene.layout.StackPane;

public abstract class Building {
	public abstract void operate();
	public abstract void render(StackPane target);
	public void beforeCycle() {};
}
