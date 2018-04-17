package demoThread;

import java.util.ArrayList;
import java.util.List;

public class DemoThread_1 {

	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> list = new ArrayList<>(4000);
		
		System.out.println(list.size());
		
		Thread t1 = new Thread(()->{
			for(int i =0; i<1000;i++)
			{
				list.add(i);
			}
		});
		t1.start();
		
		
		Thread t2 = new Thread(()->{
			for(int i = 1001; i<=2000;i++)
			{
				list.add(i);
			}
		});
		
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(list.size());
	}
}
