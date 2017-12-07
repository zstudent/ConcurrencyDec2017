package lesson171207;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lesson171201.Utils;

public class UseFuture {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Future<String> task = service.submit(() -> {
			Utils.pause(3000);
			int x = 10 / 0;
			return "one";
		});
		
		String result;
		try {
			result = task.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println(e.getCause());
		}
		
		service.shutdown();
		
		
	}

}
