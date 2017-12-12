package lesson171211;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
	
	public static void main(String[] args) {
		
		ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);
		
		ex.schedule(()->{
			System.out.println("one");
		}, 5000, TimeUnit.MILLISECONDS);
		
		ScheduledFuture<?> schedule = ex.schedule(()->{
			System.out.println("pre-one");
		}, 3000, TimeUnit.MILLISECONDS);
		
		ex.scheduleAtFixedRate(()->{
			System.out.println("Hello");
		}, 0, 1, TimeUnit.SECONDS);

		
		ex.scheduleWithFixedDelay(()->{
			System.out.println("Hello");
		}, 0, 1, TimeUnit.SECONDS);
		
		
	}

}
