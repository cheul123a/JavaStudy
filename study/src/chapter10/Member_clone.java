package chapter10;

public class Member_clone implements Cloneable{
	
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;
	
	
	
	public Member_clone(String id, String name, String password, int age, boolean adult) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
	}

	
	public Member_clone getMember() {
		Member_clone cloned = null;
		try {
			cloned = (Member_clone) clone();
		}catch (CloneNotSupportedException e) {	System.out.println("클론 생성이 허용 되어있지 않습니다.");}
		
		return cloned;
	}
	

	
}
