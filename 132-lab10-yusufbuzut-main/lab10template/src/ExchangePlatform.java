import java.util.Random;

public class ExchangePlatform implements Runnable {
	private Buffer exchangeBuffer;
	private float midPrice; 
	private float variance;
	private float latestPrice;	
	private Random generator;
	
	public ExchangePlatform(Buffer exchangeBuffer, float midPrice, float variance) {
		this.midPrice = midPrice;
		this.exchangeBuffer = exchangeBuffer;
		this.variance = variance;
		this.generator = new Random();
	}
	
	

	@Override
	public void run() {
		   for(int i=0; i <10; i++) {
			  try {
				
				Thread.sleep(generator.nextInt(2000));
				latestPrice = midPrice - variance + 2 * variance * generator.nextFloat();
				
				exchangeBuffer.addLatestPrice(latestPrice);
				Logger.displayState("Latest price set by the crypto exchange platform: " + latestPrice);
			  } 
			  catch (InterruptedException e) {
				
				e.printStackTrace();
			  }
			  
			  

		  }
		   
	}
	
}
