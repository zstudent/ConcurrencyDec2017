package lesson171207;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lesson171201.Utils;

public class UseFutureCancel {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
//		service.execute(()-> {
//			Utils.pause(1000);
//		});
		
		Future<?> task = service.submit(() -> {
			while (!Thread.interrupted()) {}
		});
		
		Utils.pause(1000);
		
		System.out.println("try cancel");
		
		boolean success = task.cancel(true);

		System.out.println(success);
		
		System.out.println("done!");
		
		service.shutdown();
		
		
		
	}

}
