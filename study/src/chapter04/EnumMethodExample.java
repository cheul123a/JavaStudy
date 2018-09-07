package chapter04;

public class EnumMethodExample {

	public static void main(String[] args) {
		System.out.println("name() 메소드");
		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println(name);
		System.out.println();
		
		System.out.println("ordinal() 메소드");
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		System.out.println();
		
		System.out.println("comepareTo() 메소드");
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println();
		
		System.out.println("valueOf() 메소드");
		if(args.length==1) {
			String strDay = args[0];
			Week weekday = Week.valueOf(strDay);
			if(weekday == Week.SATURDAY || weekday == Week.SUNDAY) {
				System.out.println("주말이군요");
			}else {
				System.out.println("평일이군요");
			}
		}
		System.out.println();
		
		
		System.out.println("values() 메소드");
		Week[] days = Week.values();
		for(Week day : days) {
			System.out.println(day);
		}
		
		
	}

}
