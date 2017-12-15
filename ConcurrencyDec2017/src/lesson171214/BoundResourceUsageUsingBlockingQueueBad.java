package lesson171214;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lesson171201.Utils;

public class BoundResourceUsageUsingBlockingQueueBad {

	private static final int MAX = 10_000_000;

	public static void main(String[] args) {

		ExecutorService service = new ThreadPoolExecutor(1, 1, 0L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(5),
				(r, executor) -> System.out.println("rejected " + r));

		while (true) {
			int[] data = new int[MAX];

			service.execute(() -> {
				int[] internalData = data;
				int sum = 0;
				for (int i = 0; i < data.length; i++) {
					sum += internalData[i];
				}
				System.out.println(sum);
				Utils.pause(100);
			});
		}

	}

}
