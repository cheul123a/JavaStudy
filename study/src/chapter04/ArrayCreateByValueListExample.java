package chapter04;

public class ArrayCreateByValueListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = { 83, 90, 87 };
		
		System.out.println("scores[0] : "+scores[0]);
		System.out.println("scores[1] : "+scores[1]);
		System.out.println("scores[2] : "+scores[2]);
		
		int sum = 0;
		
		for(int i =0; i<scores.length;i++) {
			sum += scores[i];
		}
		System.out.println("���� : " +sum);
		System.out.println("��� : " +((double)sum/scores.length));
	}

}
