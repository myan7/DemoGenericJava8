package com.youtube.java9s.L1;

public class GuestApp {

	public static void main(String[] args) {
		Glass glass = new Glass();
		Juice juice = new Juice();
		glass.liquid = juice;
		
		// when I want to retrieve the Juice object
		// since I declare the data type of liquid is Object inside Glass class
		// here I need to cast it to Juice
		Juice j = (Juice) glass.liquid;
	}

}
