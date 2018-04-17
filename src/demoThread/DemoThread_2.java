package demoThread;

import java.util.ArrayList;
import java.util.List;

public class DemoThread_2 {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			list.add(i);
		}
			
		System.out.println(list.size());

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				list.remove(i);
			}
		});
		t1.start();

		Thread t2 = new Thread(() -> {
			for (int i = 101; i <= 200; i++) {
				list.remove(i);
			}
		});

		t2.start();

		t1.join();
		t2.join();

		System.out.println(list.size());
	}

}
