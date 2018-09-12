package chapter05;

import java.util.Scanner;

public class BankApplication {
	private static Scanner scan = new Scanner(System.in);
	private static BankAccount[] accountArray = new BankAccount[100];
	static int bankNo = 0;
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("------------");
			System.out.println("1.계좌생성 |2.계좌목록 |3.예금 |4.출금 |5.종료");
			System.out.println("------------");
			
			int select = scan.nextInt();
			
			switch(select) {
			
			case 1:
				createAccount();
				break;
			case 2:
				accountList();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
			default : 
				System.out.println("올바른 번호를 입력해 주세요.");
			}
			
			
		}
	}
	
	private static void createAccount() {
		
		System.out.println("------------");
		System.out.println("계좌생성");
		System.out.println("------------");
	
		System.out.print("계좌번호 : ");
		String ano = scan.next();
		BankAccount isAno = findAccount(ano);
		if(isAno != null) {
			System.out.println("계좌번호가 이미 존재 합니다.");
			System.out.println("다른 계좌번호를 입력해 주세요.");
			createAccount();
			return;
		}
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("초기입금액 : ");
		int balance = scan.nextInt();
		
		accountArray[bankNo] = new BankAccount(ano, name, balance);
		System.out.println("결과 : 계좌가 생성되었습니다.");
		bankNo++;
	}
	
	private static void accountList() {
		System.out.println("------------");
		System.out.println("계좌목록");
		System.out.println("------------");
		if(bankNo == 0) {
			System.out.println("계좌가 생성되지 않았습니다.");
		}
		for(int i = 0; i<bankNo; i++) {
			System.out.println(accountArray[i].getAno() +"\t"+accountArray[i].getName() 
					+"\t"+ accountArray[i].getBalance());
		}
	}
		
	
	private static void deposit() {
		System.out.println("------------");
		System.out.println("예금");
		System.out.println("------------");
		
		System.out.print("게좌번호 : ");
		
		BankAccount sameAddr = findAccount(scan.next());
		
		if(sameAddr == null) {
			System.out.println("입력한 계좌번호가 존재하지 않습니다.");
			System.out.println("다시시도 하거나 계좌를 만들어 주세요.");
			return;
		}
		
		System.out.print("예금액 : ");
		sameAddr.setBalance(sameAddr.getBalance() + scan.nextInt());
		
		System.out.println("결과 : 예금이 성공되었습니다.");
		
			
	}
	
	private static void withdraw() {
		System.out.println("------------");
		System.out.println("출금");
		System.out.println("------------");
		
		System.out.print("계좌번호 : ");
		BankAccount sameAddr = findAccount(scan.next());
		
		if(sameAddr == null) {
			System.out.println("입력한 계좌번호가 존재하지 않습니다.");
			System.out.println("다시시도 하거나 계좌를 만들어 주세요.");
			return;
		}
		
		System.out.print("출금액 : ");
		int withdraw = scan.nextInt();
		if(withdraw > sameAddr.getBalance()) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		sameAddr.setBalance(sameAddr.getBalance() - withdraw);
		System.out.println("결과 : 출금이 성공되었습니다.");
	}
	
	
	private static BankAccount findAccount(String ano) {
		for(int i = 0; i<bankNo; i++) {
			if(accountArray[i].getAno().equals(ano)) {
				return accountArray[i];
			}
		}
		return null;
	}
	
	
	
}
