package lesson171215;

import java.util.Arrays;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

import lesson171201.Utils;

public class ExchangerExample {

	public static void main(String[] args) {
		
		Exchanger<String[]> q = new Exchanger<>();
		String[] dish1 = new String[3];
		String[] dish2 = new String[3];

		Runnable cook = () -> {
			String[] buffer = dish1;
			while (true) {
				Utils.pause(1000);
				try {
					
					for (int i = 0; i < dish1.length; i++) {
						buffer[i] = Integer.toString(i);
					}
					buffer = q.exchange(buffer);
					System.out.println(Arrays.toString(buffer));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable waiter = () -> {
			String[] buffer = dish2;
			while (true) {
				try {
					buffer = q.exchange(buffer);
					Utils.pause(1000);
					System.out.println("Deliver " + Arrays.toString(buffer));
					Arrays.fill(buffer, "");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.execute(cook);
		service.execute(waiter);

	}

}
