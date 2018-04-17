package com.youtube.java9s.L3;

public class GuestApp {

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
		
		//L3:
		Color<Red,Green,Blue> color = new Color<>();
		Red red = new Red();
		Blue blue = new Blue();
		Green green = new Green();
		
		Bartender bartender = new Bartender();
		bartender.mix(juice, water);
//		bartender.<Juice, Water>mix(red, blue);
		bartender.<Juice, Water>mix(juice, water);
		
	}

}
