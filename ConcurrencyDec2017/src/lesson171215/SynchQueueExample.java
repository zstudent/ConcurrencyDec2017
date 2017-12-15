package lesson171215;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

import lesson171201.Utils;

public class SynchQueueExample {

	public static void main(String[] args) {
		
		SynchronousQueue<String> q = new SynchronousQueue<>();

		Runnable cook = () -> {
			while (true) {
				Utils.pause(1000);
				String dish = "steak";
				try {
					q.put(dish);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable waiter = () -> {
			while (true) {
				String dish;
				try {
					dish = q.take();
					Utils.pause(1000);
					System.out.println("Deliver " + dish);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		ExecutorService service = Executors.newFixedThreadPool(2);

	}

}
