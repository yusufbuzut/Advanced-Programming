package component;

public class CPU extends Component{
	protected double frequency;
	protected double numTransistors;
	protected double productionCost;
	protected double profitRate;
	
	
	public CPU(double frequency, double numTransistors) {
		this.frequency = frequency;
		this.numTransistors = numTransistors;
		this.productionCost = productionCost();
		this.profitRate = profitRate();
		
	}
	public double getFrequency() {
		return frequency;
	}
	public double getNumTransistors() {
		return numTransistors;
	}
	@Override
	public String toString() {
		return "frequency=" + getFrequency()+ ", numTransistors=" + getNumTransistors() + ", price=" + String.format("%.2f", price());
	}
	@Override
	double productionCost() {
		return frequency*50;
	}
	@Override
	double profitRate() {
		if (frequency > 2.4) {
			this.profitRate = 0.3;
		}
		else {
			this.profitRate = 0.2;
		}
		return profitRate;
	}
}
