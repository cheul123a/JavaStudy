package chapter05;

public class RectangleExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle cal = new Rectangle();
		
		double result1 = cal.areaRectangle(10);
		
		double result2 = cal.areaRectangle(10,20);
		
		System.out.println("정사각형 넓이 : "+result1);
		System.out.println("직사각형 넓이 : "+result2);
	}

}
