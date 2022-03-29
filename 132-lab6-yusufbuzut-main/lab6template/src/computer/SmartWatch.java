package computer;
import component.*;
public class SmartWatch extends Computer{
	protected int buckleCost;
	
	public SmartWatch(CPU cpu, Display display, String modelName, int buckleCost) {
		this.cpu = cpu;
		this.display = display;
		this.modelName = modelName;
		this.buckleCost = buckleCost;
	}
	@Override
	public 
	boolean isWearable() {
		return true;
	}
	@Override
	public
	boolean isPortable() {
		return true;
	}
	@Override
	public double price() {
		return cpu.price() + display.price()+ buckleCost;
	}
	@Override
	public String toString() {
		return "SmartWatch:\n- buckleCost=" + getBuckleCost() + "\n- modelName=" + getModelName() + "\n- cpu=" + getCpu() + "\n- display=" + getDisplay() + "\n- price=" + String.format("%.2f", price());
	}
	public int getBuckleCost() {
		return buckleCost;
	}
}
