package ui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import ui.field.FieldUI;
import ui.toolbar.Toolbar;

public class UIRoot extends HBox {	
	public UIRoot() {
		super();
		
		FieldUI fieldUI = new FieldUI();
		setHgrow(fieldUI, Priority.ALWAYS);
		this.getChildren().add(fieldUI);
		this.getChildren().add(new Toolbar());
	}
}
