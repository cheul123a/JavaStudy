package chapter03;

import java.util.Scanner;

public class Exercise05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int balance = 0;

		wh: while (true) {
			System.out.println("-------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------");
			System.out.print("선택> ");

			int choice = scan.nextInt();

			switch (choice) {

			case 1:
				System.out.print("예금액> ");
				balance += scan.nextInt();
				break;
			case 2:
				int withd;
				System.out.print("출금액> ");
				withd = scan.nextInt();
				if (balance < withd) {
					System.out.println("잔액이 부족합니다.");
					System.out.println("잔고 : "+ balance);
				} else {
					balance -= withd;
				}
				break;
			case 3:
				System.out.println("잔고> " + balance);
				break;
			case 4:
				System.out.println("프로그램 종료");
				break wh;
			default:
				System.out.println("올바른 번호를 입력해 주세요.");
			}

		}

	}

}
