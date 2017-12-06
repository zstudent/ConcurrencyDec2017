package lesson171206;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lesson171201.Utils;

public class ExecutorServiceTestDrive {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		service.execute(()->{
//			Utils.pause(1000);
//			System.out.println("one");
			
			while (true) {
				System.out.println("haha");
			}
		});
		
		service.execute(()->{
			Utils.pause(1000);
			System.out.println("two");
		});
		
		service.execute(()->{
			Utils.pause(1000);
			System.out.println("three");
		});
		
		List<Runnable> tasksFromQueue = service.shutdownNow();
		
		Utils.pause(1000);
		
		for (Runnable runnable : tasksFromQueue) {
			System.out.println(runnable);
		}
		
	}

}
