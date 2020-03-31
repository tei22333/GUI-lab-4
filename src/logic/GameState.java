package logic;

public class GameState {
	
	public static final GameState instance = new GameState();
	
	private int cycles;
	private int electricity;
	
	private GameState() {
		this.cycles = 0;
		this.electricity = 0;
	}
	
	public void generateElectricity(int amount) {
		this.electricity += amount;
	}
	
	public boolean consumeElectricity(int amount) {
		if(this.electricity >= amount) {
			this.electricity -= amount;
			return true;
		}
		
		return false;
	}
	
	public void reset() {
		this.cycles = 0;
		this.electricity = 0;
	}
	
	public void update() {
		Field.instance.beforeCycle();
		Field.instance.update();
		this.cycles++;
	}
	
	public void update(int cycles) {
		for(int i=0; i<cycles; i++) {
			this.update();
		}
	}
	

	public int getCycles() {
		return this.cycles;
	}
	

	public int getElectricity() {
		return electricity;
	}
}
