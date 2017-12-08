package lesson171208;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lesson171201.Utils;

public class CachedThreadPoolExample {
	
	public static void main(String[] args) {
		
//		ExecutorService service = Executors.newSingleThreadExecutor();
		

		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println(service.getClass());

		while (true) {
			service.execute(()-> {
				long count = 0;
				while (count < 10_000_000L) {
					count++;
				}
				System.out.println(Thread.currentThread());
			});
			Utils.pause(1);
		}
		
		
		
		
	}

}
