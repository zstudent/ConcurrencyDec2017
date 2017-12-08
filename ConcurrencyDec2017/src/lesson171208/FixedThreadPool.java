package lesson171208;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lesson171201.Utils;

public class FixedThreadPool {
	
	public static void main(String[] args) {
		
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(availableProcessors);
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.execute(()->{
			System.out.println("one");
			Utils.pause(1000);
		});
		service.execute(()->{
			System.out.println("two");
			Utils.pause(1000);
		});
		
		service.execute(()->{
			System.out.println("three");
			Utils.pause(1000);
		});
		service.execute(()->{
			System.out.println("four");
			Utils.pause(1000);
		});
		
		service.execute(()->{
			System.out.println("five");
			Utils.pause(1000);
		});
		service.execute(()->{
			System.out.println("six");
			Utils.pause(1000);
		});
		
		
	}

}
