package chapter05;

public class CarExample {

	public static void main(String[] args) {
		// ��ü ����
		Car mycar = new Car();
		
		//�ʵ尪 �б�
		System.out.println("����ȸ�� : " + mycar.company);
		System.out.println("�𵨸� : " + mycar.model);
		System.out.println("���� : " + mycar.color);
		System.out.println("�ְ�ӵ� : "+ mycar.maxSpeed);
		System.out.println("����ӵ� : "+ mycar.speed);
		
		//�ʵ尪 ����
		mycar.speed = 60;
		System.out.println("������ �ӵ� : "+ mycar.speed);
	
	
	
	
	
	
	
	
	}

}
