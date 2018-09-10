package chapter05;

public class InstanceAndThis {

	String model;
	int speed;
	
	
	public InstanceAndThis(String model) {
		this.model = model;
	}
	
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void run() {
		for(int i = 10; i<=50; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다. (시속: " +speed +"km/h)");
		}
	}
	
	
	
}
