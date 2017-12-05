package lesson171204;

import lesson171201.Utils;

public class EvilSynchronizedExample {
	
	static int count = 0;
	
	static class Task implements Runnable {
		
		final private Object mutex = new Object();

		@Override
		public void run() {
			synchronized (mutex) {
				count++;
				System.out.println(count);
			}
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("start");
		
		Runnable task = new Task();
		
		new Thread(() -> {
			Utils.pause(1000);
			task.run();
		}).start();

		synchronized (task) {
			Thread.sleep(10000000000000000L);
		}
		
		
	}

}
