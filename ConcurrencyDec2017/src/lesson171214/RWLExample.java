package lesson171214;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLExample {

	private static final int THRESHHOLD = 10000;
	
	private static final class Reader implements Runnable {
		
		private RWDictionary dict;

		public Reader(RWDictionary dict) {
			this.dict = dict;
		}
		
		@Override
		public void run() {
			long count = 0;
			while (true) {
				String string = dict.get("hello");
				if (count++ % THRESHHOLD == 0) {
					System.out.println(Thread.currentThread() + " " + count);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Random r = new Random();
		
		RWDictionary dict = new RWDictionary();
		dict.put("hello", "world");
		
		Runnable writer = () -> {
			long count = 0;
			while (true) {
				dict.put("haha", "hoho");
				if (count++ % THRESHHOLD == 0) {
					System.out.println("writer :" + count);
				}
			}
		};
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 100; i++) {
			service.execute(new Reader(dict));
		}
		
		service.execute(writer);
	}

}

class RWDictionary {
	private final Map<String, String> m = new TreeMap<String, String>();
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true);
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	public String get(String key) {
		r.lock();
		try {
			return m.get(key);
		} finally {
			r.unlock();
		}
	}

	public String[] allKeys() {
		r.lock();
		try {
			return (String[]) m.keySet().toArray();
		} finally {
			r.unlock();
		}
	}

	public String put(String key, String value) {
		w.lock();
		try {
			return m.put(key, value);
		} finally {
			w.unlock();
		}
	}

	public void clear() {
		w.lock();
		try {
			m.clear();
		} finally {
			w.unlock();
		}
	}
}