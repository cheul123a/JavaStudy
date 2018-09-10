package chapter05;

public class OutClassMethodExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutClassMethod car = new OutClassMethod();
		
		car.keyTurnOn();
		car.run();
		int speed = car.getSpeed();
		System.out.println("현재 속도: "+speed + "km/h");
		
	}

}
