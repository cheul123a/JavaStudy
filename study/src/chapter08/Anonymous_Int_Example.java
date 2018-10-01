package chapter08;

public class Anonymous_Int_Example {

	public static void main(String[] args) {

		Anonymous_Interface anony = new Anonymous_Interface();
		
		anony.field.turnOn();
		anony.method1();
		anony.method2(new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("SmartTV¸¦ ÄÕ´Ï´Ù.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("SmartTV¸¦ ²ü´Ï´Ù.");
			}
		});
		
	}

}
