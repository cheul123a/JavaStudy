package chapter03;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		int num = random.nextInt(101);
		
		int input;
		int count = 0;

		System.out.println("���� ���߱� �Դϴ�. 1~100������ ���ڸ� ���纸����.");
		while(true) {
			input = scan.nextInt();
			count++;
			if(num < input) {
				System.out.println("Down");
			}else if(num > input) {
				System.out.println("Up");
			}else {
				System.out.println("�����Դϴ�!("+ num +")");
				System.out.println("�õ�Ƚ�� : "+ count+ " ȸ");
				break;
			}
		}
		
	}
}
