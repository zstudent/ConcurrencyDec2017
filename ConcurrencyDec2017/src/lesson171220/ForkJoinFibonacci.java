package lesson171220;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFibonacci {
	
	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool(4);
		
		long start = System.currentTimeMillis();
		Integer result = pool.invoke(new Fibonacci(40));
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed " + (stop -start));
		
		System.out.println(result);
		
	}

}

class Fibonacci extends RecursiveTask<Integer> {
	final int n;

	Fibonacci(int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {
		if (n <= 1)
			return n;
		Fibonacci f1 = new Fibonacci(n - 1);
		f1.fork();
		Fibonacci f2 = new Fibonacci(n - 2);
		return f1.join()  + f2.compute() ;
	}
}










