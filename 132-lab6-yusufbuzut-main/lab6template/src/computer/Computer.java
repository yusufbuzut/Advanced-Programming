package computer;



import component.*;
import main.SaleItem;


public abstract class Computer implements SaleItem {
	public String getModelName() {
		return modelName;
	}
	public Component getCpu() {
		return cpu;
	}
	public Component getDisplay() {
		return display;
	}
	protected String modelName;
	protected Component cpu;
	protected Component display;
	
	
	@Override
	public double price() {
		return cpu.price() + display.price(); 
	} 
	public abstract boolean isWearable();
	public abstract boolean isPortable();
}
