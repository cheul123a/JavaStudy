package chapter03;

public class Exercise02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			int num = (int)(Math.random()*6)+1;
			int num2 = (int)(Math.random()*6)+1;
			System.out.println("("+num+","+num2+")");
			if(num + num2 == 5) {
				break;
			}
		}
	}

}
