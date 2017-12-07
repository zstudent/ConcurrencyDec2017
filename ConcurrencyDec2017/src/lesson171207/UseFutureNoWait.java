package lesson171207;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lesson171201.Utils;

public class UseFutureNoWait {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Future<?> task = service.submit(() -> {
			Utils.pause(10000);
		});

		service.shutdown();
		
		while (!task.isDone()) {
			System.out.println("not ready yet");
			Utils.pause(1000);
		}
		
		System.out.println("done!");
		
		
		
	}

}
