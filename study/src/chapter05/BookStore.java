package chapter05;

import java.util.Scanner;

public class BookStore {
	private static Book[] bookArray = new Book[100];
	private static Scanner sc = new Scanner(System.in);
	private static int no = 0;

	public static void main(String[] args) {

		boolean run = true;

		System.out.println("\t å���� �Դϴ�.");

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.å ���  | 2.å ��� | 3.å �뿩 | 4.å �ݳ� | 5.����");
			System.out.println("-------------------------------------------");
			
			int choose = sc.nextInt();
			sc.nextLine();

			switch (choose) {

			case 1:
				addBook();
				break;
			case 2:
				bookList();
				break;
			case 3:
				borrow();
				break;
			case 4:
				returnBook();
				break;
			case 5:
				System.out.println("���α׷� ����");
				run = false;
				break;
			default:
				System.out.println("�ùٸ� ��ȣ�� �Է��� �ּ���.");
				break;

			}

		}

	}

	private static void addBook() {
		System.out.println("-----------");
		System.out.println("å ���");
		System.out.println("-----------");

		System.out.print("å �̸� : ");
		String name = sc.nextLine();
		for(int i = 0; i < no; i++) {
			if(name.equals(bookArray[i].getName()) ) {
				System.out.println("å�� �̹� ��ϵǾ� �ֽ��ϴ�.");
				return;
			}
		}
		System.out.print("���� : ");
		String writer = sc.nextLine();
		
		bookArray[no] = new Book(no, name, writer);
		
		System.out.println("å�� ��ϵǾ����ϴ�.");
		no++;

	}
	
	
	private static void bookList() {
		if(no == 0) {
			System.out.println("��ϵ� å�� �����ϴ�. å�� ���� ����� �ּ���.");
			return;
		}
		System.out.println("-----------");
		System.out.println("å ���");
		System.out.println("-----------");
		
		for(int i = 0; i<no; i++) {
			System.out.print("��ȣ : " + bookArray[i].getBno()+"\t �̸� : "+bookArray[i].getName() +"\t ���� : "
					+bookArray[i].getWriter());
			
			if(bookArray[i].isStock()) {
				System.out.println( "\t ���: ����");
			}else {
				System.out.println("\t ��� : ����");
			}
		}
	}
	
	private static void borrow() {
		if(no == 0) {
			System.out.println("��ϵ� å�� �����ϴ�. å�� ���� ����� �ּ���.");
			return;
		}
		System.out.println("-----------");
		System.out.println("å �뿩");
		System.out.println("-----------");
	
		Book borrowBook;
		
		System.out.print("�뿩�ϰ� ���� å�� �̸��̳� ��ȣ : ");
		String inputBook = sc.nextLine();
		if(tryParseInt(inputBook)) {
			int bookNum = Integer.parseInt(inputBook);
			borrowBook = search(bookNum);
			
			
		}else {
			borrowBook = search(inputBook);
		}
		if(borrowBook == null) {
			System.out.println("�������� �ʴ� å�Դϴ�. Ȯ�� �� �ٽ� �õ��� �ּ���.");
			return;
		}else if(borrowBook.isStock()) {
			borrowBook.setStock(false);
			System.out.println("�뿩�� �Ϸ�Ǿ����ϴ�. å �̸� : " +borrowBook.getName());
		}else
			System.out.println("��� �����ϴ�. å �̸� : " +borrowBook.getName());
		
	}
	
	
	private static void returnBook() {	
		
			if(no == 0) {
				System.out.println("��ϵ� å�� �����ϴ�. å�� ���� ����� �ּ���.");
				return;
			}
			System.out.println("-----------");
			System.out.println("å �ݳ�");
			System.out.println("-----------");
		
			Book returnBook;
			System.out.print("�뿩�ϰ� ���� å�� �̸��̳� ��ȣ : ");
			String inputBook = sc.nextLine();
			if(tryParseInt(inputBook)) {
				int bookNum = Integer.parseInt(inputBook);
				returnBook = search(bookNum);
			}else {
				returnBook = search(inputBook);
			}
			if(returnBook == null) {
				System.out.println("�������� �ʴ� å�Դϴ�. Ȯ�� �� �ٽ� �õ��� �ּ���.");
				return;
			}else if(!returnBook.isStock()) {
				returnBook.setStock(true);
				System.out.println("�ݳ��� �Ϸ�Ǿ����ϴ�. å �̸� : " +returnBook.getName());
			}else
				System.out.println("�� å�� ������ �ʾҽ��ϴ�. å �̸� : " +returnBook.getName());
			
		}
	
	
	
	
	
	
	private static Book search(String name) {
		
		for(int i = 0; i<no; i++) {
			if(name.equals(bookArray[i].getName())) {
				return bookArray[i];
			}
		}
		return null;
	}
	
	private static Book search(int bno) {
		
		for(int i = 0; i<no; i++) {
			if(bno == bookArray[i].getBno()) {
				return bookArray[i];
			}
		}
		return null;
	}
	
	
	private static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	

}
