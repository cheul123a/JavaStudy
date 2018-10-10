package chapter09;

public class MultiCatchExample {

	public static void main(String[] args) {

		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(value1 + " + " + value2 + " = " + result);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("실행 매개값의 수가 부족하거나 숫자로 변경할 수 없습니다.");
		} catch (Exception e) {
			System.out.println("알수 없는 예외 발생");
		} finally {
			System.out.println("이용해 주셔서 감사합니다.");
		}
	}

}
