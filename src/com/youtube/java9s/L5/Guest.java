package com.youtube.java9s.L5;

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
		Glass<Water> glass1 = new Glass<>();
		Water water = new Water();
		glass1.liquid = water;
		
		Water w = glass1.liquid;
		
		//L3:
		Color<Red,Green,Blue> color = new Color<>();
		Red red = new Red();
		Blue blue = new Blue();
		Green green = new Green();
		
		Bartender bartender = new Bartender();
		bartender.mix(juice, water);
//		bartender.<Juice, Water>mix(red, blue);
		bartender.<Juice, Water>mix(juice, water);
		
		
//		L4
		Glass2<OrangeJuice> glass2 = new Glass2<>();
//		Glass2<AppleJuice> glass22 = new Glass2<>();  this is not working because AppleJuice doesn't implements Liquid
		
		// class OrangeJuice extends Juice implements Liquid{}  
		// class AppleJuice extends Juice
		// Glass<OrangeJuice> orangeJuiceGlass = new Glass<>();
		// Glass<AppleJuice> appleJuiceGlass = new Glass<>();
		Juice juice1 = new OrangeJuice(); 						// this is totally fine
		
		
//		Glass2<Juice> juiceGlass = new Glass<OrangeJuice>();  	
		// this is not working. because Glass2<Juice> and Glass2<OrangeJuice> are two different classes which all extends Object
		// even if they have inheritance relationship
		
		
//		L5
		Glass<Wine> wineGlass = new WineGlass<Wine>();  // because WineGlass extends Glass, so it will work
		// but
//		Glass<Liquid> liquidGlass = new WineGlass<Wine>(); // this will not work because the two hand sides are totally different classes
		
	}

}
