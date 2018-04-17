package demoThread;
/*
 * How to find the security problem in you multi-thread application
 * 1. find out which lines run multithread task
 * 2. find out what is the shared data
 * 3. find out those code who operates the shared data in your code
 */

public class DemoThread_6 {
	public static void main(String[] args) {
		Customer cust = new Customer();
		Thread t1 = new Thread(cust);
		Thread t2 = new Thread(cust);
		t1.start();
		t2.start();
	}

}

class Bank
{
	private int sum;
	public synchronized void save(int n)  // why it works after I add synchronized key word in this method?
	{									// because the thread run method calls this method, and this method operates the shared data.
		sum +=n;
		// this is where the second thread enters, that's why you can see 200,200,300,400,500,600
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The amount is "+ sum);
	}
}


class Customer implements Runnable
{
	Bank b = new Bank();
	@Override
	public void run() {
		for(int i =0; i<3 ; i++)
		{
			b.save(100);
		}
	}
}

