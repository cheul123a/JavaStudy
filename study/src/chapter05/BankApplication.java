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
			System.out.println("1.���»��� |2.���¸�� |3.���� |4.��� |5.����");
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
				System.out.println("���α׷� ����");
				run = false;
				break;
			default : 
				System.out.println("�ùٸ� ��ȣ�� �Է��� �ּ���.");
			}
			
			
		}
	}
	
	private static void createAccount() {
		
		System.out.println("------------");
		System.out.println("���»���");
		System.out.println("------------");
	
		System.out.print("���¹�ȣ : ");
		String ano = scan.next();
		BankAccount isAno = findAccount(ano);
		if(isAno != null) {
			System.out.println("���¹�ȣ�� �̹� ���� �մϴ�.");
			System.out.println("�ٸ� ���¹�ȣ�� �Է��� �ּ���.");
			createAccount();
			return;
		}
		System.out.print("�̸� : ");
		String name = scan.next();
		System.out.print("�ʱ��Աݾ� : ");
		int balance = scan.nextInt();
		
		accountArray[bankNo] = new BankAccount(ano, name, balance);
		System.out.println("��� : ���°� �����Ǿ����ϴ�.");
		bankNo++;
	}
	
	private static void accountList() {
		System.out.println("------------");
		System.out.println("���¸��");
		System.out.println("------------");
		if(bankNo == 0) {
			System.out.println("���°� �������� �ʾҽ��ϴ�.");
		}
		for(int i = 0; i<bankNo; i++) {
			System.out.println(accountArray[i].getAno() +"\t"+accountArray[i].getName() 
					+"\t"+ accountArray[i].getBalance());
		}
	}
		
	
	private static void deposit() {
		System.out.println("------------");
		System.out.println("����");
		System.out.println("------------");
		
		System.out.print("���¹�ȣ : ");
		
		BankAccount sameAddr = findAccount(scan.next());
		
		if(sameAddr == null) {
			System.out.println("�Է��� ���¹�ȣ�� �������� �ʽ��ϴ�.");
			System.out.println("�ٽýõ� �ϰų� ���¸� ����� �ּ���.");
			return;
		}
		
		System.out.print("���ݾ� : ");
		sameAddr.setBalance(sameAddr.getBalance() + scan.nextInt());
		
		System.out.println("��� : ������ �����Ǿ����ϴ�.");
		
			
	}
	
	private static void withdraw() {
		System.out.println("------------");
		System.out.println("���");
		System.out.println("------------");
		
		System.out.print("���¹�ȣ : ");
		BankAccount sameAddr = findAccount(scan.next());
		
		if(sameAddr == null) {
			System.out.println("�Է��� ���¹�ȣ�� �������� �ʽ��ϴ�.");
			System.out.println("�ٽýõ� �ϰų� ���¸� ����� �ּ���.");
			return;
		}
		
		System.out.print("��ݾ� : ");
		int withdraw = scan.nextInt();
		if(withdraw > sameAddr.getBalance()) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		sameAddr.setBalance(sameAddr.getBalance() - withdraw);
		System.out.println("��� : ����� �����Ǿ����ϴ�.");
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
