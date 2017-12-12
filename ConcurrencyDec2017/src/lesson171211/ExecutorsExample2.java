package lesson171211;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample2 {
	
	public static void main(String[] args) {
		
		ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);
		ExecutorService worker = Executors.newFixedThreadPool(2);
		
		ex.schedule(()->{
			worker.execute(()->{System.out.println("one");});
		}, 5000, TimeUnit.MILLISECONDS);
		
		ScheduledFuture<?> schedule = ex.schedule(()->{
			worker.execute(()->{System.out.println("pre-one");});
		}, 3000, TimeUnit.MILLISECONDS);
		
		ex.scheduleAtFixedRate(()->{
			worker.execute(()->{System.out.println("Hello");});
		}, 0, 1, TimeUnit.SECONDS);

		
		ex.scheduleWithFixedDelay(()->{
			worker.execute(()->{System.out.println("Bello");});
		}, 0, 1, TimeUnit.SECONDS);
		
		
	}

}
