package chapter06;

public class CarExample {

	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		
		for(int i = 1; i<=105; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			
			case 1:
				System.out.println("�տ��� HankookTire�� ��ü");
				car.frontLeftTire = new HankookTire("�տ���", 15);
				break;
				
			case 2:
				System.out.println("�տ����� KumhoTire�� ��ü");
				car.frontrightTire = new KumhoTire("�տ���", 13);
				break;
				
			case 3:
				System.out.println("�ڿ��� HankookTire�� ��ü");
				car.backLeftTire = new HankookTire("�ڿ���", 14);
				break;
				
			case 4:
				System.out.println("�ڿ����� KumhoTire�� ��ü");
				car.backrightTire = new KumhoTire("�ڿ�����", 17);
				break;
				
			}
			
			System.out.println("____________________________");
			
		}
	}

}
