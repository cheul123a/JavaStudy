package chapter04;

import java.util.Scanner;

public class Change {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] coinUnit = {500, 100, 50, 10};
		int[] coin = {5, 5, 5, 5};
		
		System.out.print("�Ž����� �Է� : ");
		int money = sc.nextInt();
		System.out.println("money = " + money);
		
		for(int i = 0; i < coinUnit.length; i++) {
			int coinNum;
			coinNum = money / coinUnit[i];
			if(coin[i] < coinNum) {
				coinNum = coin[i];
			}
			coin[i] -= coinNum;
		
			System.out.println(coinUnit[i] + "�� : " + coinNum);
			money -= coinNum * coinUnit[i];
		}
		
		if(money > 0 ) {
			System.out.println("�Ž������� �����մϴ�.");
			System.exit(0);
		}
		
		System.out.println("���� ������ ����  ");
		
		for(int i = 0; i< coin.length; i++) {
			System.out.println(coinUnit[i] +"�� : "+ coin[i]);
		}
		
		
		
	}

}
