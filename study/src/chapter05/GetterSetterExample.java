package chapter05;

public class GetterSetterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetterGetter myCar = new SetterGetter();
		
		myCar.setSpeed(-50);
		
		System.out.println("현재속도 : " +myCar.getSpeed());
		
		myCar.setSpeed(60);
		
		System.out.println("현재속도 : " +myCar.getSpeed());
		
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		
		System.out.println("현재속도 : " +myCar.getSpeed());
		
		
	}

}
