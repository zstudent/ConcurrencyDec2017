package lesson171211;

public class UseMyScheduledExecutor {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		MyScheduledExecutor ex = new MyScheduledExecutor();
		
		ex.schedule(()->{
			System.out.println("one");
		}, 5000);
		
		ex.schedule(()->{
			System.out.println("pre-one");
		}, 3000);
		
	}

}
