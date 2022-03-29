
public class SyncBuffer implements Buffer {
	private float buffer = -1;
	private boolean occupied = false;
	@Override
	public synchronized void addLatestPrice(float value) throws InterruptedException {
		
		while(occupied) {
			
			wait();
		}
		buffer = value;
		occupied = true;
		notifyAll();
	}

	@Override
	public synchronized float getLatestPrice() throws InterruptedException {
		while(!occupied) {
			
			wait();
		}
		
		occupied = false;
		notifyAll();
		return buffer;
	}

	@Override
	public synchronized float checkLatestPrice() throws InterruptedException {
		
		if(occupied == true) {
			return buffer;
		}
		
		return -1;
		
	}
}
