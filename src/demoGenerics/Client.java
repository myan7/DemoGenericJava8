package demoGenerics;

import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		MathUtil mu = new MathUtil();
		mu.add(1, "my method");

		MathUtil.add2(2, "New Method");
		
		
	}
	
//	void m1(List<T extends Number> list)
//	{
//		list.
//	}

}



class MathUtil<T>
{
	
	void add(T obj1, T obj2)
	{
		System.out.println(obj1+""+obj2);
	}
	
	static <T> void add2(T obj1, T obj2)
	{
		System.out.println(obj1 + ""+ obj2);
	}
}
