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

		System.out.println("숫자 맞추기 입니다. 1~100사이의 숫자를 맞춰보세요.");
		while(true) {
			input = scan.nextInt();
			count++;
			if(num < input) {
				System.out.println("Down");
			}else if(num > input) {
				System.out.println("Up");
			}else {
				System.out.println("정답입니다!("+ num +")");
				System.out.println("시도횟수 : "+ count+ " 회");
				break;
			}
		}
		
	}
}
