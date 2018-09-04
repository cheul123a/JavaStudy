package chapter02;

public class OverflowExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1000000;
		int y = 1000000;
		int z = x*y;
		System.out.println(z);
		
		long i = 1000000;
		long j = 1000000;
		long k = i*j;
		System.out.println(k);
	}

}
