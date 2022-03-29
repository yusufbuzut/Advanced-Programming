import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {
	private ArrayBlockingQueue<Float> buffer;
	
	public BlockingBuffer() {
		buffer = new ArrayBlockingQueue<Float>(1);
	}
	@Override
	public void addLatestPrice(float value) throws InterruptedException {
		buffer.put(value);
		
	}

	@Override
	public float getLatestPrice() throws InterruptedException {
		// TODO Auto-generated method stub
		float value = buffer.take();
		 
		return value;
	}

	@Override
	public float checkLatestPrice() throws InterruptedException {
		// TODO Auto-generated method stub
		if (buffer.peek() == null) {
			return -1; 
		}
		
		return buffer.peek();
	
	}

}
