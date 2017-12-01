package lesson171130;

public class Example4 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread();
		
		System.out.println(t.getState());
		
		t.start();
		
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		
		System.out.println(t.getState());
		
		t.join();
		
		System.out.println(t.getState());
	}

}
