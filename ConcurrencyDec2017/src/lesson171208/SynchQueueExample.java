package lesson171208;

import java.util.concurrent.SynchronousQueue;

import lesson171201.Utils;

public class SynchQueueExample {
	
	public static void main(String[] args) {
		
		SynchronousQueue<String>  queue = new SynchronousQueue<>();
		
		new Thread(()->{
			try {
				Utils.pause(30000);
				queue.put("hello");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		

		System.out.println("tyring to take");
		try {
			System.out.println(queue.take());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
