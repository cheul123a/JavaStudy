package chapter05;

import java.util.Scanner;

public class BookStore {
	private static Book[] bookArray = new Book[100];
	private static Scanner sc = new Scanner(System.in);
	private static int no = 0;

	public static void main(String[] args) {

		boolean run = true;

		System.out.println("\t 책가게 입니다.");

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.책 등록  | 2.책 목록 | 3.책 대여 | 4.책 반납 | 5.종료");
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
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("올바른 번호를 입력해 주세요.");
				break;

			}

		}

	}

	private static void addBook() {
		System.out.println("-----------");
		System.out.println("책 등록");
		System.out.println("-----------");

		System.out.print("책 이름 : ");
		String name = sc.nextLine();
		for(int i = 0; i < no; i++) {
			if(name.equals(bookArray[i].getName()) ) {
				System.out.println("책이 이미 등록되어 있습니다.");
				return;
			}
		}
		System.out.print("저자 : ");
		String writer = sc.nextLine();
		
		bookArray[no] = new Book(no, name, writer);
		
		System.out.println("책이 등록되었습니다.");
		no++;

	}
	
	
	private static void bookList() {
		if(no == 0) {
			System.out.println("등록된 책이 없습니다. 책을 먼저 등록해 주세요.");
			return;
		}
		System.out.println("-----------");
		System.out.println("책 목록");
		System.out.println("-----------");
		
		for(int i = 0; i<no; i++) {
			System.out.print("번호 : " + bookArray[i].getBno()+"\t 이름 : "+bookArray[i].getName() +"\t 저자 : "
					+bookArray[i].getWriter());
			
			if(bookArray[i].isStock()) {
				System.out.println( "\t 재고: 있음");
			}else {
				System.out.println("\t 재고 : 없음");
			}
		}
	}
	
	private static void borrow() {
		if(no == 0) {
			System.out.println("등록된 책이 없습니다. 책을 먼저 등록해 주세요.");
			return;
		}
		System.out.println("-----------");
		System.out.println("책 대여");
		System.out.println("-----------");
	
		Book borrowBook;
		
		System.out.print("대여하고 싶은 책의 이름이나 번호 : ");
		String inputBook = sc.nextLine();
		if(tryParseInt(inputBook)) {
			int bookNum = Integer.parseInt(inputBook);
			borrowBook = search(bookNum);
			
			
		}else {
			borrowBook = search(inputBook);
		}
		if(borrowBook == null) {
			System.out.println("존재하지 않는 책입니다. 확인 후 다시 시도해 주세요.");
			return;
		}else if(borrowBook.isStock()) {
			borrowBook.setStock(false);
			System.out.println("대여가 완료되었습니다. 책 이름 : " +borrowBook.getName());
		}else
			System.out.println("재고가 없습니다. 책 이름 : " +borrowBook.getName());
		
	}
	
	
	private static void returnBook() {	
		
			if(no == 0) {
				System.out.println("등록된 책이 없습니다. 책을 먼저 등록해 주세요.");
				return;
			}
			System.out.println("-----------");
			System.out.println("책 반납");
			System.out.println("-----------");
		
			Book returnBook;
			System.out.print("대여하고 싶은 책의 이름이나 번호 : ");
			String inputBook = sc.nextLine();
			if(tryParseInt(inputBook)) {
				int bookNum = Integer.parseInt(inputBook);
				returnBook = search(bookNum);
			}else {
				returnBook = search(inputBook);
			}
			if(returnBook == null) {
				System.out.println("존재하지 않는 책입니다. 확인 후 다시 시도해 주세요.");
				return;
			}else if(!returnBook.isStock()) {
				returnBook.setStock(true);
				System.out.println("반납이 완료되었습니다. 책 이름 : " +returnBook.getName());
			}else
				System.out.println("이 책은 빌리지 않았습니다. 책 이름 : " +returnBook.getName());
			
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
