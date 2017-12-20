package lesson171220;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinExample1 {

	public static void main(String[] args) {
		
		double[] data = new double[10_000_000];
		
		ForkJoinPool pool = new ForkJoinPool(4);
		
		long start = System.currentTimeMillis();
		
		pool.invoke(new IncrementTask(data, 0, data.length - 1));
		
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed: " + (stop - start));
		
		System.out.println(Arrays.toString(Arrays.copyOfRange(data, 0, 10)));
		
	}
	
}

class IncrementTask extends RecursiveAction {
	
	static Random r = new Random();
	
	private static final int THRESHOLD = 1_000_000;
	final double[] array;
	final int lo, hi;

	IncrementTask(double[] array, int lo, int hi) {
		this.array = array;
		this.lo = lo;
		this.hi = hi;
	}

	protected void compute() {
		if (hi - lo < THRESHOLD) {
			for (int i = lo; i < hi; ++i)
				array[i] = Math.PI * r.nextDouble();
		} else {
			int mid = (lo + hi) >>> 1;
			invokeAll(new IncrementTask(array, lo, mid),
					new IncrementTask(array, mid, hi));
		}
	}
}