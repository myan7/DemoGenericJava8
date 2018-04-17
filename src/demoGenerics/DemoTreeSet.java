package demoGenerics;

import java.util.Comparator;
import java.util.TreeSet;

public class DemoTreeSet {

	public static void main(String[] args) {
		//since it is a set, it will not allow duplicate
		// tree: means sorted
		
		TreeSet<Employee> set = new TreeSet<>();
		
		set.add(new Employee(1,"Ming"));
		set.add(new Employee(1,"Yue"));
		set.add(new Employee(3,"Hao"));
		set.add(new Employee(4,"Yog"));
		set.add(new Employee(1,"Ming"));
		
		System.out.println(set.size());
		
		for(Employee e: set)
		{
			System.out.println(e);
		}
	}
}

class EmployeeNameComparator implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getName().compareTo(o2.getName())!=0)
			return o1.getName().compareTo(o2.getName());
		return o1.getId()-o2.getId();
	}
}