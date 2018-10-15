package chapter10;

public class FinalizeExample {

	public static void main(String[] args) {

		Counter counter = null;
		for(int i =1; i<=500; i++) {
			counter = new Counter(i);
			
			counter = null;
			
			System.gc();
		}
	}

}
