package chapter03;

public class WhileKeyControlExample {

	public static void main (String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean run = true;
		int speed = 0;
		int keyCode=  0;
		
		while(run) {
			if(keyCode!=13 && keyCode!=10) {
			System.out.println("---------------");
			System.out.println("1.���� | 2.���� | 3.����");
			System.out.println("---------------");
			System.out.println("���� : ");
			}
			keyCode = System.in.read();
			
			switch(keyCode) {
			case 49:
				speed++;
				System.out.println("����ӵ� : " +speed);
				break;
			case 50:
				speed--;
				System.out.println("����ӵ� : " +speed);
				break;
			case 51:
				run = false;
				break;
			}
		}
		System.out.println("���α׷� ����");
	}

}
