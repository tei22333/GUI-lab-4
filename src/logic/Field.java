package logic;

import java.util.ArrayList;
import java.util.List;

import building.base.Building;

public class Field {
	public static final int FIELD_WIDTH = 10;
	public static final int FIELD_HEIGHT = 10;
	
	public static final Field instance = new Field();
	
	private List<List<Cell>> field;
	
	private int currentY;
	private int currentX;
	
	private Field() {
		field = new ArrayList<List<Cell>>();
		for(int i=0; i < FIELD_HEIGHT; i++) {
			List<Cell> currentRow = new ArrayList<Cell>();
			for(int j=0; j<FIELD_WIDTH; j++) {
				currentRow.add(Cell.normalCell());
			}
			field.add(currentRow);
		}	
	}
	
	public Cell at(int x, int y) {
		return this.field.get(y).get(x);
	}
	
	public Building getBuildingInFront(Direction direction) {
		int x = this.currentX;
		int y = this.currentY;
		switch(direction) {
		case UP: 
			y -= 1;
			break;
		case DOWN:
			y += 1;
			break;
		case LEFT:
			x -= 1;
			break;
		case RIGHT:
			x += 1;
			break;
		default:
			break;
		}
		
		if(x < 0 || y < 0 || y >= FIELD_HEIGHT || x >= FIELD_WIDTH) {
			return null;
		}
		
		return this.at(x, y).getBuildingOnCell();
	}
	
	public Building getBuildingInBack(Direction direction) {
		return getBuildingInFront(direction.reverse());
	}
	
	public void clearField() {
		for(int i=0; i < FIELD_HEIGHT; i++) {
			for(int j=0; j<FIELD_WIDTH; j++) {
				this.at(i, j).clearBuildingOnCell();
			}
		}
	}
	
	public void update() {
		for(int i=0; i < FIELD_HEIGHT; i++) {
			currentY = i;
			List<Cell> currentRow = field.get(currentY);
			for(int j=0; j<FIELD_WIDTH; j++) {
				currentX = j;
				this.at(currentX, currentY).update();
			}
			field.add(currentRow);
		}
	}
	
	public void beforeCycle() {
		for(int i=0; i < FIELD_HEIGHT; i++) {
			currentY = i;
			List<Cell> currentRow = field.get(currentY);
			for(int j=0; j<FIELD_WIDTH; j++) {
				currentX = j;
				this.at(currentX, currentY).beforeCycle();
			}
			field.add(currentRow);
		}
	}

}
