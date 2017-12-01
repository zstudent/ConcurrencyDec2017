package lesson171130;

public class Example5 {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("start");
		
		Thread t = new Thread(()->{
			int i = 0;
			while (true) {
				System.out.println(i++);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		t.setDaemon(true);
		
		t.start();
		
		Thread.sleep(5000);
		
	}

}
