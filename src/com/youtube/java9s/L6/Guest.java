package com.youtube.java9s.L6;

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
		// when define the generic type inside class Glass<T>, we call T type parameter
		// in the next line, inside the Glass<Water> we call water type argument
		Glass<Water> glass1 = new Glass<>();
		Water water = new Water();
		glass1.liquid = water;
		
		Water w = glass1.liquid;
		
		//L3: define Generic type at method level
		Color<Red,Green,Blue> color = new Color<>();
		Red red = new Red();
		Blue blue = new Blue();
		Green green = new Green();
		
		Bartender bartender = new Bartender();
		bartender.mix(juice, water);
//		bartender.<Juice, Water>mix(red, blue);
		bartender.<Juice, Water>mix(juice, water);
		
		
//		L4 boundary
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
		
		
//		L5 inheritance and subtype
		Glass<Wine> wineGlass = new WineGlass<Wine>();  // because WineGlass extends Glass, so it will work
		// but
//		Glass<Liquid> liquidGlass = new WineGlass<Wine>(); // this will not work because the two hand sides are totally different classes
		
//		WineGlass<Juice> juiceWineGlass = new Glass<Juice>();// this is wrong because LHS is the subtype, while the RHS is the super type
		
//		L6 wildcard
		/* wildcard is used for passing uncertain data type as argument into the argument list
		 * see this function: 
		 * class Tray 
		 * {
		 * 		public void add(Glass<Juice> juiceGlass){}
		 * }
		 * this method is not generic at all, even it uses generic data type
		 * because when passing some argument to the method add, the data type is already defined to be Glass<Juice> or its sub classes
		 * How to make it real generic? 
		 * 
		 * class Tray
		 * {
		 * 		public void add(Glass<?> glass){}  
		 * }
		 *  the "?" is called wildcard
		 */
		
		Tray tray = new Tray();
		
		// when I set the add method as Glass<?>, everything can be set into the generic data type
		tray.add(new Glass<String>()); 
		
//		tray.add1(new Glass<Integer>());  I can only pass Glass<Juice> into the add1(), because in the argument 
		
		/*
		 * There are three types of wildcards 
		 * 1, unbounded wildcard
		 * 2, upper bounded wildcard
		 * 3, lower bounded wildcard
		 * see the comments in the Tray class
		 */
		
		//upper bound
		tray.add2(new Glass<OrangeJuice>());  // this works fine because OrangeJuice extends Juice, Juice is the upper bound
//		tray.add2(new Glass<Wine>());  // this is not gonna work because wine implements Liquid, Wine class has nothing to do with Juice.
		
		// to demonstrate lower bound, I will create 3 new classes Coke, DietCoke, and ZeroCoke
		// the hierarchy should be ZeroCoke extends DietCoke, DietCoke extends Coke
		// class Coke{}
		// class CokeDiet extends Coke{}
		// class CokeZero extends CokeDiet{}
		
		tray.remove(new Glass<Coke>());	   // any super type of Coke will do
		tray.remove1(new Glass<Coke>());   // any super type of CokeDiet will do
		tray.remove2(new Glass<Coke>());   // any super type of CokeZero will do
		
//		tray.remove(new Glass<CokeDiet>());  this is not gonna work because remove method only accept Glass<? super Coke>. CokeDiet is not super type of Coke
		tray.remove1(new Glass<CokeDiet>());	// CokeDiet is super type of itself
		tray.remove2(new Glass<CokeDiet>()); // CokeDiet is super type of CokeZero
		
		
//		tray.remove(new Glass<CokeZero>());	//CokeZero is not super type of Coke
//		tray.remove1(new Glass<CokeZero>()); // CokeZero is not super type of CokeDiet
		tray.remove2(new Glass<CokeZero>());
		
		/*
		 * By using the lowerbound wildcard, we actually close the code for support any new types in the hierarchy 
		 * and restrict to the types that currently present
		 * 
		 * By using the upper bound wildcard, we keep the code open for extension to support any new type getting added 
		 * in the hierarchy
		 */
	}

}
