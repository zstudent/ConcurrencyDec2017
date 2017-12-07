package lesson171207;

import lesson171201.Utils;

public class UseWorkerVersion3 {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		WorkerVersion3 w = new WorkerVersion3();
		
		MyFuture task = w.submit(() -> {
			Utils.pause(300000);
			return "one";
		});
		
		Object result = task.get();
		
		System.out.println(result);
		
	}

}
