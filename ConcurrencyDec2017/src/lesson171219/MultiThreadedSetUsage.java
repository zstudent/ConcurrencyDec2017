package lesson171219;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MultiThreadedSetUsage {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
//		if (!set.contains("one")) {
//			set.add("one");
//		}
//		set.add("one");
		
		Set<String> set2 = Collections.synchronizedSet(set);
		
		set2.add("one");
		
		synchronized (set2) {
//			for (String string : set2) {
//				
//			}
			Iterator<String> iterator = set2.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
		
		
	}

}
