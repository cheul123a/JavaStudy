package chapter03;

import java.util.Scanner;

public class Exercise05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int balance = 0;

		wh: while (true) {
			System.out.println("-------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("-------------");
			System.out.print("����> ");

			int choice = scan.nextInt();

			switch (choice) {

			case 1:
				System.out.print("���ݾ�> ");
				balance += scan.nextInt();
				break;
			case 2:
				int withd;
				System.out.print("��ݾ�> ");
				withd = scan.nextInt();
				if (balance < withd) {
					System.out.println("�ܾ��� �����մϴ�.");
					System.out.println("�ܰ� : "+ balance);
				} else {
					balance -= withd;
				}
				break;
			case 3:
				System.out.println("�ܰ�> " + balance);
				break;
			case 4:
				System.out.println("���α׷� ����");
				break wh;
			default:
				System.out.println("�ùٸ� ��ȣ�� �Է��� �ּ���.");
			}

		}

	}

}
