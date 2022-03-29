import java.util.Random;

public class Investor implements Runnable{
	private Buffer exchangeBuffer;
	private String name;
	private  float takeProfit;
	private float stopLoss;
	private boolean coin;
	private Random random;
	private float buyingPrice;
	
	Investor(Buffer exchangeBuffer, String name,  float takeProfit, float stopLoss){
		this.exchangeBuffer = exchangeBuffer;
		this.name = name;
		this.stopLoss = stopLoss;
		this.takeProfit = takeProfit;
		this.coin = false;
		random = new Random();
		
	}


	@Override
	public void run() {
			try {
				while(exchangeBuffer.checkLatestPrice()==-1 ||exchangeBuffer.checkLatestPrice() >=0 ){
					try {
				
					Thread.sleep(random.nextInt(1000));
					
					if(!coin && exchangeBuffer.checkLatestPrice() >=0) {
						buyingPrice = exchangeBuffer.getLatestPrice();
						Logger.displayState("[" + name + "]" + ", Bought at: " + buyingPrice);
						coin = true;
						
					}
					if(coin && exchangeBuffer.checkLatestPrice() >=0 ) {
						
						if(exchangeBuffer.checkLatestPrice()>= buyingPrice+ takeProfit ) {
							coin = false;
							Logger.displayState("[" + name + "]" + " Take profit at: " + (buyingPrice + takeProfit) + ", "
									+ "Bought at: " + buyingPrice + ", Sold at: " + exchangeBuffer.checkLatestPrice() + 
									", Profit: " + (exchangeBuffer.checkLatestPrice() - buyingPrice));
							
						}
						
						if(exchangeBuffer.checkLatestPrice()<= buyingPrice- stopLoss) {
							coin = false;
							Logger.displayState("[" + name + "]" + " Stop loss at " + (buyingPrice - stopLoss) + ", "
									+ "Bought at: " + buyingPrice + ", Sold at: " + exchangeBuffer.checkLatestPrice() + 
									", Loss: " + (exchangeBuffer.checkLatestPrice() - buyingPrice));
						}

						
					}
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	}
}
