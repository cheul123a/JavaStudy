package chapter06;

public class ChildExample {
	public static void main(String[] args) {
		child child = new child();
		
		Parent parent = child;
		parent.method1();
		parent.method2();
		//parent.method3();   호출 불가능
	}
}
