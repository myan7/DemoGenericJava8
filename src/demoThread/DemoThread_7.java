package demoThread;

import java.util.ArrayList;
import java.util.List;

public class DemoThread_7 {

	public static void main(String[] args) {
		
		
	Ticket t = new Ticket();
	Thread t1 = new Thread(t,"Synchronized Block");
	Thread t2 = new Thread(t,"Method");
	t1.start();
		try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
	t.flag=false;
	t2.start();
	}
}

class Ticket implements Runnable
{
	private int ticket = 100;
	boolean flag = true;
	
	@Override
	public void run() 
	{
		if(flag)
		{
			while(ticket>0)
			{
				synchronized(new Object())
				{
					try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
					System.out.println(Thread.currentThread().getName() + " this is from synchronized block... " + ticket-- );
				}
			}
		}
		else
		{
			while(ticket>0)
			{
				method();
			}
		}
	}
	
	public synchronized void method()
	{
		if(ticket>0)
		{
			try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println(Thread.currentThread().getName() + " this is from synchronized METHOD... " + ticket-- );
		}
	}
}

class Pool implements Runnable
{
	int i =0;
	List<Integer> list = new ArrayList<>();
	boolean flag = true;
	
	@Override
	public void run() 
	{
		if(flag)
		{
			for(int c =0;c<200;c++)
			{
				synchronized(this)
				{
					list.add(i++);
					System.out.println("In add method, List.size() is "+list.get(0));
				}
			}
		}
		else
		{
			remove();
		}
	}
	
	public synchronized void remove()
	{
		System.out.println("In remove method, list.size() is "+ list.remove(0));
	}
}

