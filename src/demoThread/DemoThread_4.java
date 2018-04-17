package demoThread;

import java.util.ArrayList;
import java.util.List;

public class DemoThread_4 {

	public static void main(String[] args) {
		Util2 util = new Util2();
//		new Thread(()->util.m1()).start();
//		new Thread(()->util.m2()).start();
		synchronized(new Object())
		{
			new Thread(new Runnable() {
				public void run()
				{
					util.m1();
				}
			}).start();
			new Thread(new Runnable() {
				public void run()
				{
					util.m2();
				}
			}).start();
		}
		
	}
}

//if one is doing a write function, no other thread should be able to write or read
class Util2
{
		Object obj = new Object();
		List<Integer> list = new ArrayList<>();
	
	public void m1()
	{
		for(int i =0;i <200;i++)
		{
			
				list.add(i);
				System.out.println("write the list "+ i);
		}
		
	}
	
	public void m2()
	{
		
			for(int i=0;i<list.size();i++)
			{
				System.out.println("read the list ...."+ i);
			}
	}

	
}


class Util
{
	int x = 0;
	
	public void m1()
	{
		int sum=0;
		for(int i =0;i<100;i++)
		{
			x++;
			System.out.println(Thread.currentThread().getName()+": "+ x);
		}
	}
	
	public void m2()
	{
		for(int i=0;i<100;i++)
		{
			x=x*2;
			System.out.println(Thread.currentThread().getName()+": "+ x);
		}
	}
}

class Util1
{
	volatile boolean isValid  = true; // what volatile do to multithread application
	
	public void m1()
	{
		for(int i =0;i <200;i++)
		{
			System.out.println(i);
		}
		isValid = false;
	}
	
	public void m2()
	{
		int count = 1;
		while(isValid)
		{
			System.out.println("I'm in m2 ...."+ count++);
		}
	}
	
}


