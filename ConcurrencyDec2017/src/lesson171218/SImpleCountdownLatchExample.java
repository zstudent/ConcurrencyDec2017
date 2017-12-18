package lesson171218;

import java.util.concurrent.CountDownLatch;

import lesson171201.Utils;

public class SImpleCountdownLatchExample {
	
	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		Runnable target = ()-> {
			System.out.println("waiting for signal");
			try {
				latch.await();
				while (true) {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		new Thread(target).start();
		new Thread(target).start();
		new Thread(target).start();
		
		
		Utils.pause(3000);
		System.out.println("one");
		latch.countDown();
		Utils.pause(3000);
		System.out.println("two");
		latch.countDown();
		Utils.pause(3000);
		System.out.println("three!");
		latch.countDown();
		
	}

}
