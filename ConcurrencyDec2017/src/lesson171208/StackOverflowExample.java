package lesson171208;

public class StackOverflowExample {
	
	public static void main(String[] args) {
		
		x();
		
	}

	private static void x() {
		x();
	}

}
