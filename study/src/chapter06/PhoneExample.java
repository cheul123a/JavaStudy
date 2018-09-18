package chapter06;

public class PhoneExample {

	public static void main(String[] args) {

		//Phone phone = new Phone();	불가능
		
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}

}
