package ui.field;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.StackPane;
import logic.Cell;
import ui.GameRunner;

public class CellUI extends StackPane implements Observer {
	private Cell state;
	
	public CellUI(Cell cell) {
		super();
		
		this.state = cell;
				
		this.setStyle("-fx-border-width: 1px;");
		this.setStyle("-fx-border-color: pink;");
		
		GameRunner.instance.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.getChildren().clear();
		this.state.render(this);
	}
		
	@Override
	protected void finalize() throws Throwable {
		GameRunner.instance.deleteObserver(this);
		super.finalize();
	}
}
