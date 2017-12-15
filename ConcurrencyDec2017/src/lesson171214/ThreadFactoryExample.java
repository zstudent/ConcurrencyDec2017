package lesson171214;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lesson171201.Utils;

public class ThreadFactoryExample {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newSingleThreadExecutor(r -> {
			Thread thread = new Thread(r, "myThread");
			thread.setDaemon(true);
			return thread;
		});
		
		service.execute(() -> {
			System.out.println("hello");
		});
		
		Utils.pause(1000);
		
	}

}
