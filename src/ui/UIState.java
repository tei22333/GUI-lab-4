package ui;

import java.util.Observable;

import building.base.Building;
import logic.Cell;

public class UIState extends Observable {
	public static final UIState instance = new UIState();
	
	private Building selectedBuilding = null;

	public Building getSelectedBuilding() {
		return this.selectedBuilding;
	}
	
	private Cell selectedCell = null;
	
	public void setSelectedCell(Cell cell) {
		this.selectedCell = cell;
		this.setChanged();
		this.notifyObservers();
	}
	
	public Cell getSelectedCell() {
		return this.selectedCell;
	}

	public void setSelectedBuilding(Building building) {
		this.selectedBuilding = building;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void clearSelectedBuilding() {
		this.setSelectedBuilding(null);
	}
}
