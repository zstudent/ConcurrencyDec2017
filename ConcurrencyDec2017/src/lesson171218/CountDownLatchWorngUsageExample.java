package lesson171218;

import java.util.concurrent.CountDownLatch;

import lesson171201.Utils;

public class CountDownLatchWorngUsageExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		CountDownLatch latch = new CountDownLatch(1);
		
		
		new Thread(()->{
			try {
				latch.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("haha");
		}).start();

		Utils.pause(1000);
		
		latch.countDown();
		
		latch.countDown();

		latch.countDown();
		
		
	}

}
