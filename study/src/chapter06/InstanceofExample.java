package chapter06;

public class InstanceofExample {

	public static void method1(Parent parent) {
		if(parent instanceof child) {
			child child = (child) parent;
			System.out.println("method1 - child�� ��ȯ ����");
		}else {
			System.out.println("method1 - child�� ��ȯ���� ����");
		}
	}
	
	public static void method2(Parent parent) {
		child child = (child) parent;				//ClassCastException�� �߻��� ���ɼ� ����
		System.out.println("method1 - child�� ��ȯ ����");
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
