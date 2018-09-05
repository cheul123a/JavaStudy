package chapter03;

public class ForMultiTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				System.out.print(j +" X "+ i + " = " + i*j + " \t");
			}
			System.out.println();
		}
	}

}
