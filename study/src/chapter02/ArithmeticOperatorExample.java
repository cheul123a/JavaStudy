package chapter02;

public class ArithmeticOperatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v1 = 5;
		int v2 = 2;

		int result1 = v1 + v2;
		System.out.println("result1 = " + result1);

		int result2 = v1 - v2;
		System.out.println("result2 = " + result2);

		int result3 = v1 * v2;
		System.out.println("result3 = " + result3);

		int result4 = v1 / v2;
		System.out.println("result4 = " + result4);

		int result5 = v1 % v2;
		System.out.println("result5 = " + result5);

		double result6 = (double) v1 / v2;
		System.out.println("result6 = " + result6);
		
		char c1 = 'A' + 1;
		char c2 = 'A';
		//char c3 = c2 + 1; //컴파일 에러
		System.out.println("c1 : " +c1);
		System.out.println("c2 : " +c2);
	}

}
