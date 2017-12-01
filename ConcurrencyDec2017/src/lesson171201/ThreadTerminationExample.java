package lesson171201;

public class ThreadTerminationExample {
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(() -> {
			while (true) {
//				try {
//					Thread.sleep((long) 1000);
//				} catch (Exception e) {
//					return;
//				}
				System.out.println("hello");
			}
		});
		thread.start();
		
		Utils.pause(5000);
		
		thread.interrupt();
		
	}

}
