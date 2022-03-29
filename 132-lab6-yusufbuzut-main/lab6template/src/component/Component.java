package component;

import main.SaleItem;

public abstract class Component implements SaleItem {
	abstract double productionCost();
	abstract double profitRate();
	
	@Override
	public double price() { 
		return productionCost() * (1 + profitRate()); 
	} 
	
}
