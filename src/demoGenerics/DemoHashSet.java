package demoGenerics;

import java.util.HashSet;
import java.util.Set;

public class DemoHashSet {

	public static void main(String[] args) {
		
		Set<Employee> set = new HashSet<>();
		
//		Employee e1 = new Employee(1,"Hao");
		
		set.add(new Employee(1,"Ming"));
		set.add(new Employee(1,"Yue"));
		set.add(new Employee(3,"Hao"));
		set.add(new Employee(4,"Yog"));
		set.add(new Employee(1,"gniM"));
		
		System.out.println(set.size());
		
		for(Employee e: set)
		{
			System.out.println(e);
		}
	}
}

/*
hashCode() is from Object class, hashCode() will return you a short version of the memory address
where your object is stored in the heap.
*/
