package lesson171219;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lesson171201.Utils;

public class ListExample {
	
	public static void main(String[] args) {
		
		List<String> list = new CopyOnWriteArrayList<String>();
		
		for (int i = 0; i < 100; i++) {
			list.add(Integer.toString(i));
		}
		
		new Thread(()-> {
			while (true) {
				Utils.pause(100);
				list.remove(0);
				System.out.println("size = " + list.size());
			}
		}).start();
		
		for (String number : list) {
			Utils.pause(500);
			System.out.println(number);
		}
		
	}

}
