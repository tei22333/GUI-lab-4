package logic;

import building.base.Building;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Cell {
	public enum Type {
		NORMAL,
		WOOD,
		IRON
	}
	
	private Type type;
	private Building buildingOnCell;
	
	
	public Cell(Type type) {
		this.type = type;
		this.buildingOnCell = null;
	}
	
	public void placeBuildingOnCell(Building building) {
		if(this.buildingOnCell == null) {
			this.buildingOnCell = building;
		}
	}
	
	public void clearBuildingOnCell() {
		this.buildingOnCell = null;
	}
	
	public void update() {
		if(this.buildingOnCell != null) {
			this.buildingOnCell.operate();
		}
	}
	
	public void beforeCycle() {
		if(this.buildingOnCell != null) {
			this.buildingOnCell.beforeCycle();
		}
	}
	
	public void render(StackPane target) {
		if(this.buildingOnCell != null) {
			this.buildingOnCell.render(target);
		}
		Label typeLabel = new Label("         ");
		StackPane.setAlignment(typeLabel, Pos.BOTTOM_CENTER);
		target.getChildren().add(typeLabel);
	}
	
	/* getters & setters */
	
	public Building getBuildingOnCell() {
		return this.buildingOnCell;
	}
	
	public Type getType() {
		return this.type;
	}
	
	/* factory functions */
	public static Cell normalCell() {
		return new Cell(Type.NORMAL);
	}
	
	public static Cell ironCell() {
		return new Cell(Type.IRON);
	}
	
	public static Cell woodCell() {
		return new Cell(Type.WOOD);
	}
}
