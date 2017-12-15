package lesson171214;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lesson171201.Utils;

public class BoundResourceUsageUsingBlockingQueueGood {

	private static final int MAX = 10_000_000;

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(2);

		BlockingQueue<int[]> queue = new LinkedBlockingQueue<>(5);

		Runnable task = () -> {
			while (true) {
				int[] data;
				try {
					data = queue.take();
					int sum = 0;
					for (int i = 0; i < data.length; i++) {
						sum += data[i];
					}
					System.out.println(sum);
					Utils.pause(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		service.execute(task);
		service.execute(task);

		while (true) {
			int[] data = new int[MAX];
			try {
				queue.put(data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
