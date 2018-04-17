package com.youtube.java9s.L6;

public class Tray {

	// this is the unbounded wildcard
	public void add(Glass<?> glass)
	{
		
	}
	// this is not generic at all
	public void add1(Glass<Juice> juiceGlass)
	{
		
	}
	
	// this is upper bounded wildcard, which means everything you want to pass into this add2 method,
	// should be sub classes of Juice
	public void add2(Glass<? extends Juice> juiceGlass)
	{
		
	}
	
	
	
	// for demonstrating lower bound 
	
	public void remove(Glass<? super Coke> coke) 
	{
		
	}
	
	public void remove1(Glass<? super CokeDiet> cokeDiet)
	{
		
	}
	
	public void remove2(Glass<? super CokeZero> cokeZero)
	{
		
	}
}
