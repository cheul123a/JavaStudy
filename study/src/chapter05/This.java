package chapter05;

public class This {
	
	String compnay = "현대자동차";
	String model;
	String color;
	int maxspeed;
	
	This(){}
	
	This(String model){
		this(model,"은색", 250);
	}
	
	This(String model, String color){
		this(model, color, 250);
	}
	
	
	This(String model, String color, int maxspeed){
		this.model = model;
		this.color = color;
		this.maxspeed = maxspeed;
	}
}
