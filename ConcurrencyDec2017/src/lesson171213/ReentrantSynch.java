package lesson171213;

public class ReentrantSynch {
	
	static int count;

	public static void main(String[] args) {
		
		a();
		
	}

	private static void a() {
		synchronized (ReentrantSynch.class) {
			if (count++ == 5) {
				System.out.println("it's enough");
				return;
			}
			a();
		}
	}
	
}
