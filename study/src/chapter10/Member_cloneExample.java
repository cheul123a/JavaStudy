package chapter10;

public class Member_cloneExample {

	public static void main(String[] args) {

		Member_clone original = new Member_clone("Drin", "MK", "12347", 77, true);
		
		Member_clone cloned = original.getMember();
		cloned.password = "7777";
		
		System.out.println("[복제 객체의 필드값]");
		System.out.println("id: " +cloned.id);
		System.out.println("name : " +cloned.name);
		System.out.println("password : "+cloned.password);
		System.out.println("age : "+cloned.age);
		System.out.println("adult : "+cloned.adult);
		
		System.out.println();
		
		System.out.println("[원본 객체의 필드값]");
		System.out.println("id: " +original.id);
		System.out.println("name : " +original.name);
		System.out.println("password : "+original.password);
		System.out.println("age : "+original.age);
		System.out.println("adult : "+original.adult);
	}

}
