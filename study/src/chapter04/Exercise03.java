package chapter04;

import java.util.Scanner;

public class Exercise03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int stuNum = 0;
		int[] students = null;
		
		
		
	wh:	while(true) {
		System.out.println("------------------");
		System.out.println("1.�л��� �Է�  | 2.�����Է� | 3.��������Ʈ  | 4.�м� | 5.����");
		System.out.println("------------------");
		System.out.print("����> ");
		int choose = scan.nextInt();
		switch(choose) {
		
		case 1:
			System.out.print("�л���> ");
			stuNum = scan.nextInt();
			students = new int[stuNum];
			break;
			
		case 2:
			for(int i =0; i<students.length; i++) {
				System.out.print("�л�"+(i+1)+": ");
				students[i] = scan.nextInt();
			}
			break;
			
		case 3:
			for(int i =0; i<students.length; i++) {
				System.out.print("�л�"+(i+1)+": " +students[i] +" \t ");
			}
			System.out.println();
			break;
		case 4:
			int best = 0, sum = 0;
			double avg = 0.0;
			
			for(int i = 0; i<students.length; i++) {
				if(best < students[i]) {
					best = students[i];
				}
				sum += students[i];
				avg ++;
			}
			avg = sum/avg;
			System.out.println("�ְ� ���� : " +best);
			System.out.println("��� ���� : " +avg);
			break;
			
		case 5:
			System.out.println("���α׷� ����");
			break wh;
			
		default :
			System.out.println("�˸��� ���ڸ� �Է��� �ּ���.");
		}
		
		
		
		
		
		}
	}

}
