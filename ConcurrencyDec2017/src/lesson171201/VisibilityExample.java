package lesson171201;

public class VisibilityExample {
	
	static class Task implements Runnable {
		
		volatile boolean stop;

		@Override
		public void run() {
			
			long count = 0;
			
			while (!stop) {
				count++;
			}
			System.out.println(count);
		}
		
		public void shutdown() {
			stop = true;
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		Task task = new Task();
		new Thread(task).start();
		
		Utils.pause(3000);
		
		task.shutdown();
		
	}

}
