package chapter09;

public class LoginExample {

	public static void main(String[] args) {

		try {
			login("white","54321");
		} catch (NotExistIDException | WrongPasswordException e) {
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			e.printStackTrace();
		}
		
		try {
			login("drin","54321");
		} catch (NotExistIDException | WrongPasswordException e) {
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			e.printStackTrace();
		}
		
		try {
			login("drin","12345");
		} catch (NotExistIDException | WrongPasswordException e) {
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			e.printStackTrace();
		}
		
	}
	
	public static void login(String id, String pw) throws NotExistIDException, WrongPasswordException {
		if(!id.equals("drin")) {
			throw new NotExistIDException("���̵� �������� �ʽ��ϴ�.");
		}
		
		if(!pw.equals("12345")) {
			throw new WrongPasswordException("�н����尡 Ʋ���ϴ�.");
		}
		System.out.println("�α��� ����!");
	}

}
