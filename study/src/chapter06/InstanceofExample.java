package chapter06;

public class InstanceofExample {

	public static void method1(Parent parent) {
		if(parent instanceof child) {
			child child = (child) parent;
			System.out.println("method1 - child로 변환 성공");
		}else {
			System.out.println("method1 - child로 변환되지 않음");
		}
	}
	
	public static void method2(Parent parent) {
		child child = (child) parent;				//ClassCastException이 발생할 가능성 있음
		System.out.println("method1 - child로 변환 성공");
	}
	
		
	public static void main(String[] args) {
		
		Parent parentA = new child();
		method1(parentA);
		method2(parentA);
		
		Parent parentB =new Parent();
		method1(parentB);
		method2(parentB);
		
	}

}
