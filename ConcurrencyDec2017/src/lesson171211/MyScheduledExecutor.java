package lesson171211;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;

public class MyScheduledExecutor {

	static class DelayedRunnable implements Comparable<DelayedRunnable> {
		Runnable task;
		long timestamp;

		@Override
		public int compareTo(DelayedRunnable o) {
			return (int) (this.timestamp - o.timestamp);
		}
	}

	PriorityBlockingQueue<DelayedRunnable> pq = new PriorityBlockingQueue<>();

	ExecutorService executor = Executors.newSingleThreadExecutor();

	private Future<?> futureDelayedTask;

	public void schedule(Runnable runnable, int millis) {
		DelayedRunnable delayedTask = new DelayedRunnable() {
			{
				task = runnable;
				timestamp = millis + System.currentTimeMillis();
			}
		};
		pq.add(delayedTask);

		if (pq.peek() != delayedTask) {
			return;
		}

		if (futureDelayedTask != null) {
			futureDelayedTask.cancel(true);
			futureDelayedTask = null;
		}

		submitDelayedTask(delayedTask);

	}

	public void submitDelayedTask(DelayedRunnable delayedTask) {
		futureDelayedTask = executor.submit(() -> {
			try {

				long delay = delayedTask.timestamp - System.currentTimeMillis();

				if (delay > 0) {
					Thread.sleep(delay);
				}

				DelayedRunnable dTask = pq.poll();
				
				if (dTask == null) {
					return;
				}

				try {
					dTask.task.run();
				} finally {
					DelayedRunnable next = pq.peek();
					submitDelayedTask(next);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
