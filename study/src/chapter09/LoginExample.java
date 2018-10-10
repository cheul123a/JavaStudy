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
			throw new NotExistIDException("아이디가 존재하지 않습니다.");
		}
		
		if(!pw.equals("12345")) {
			throw new WrongPasswordException("패스워드가 틀립니다.");
		}
		System.out.println("로그인 성공!");
	}

}
