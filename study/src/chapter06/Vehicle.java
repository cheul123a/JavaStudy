package chapter06;

public class Vehicle {

	Tire frontLeftTire = new Tire("�տ���",3);
	Tire frontrightTire = new Tire("�տ�����",4);
	Tire backrightTire = new Tire("�ڿ�����",1);
	Tire backLeftTire = new Tire("�ڿ���",2);
	
	
	int run() {
		System.out.println("[�ڵ����� �޸��ϴ�.]");
		if(frontLeftTire.roll() == false) {stop(); return 1;};
		if(frontrightTire.roll() == false) {stop(); return 2;};
		if(backLeftTire.roll() == false) {stop(); return 3;};
		if(backrightTire.roll() == false) {stop(); return 4;};
		return 0;
	}
		
	void stop() {
		System.out.println("[�ڵ����� ����ϴ�.]");
	}
}
