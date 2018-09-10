package chapter05;

public class OverloadingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overloading car1 = new Overloading();
		System.out.println("car1.company : " +car1.compnay);
		System.out.println();
		
		Overloading car2 = new Overloading("자가용");
		System.out.println("car2.company : "+car2.compnay);
		System.out.println("car2.model : "+car2.model);
		System.out.println();
		
		Overloading car3 = new Overloading("자가용", "빨강");
		System.out.println("car3.company : "+car3.compnay);
		System.out.println("car3.model : "+car3.model);
		System.out.println("car3.color : "+car3.color);
		System.out.println();
		
		Overloading car4 = new Overloading("택시", "검정", 200);
		System.out.println("car4.company : "+car4.compnay);
		System.out.println("car4.model : "+car4.model);
		System.out.println("car4.color : "+car4.color);
		System.out.println("car4.maxspeed : "+car4.maxspeed);
		System.out.println();
		
		
		
	}

}
