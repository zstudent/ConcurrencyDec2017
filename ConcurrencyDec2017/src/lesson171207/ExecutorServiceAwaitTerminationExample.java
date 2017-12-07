package lesson171207;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lesson171201.Utils;

public class ExecutorServiceAwaitTerminationExample {
	
	public static void main(String[] args)  {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		service.execute(()->{
			Utils.pause(1000);
			System.out.println("one");
		});
		
		service.execute(()->{
			Utils.pause(1000);
			System.out.println("two");
		});
		
		service.execute(()->{
			Utils.pause(1000);
			System.out.println("three");
		});
		
		service.shutdown();

		System.out.println("await for all tasks");
		
		try {
			boolean awaitTermination = service.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("finished all tasks");
	}

}
