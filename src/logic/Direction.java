package logic;

public enum Direction {
	UP,
	DOWN,
	LEFT,
	RIGHT;
	
	public Direction reverse() {
		switch(this) {
		case DOWN:
			return UP;
		case LEFT:
			return RIGHT;
		case RIGHT:
			return LEFT;
		case UP:
			return DOWN;
		default:
			return null;
		}
	}
	
	public Direction rotateCW() {
		switch(this) {
		case DOWN:
			return LEFT;
		case LEFT:
			return UP;
		case RIGHT:
			return DOWN;
		case UP:
			return RIGHT;
		default:
			return null;
		}
	}
	
	public Direction rotateCCW() {
		return this.rotateCW().reverse();
	}
	
	@Override
	public String toString() {
		switch(this) {
		case DOWN:
			return "down";
		case LEFT:
			return "left";
		case RIGHT:
			return "right";
		case UP:
			return "up";
		default:
			return "??";
		}
	}
	
	public String toSymbol() {
		switch(this) {
		case DOWN:
			return "v";
		case LEFT:
			return "<";
		case RIGHT:
			return ">";
		case UP:
			return "^";
		default:
			return "?";
		}
	}
}
