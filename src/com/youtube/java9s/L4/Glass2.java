package com.youtube.java9s.L4;

// and you should know that the type parameter should be a subtype of the boundary we have mentioned.
///*
public class Glass2<T extends Juice & Liquid> // remember concrete class goes first
{
	
	private T liquid;
	
	public String getLiquidTaste()
	{
		return liquid.taste();
	}
}
//*/

/*
public class Glass2<T> // this is shown that you can define the boundary in the class level
{ 
	private T liquid;
// and you can define the boundary in the method level.	
	public <U extends Juice & Liquid> String getLiquidTaste(U juice)
	{
		return juice.taste();
	}
}
*/