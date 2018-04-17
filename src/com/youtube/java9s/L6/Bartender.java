package com.youtube.java9s.L6;

public class Bartender {

	// this <J,W> can define the argument type of argument list
	// anything that go beyond these types will be thrown a compile time error.
	public <J,W> void mix(J juice, W water)
	{
		System.out.println("mix"+ juice+ " " + water);
	}
}
