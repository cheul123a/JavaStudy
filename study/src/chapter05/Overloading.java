package chapter05;

public class Overloading {
	
	String compnay = "현대자동차";
	String model;
	String color;
	int maxspeed;
	
	
	Overloading() {}
	
	Overloading(String model){
		this.model = model;
	}
	
	Overloading(String model, String color){
		this.model = model;
		this.color = color;
	}
	
	Overloading(String model, String color, int maxspeed){
		this.model = model;
		this.color = color;
		this.maxspeed = maxspeed;		
	}



}




