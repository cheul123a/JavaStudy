package chapter01;

public class DataType {
	public static void main(String[] args) {
		byte var1 = -128;
		byte var2 = 127;
		// byte var3 = 128; //컴파일 에러
		System.out.println(var1 + " " + var2);

		char c1 = 'A';
		char c2 = 65;
		char c3 = '\u0041';
		System.out.println(c1 + "  " + c2 + "  " + c3);

		int num1 = 10;
		int num2 = 012; // 8진수로 저장
		int num3 = 0xA; // 16진수로 저장
		System.out.println(num1 + "  " + num2 + "  " + num3);

		long ex1 = 10;
		// long ex2 = 100000000000; //컴파일 에러
		long ex3 = 1000000000000L; // int 타입 범위 초과시 L을 붙여줘야함
		System.out.println(ex1 + "  " + ex3);

		double dvar1 = 3.14;
		// float dvar2 = 3.14; // 컴파일 에러
		float dvar3 = 3.14F;

		// 정밀도 테스트
		double dvar4 = 0.1234567890123456789;
		float dvar5 = 0.1234567890123456789F;
		System.out.println(dvar1 + "  " + dvar3);
		System.out.println(dvar4);
		System.out.println(dvar5);
		
		
		boolean stop = false;
		if(stop)
			System.out.println("중지합니다.");
		else
			System.out.println("시작합니다.");

	}
}
