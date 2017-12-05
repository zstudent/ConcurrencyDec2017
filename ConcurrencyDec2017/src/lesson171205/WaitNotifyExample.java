package lesson171205;

import lesson171201.Utils;

public class WaitNotifyExample {

	public static void main(String[] args) {

		Object mutex = new Object();

		Thread thread = new Thread(() -> {
			System.out.println("before");
			synchronized (mutex) {
				try {
					mutex.wait();
					System.out.println("woke up");
				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
			}
			System.out.println("after");
		});
		thread.start();
		
		Utils.pause(2000);
		System.out.println("signal");
		
		synchronized (mutex) {
			mutex.notify();
			Utils.pause(2000);
		}
		
//		thread.interrupt();

	}

}
