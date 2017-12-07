package lesson171207;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkerVersion3 {

	private BlockingQueue<MyFuture> tasks = new LinkedBlockingQueue<>();
	
	public WorkerVersion3() {
		new Thread(this::processTasks).start();
	}

	public MyFuture submit(Callable callable) {
			MyFuture task = new MyFuture(callable);
			tasks.offer(task);
			return task;
	}

	private void processTasks() {
		while (true) {
			MyFuture task;
			try {
				task = tasks.take();
				Object result = task.callable.call();
				task.setResult(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
