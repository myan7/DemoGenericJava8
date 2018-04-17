package com.youtube.java9s.L2;

public class Guest {

	public static void main(String[] args) {
		Glass<Juice> glass = new Glass<>();
		Juice juice = new Juice();
		glass.liquid = juice;
		
		
		// after I set the Glass to be Generic, I can pass the Juice type to the Glass object
		// so I don't need to do the downcast.
		Juice j =  glass.liquid;
		
		
		// Generic introduces strong type checking
		// Generic can eliminate explicit casting
		// Generic enables to design generic design algorithms
		// when define the generic type inside Glass<T>, we call T type parameter
		// in the next line, inside the Glass<Water> we call water type argument
		Glass<Water> glass2 = new Glass<>();
		Water water = new Water();
		glass2.liquid = water;
		
		Water w = glass2.liquid;
	}

}
