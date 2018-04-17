package demoThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoThread_3 {
	public static void main(String[] args) throws InterruptedException  {

		List<Integer> list = new ArrayList<>();
		
		for(int i =0; i<=2100;i++)
		{
			list.add(i);
		}
		
		System.out.println(list.size());
		
		Thread t1 = new Thread(()->{
			Iterator<Integer> it = list.iterator();
			int i =0;
			while(it.hasNext() && i<=1000)
			{
				it.next();
				it.remove();
				i++;
//				int j = it.next();
//				list.remove(j);
//				i++;
			}
		});
		t1.start();
		
		Thread t2 = new Thread(()->{
			Iterator<Integer> it = list.iterator();
			int i =0;
			while(it.hasNext() && i<=1000)
			{
				it.next();
				it.remove();
				i++;
//				int j = it.next();
//				list.remove(j);
//				i++;
//				do not use iterator to modify the collection
			}
		});
		t2.start();
		
		t1.join();
//		t2.join();
		System.out.println(list.size());
	
}
}
