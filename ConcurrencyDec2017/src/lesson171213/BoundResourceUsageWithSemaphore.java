package lesson171213;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lesson171201.Utils;

public class BoundResourceUsageWithSemaphore {

	private static final int MAX = 10_000_000;

	public static void main(String[] args) {

		Semaphore sem = new Semaphore(5);

		ExecutorService service = Executors.newFixedThreadPool(1);

		while (true) {
			int[] data = new int[MAX];

			sem.acquireUninterruptibly();
			service.execute(() -> {
				try {
					int[] internalData = data;
					int sum = 0;
					for (int i = 0; i < data.length; i++) {
						sum += internalData[i];
					}
					System.out.println(sum);
					Utils.pause(100);
				} finally {
					sem.release();
				}
			});
		}

	}

}
