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
		System.out.println("1.학생수 입력  | 2.점수입력 | 3.점수리스트  | 4.분석 | 5.종료");
		System.out.println("------------------");
		System.out.print("선택> ");
		int choose = scan.nextInt();
		switch(choose) {
		
		case 1:
			System.out.print("학생수> ");
			stuNum = scan.nextInt();
			students = new int[stuNum];
			break;
			
		case 2:
			for(int i =0; i<students.length; i++) {
				System.out.print("학생"+(i+1)+": ");
				students[i] = scan.nextInt();
			}
			break;
			
		case 3:
			for(int i =0; i<students.length; i++) {
				System.out.print("학생"+(i+1)+": " +students[i] +" \t ");
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
			System.out.println("최고 점수 : " +best);
			System.out.println("평균 점수 : " +avg);
			break;
			
		case 5:
			System.out.println("프로그램 종료");
			break wh;
			
		default :
			System.out.println("알맞은 숫자를 입력해 주세요.");
		}
		
		
		
		
		
		}
	}

}
