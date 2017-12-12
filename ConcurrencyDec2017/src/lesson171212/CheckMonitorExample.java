package lesson171212;

import lesson171201.Utils;

public class CheckMonitorExample {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		Object mutex = new Object();
		
		Thread thread = new Thread(()->{
			Utils.pause(1000);
			synchronized (mutex) {
				System.out.println("hi there!");
			}
		});
		thread.start();
		
		synchronized (mutex) {
			Utils.pause(2000);
			thread.stop();
			while(true) {}
		}
		
	}

}
