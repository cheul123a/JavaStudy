package chapter02;

public class StringEqualsExample {
	public static void main(String[] args) {
		String strVar1 = "Java";
		String strVar2 = "Java";
		String strVar3 = new String("Java");
		
		System.out.println(strVar1 == strVar2);
		System.out.println(strVar2 == strVar3);
		System.out.println();
		System.out.println(strVar1.equals(strVar2));
		System.out.println(strVar2.equals(strVar3));
		
	}
}
