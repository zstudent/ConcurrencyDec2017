package lesson171201;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * Elapsed: 12784  count = 8668241197  4 cpus
 * Elapsed: 10846  count = 7593623510  1 cpu
 */

public class LoadExample2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable task = () -> {
			double sum = 0;
			for (long i = 0; i < 1_000_000_000L; i++) {
				sum += i;
			}
			System.out.println(sum);
		};
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 10; i++) {
			service.execute(task);
		}
		
		long start = System.currentTimeMillis();
		
		service.shutdown();
		
		service.awaitTermination(1, TimeUnit.DAYS);
		
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed: " + (stop - start));
		
		
	}

}
