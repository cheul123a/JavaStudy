package chapter05;

public class ReturnExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Return car = new Return();
		
		car.setGas(100);
		
		boolean gasState = car.isLeftGas();
		if(gasState) {
			System.out.println("����մϴ�.");
			car.run();
		}
		
		if(car.isLeftGas()) {
			System.out.println("gas�� ������ �ʿ䰡 �����ϴ�.");
		}else {
			System.out.println("gas�� �����ϼ���.");
		}
		
	}

}
