package demoThread;

public class DemoThread_5 {

	public static void main(String[] args) {	
		A a = new B();
		System.out.println("a.x should be from A, which is 10......a.x = "+a.x);
		System.out.println();
		System.out.println("a.getX() should be from B, which is 20.....a.getX()= "+a.getX());
		System.out.println("-------------------");
		System.out.println("a.y should be from A, which is 100.....a.y ="+a.y);
		System.out.println();
		System.out.println("a.getY() should also be from A, because y is static variable which is 100.....a.getY() ="+a.getY());
		System.out.println("-------------------");
		a.printX();
		System.out.println();
		a.printY();
	}
}

class A
{
	int x = 10;
	static int y = 100;
	
	public int getX() {
		System.out.println("from A");
		return x;
	}
	public void setX(int x) {
		System.out.println("from A");
		this.x = x;
	}
	public static int getY() {
		System.out.println("from A");
		return y;
	}
	public static void setY(int y) {
		System.out.println("from A");
		A.y = y;
	}
	void printX()
	{
		System.out.println(x+" non-static method from A");
	}
	static void printY()
	{
		System.out.println(y+" static method from A");
	}
}

class B extends A
{
	int x = 20;
	static int y = 200;
	
	public int getX() {
		System.out.println("from B");
		return x;
	}
	public void setX(int x) {
		System.out.println("from B");
		this.x = x;
	}
	public static int getY() {
		System.out.println("from B");
		return y;
	}
	public static void setY(int y) {
		System.out.println("from B");
		B.y = y;
	}
	void printX()
	{
		System.out.println(x+" non-static method from B");
	}
	static void printY()
	{
		System.out.println(y+" static method from B");
	}
}


// for variables and class method, always look for the LHS, no matter when running or compiling
// for non-static method, compiler will check if the LHS has that method, but when running, it will call from the RHS