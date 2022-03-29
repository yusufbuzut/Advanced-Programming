package component;

public class Display extends Component {
	protected int width;
	protected int  height;
	protected String resolution;
	protected double productionCost;
	private final double productionCostPerPixel = 0.0001;
	protected double profitRate = profitRate();
	
	
	public Display(int width, int height) {
		this.height = height;
		this.width = width;
		this.resolution = width+ "x" + height;
		this.productionCost = productionCost();
	}
	@Override
	public String toString() {
		return "width=" + getWidth()+ ", height=" + getHeight() + ", resolution=" + getResolution()
				+ ", productionCostPerPixel=" + productionCostPerPixel + ", productionCost=" + String.format("%.2f", productionCost()) + ", price=" + String.format("%.2f", price());
	}
	@Override
	double productionCost() {
		return productionCostPerPixel*width*height;
	}
	@Override
	double profitRate() {
		return 0.25;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getResolution() {
		return resolution;
	}
}
