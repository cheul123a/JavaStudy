package chapter07;

public class DriverExample {

	public static void main(String[] args) {

		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
		
		Vehicle vehicle = new Bus();
		
		vehicle.run();
//		vehicle.checkFare(); ȣ��Ұ�
	
		Bus bus2 = (Bus)vehicle;
		
		bus2.run();
		bus2.checkFare();
	
	
	
	}

}
