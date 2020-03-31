package ui.toolbar;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import ui.toolbar.submenus.ChestInfo;
import ui.toolbar.submenus.ControlBar;
import ui.toolbar.submenus.ElectricityMeter;
import ui.toolbar.submenus.StatusBar;
import ui.toolbar.submenus.build.BuildMenu;

public class Toolbar extends VBox {
	
	private static final double TOOLBAR_WIDTH = 350;
	
	public Toolbar() {
		super();
		
		ChestInfo ci = new ChestInfo();
		setVgrow(ci, Priority.ALWAYS);
		
		this.getChildren().addAll(
				new BuildMenu(),
				new ElectricityMeter(),
				new ControlBar(),
				new StatusBar(),
				ci
			);
		
		this.setMinWidth(TOOLBAR_WIDTH);
		
		this.setStyle("-fx-border-width: 1px;");
		this.setStyle("-fx-border-color: red;");
	}
}
