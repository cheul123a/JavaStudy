package chapter06;

public class Tire {

	public int maxRotation;
	public int accmulatedRotation;
	public String location;
	
	
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	public boolean roll() {
		++accmulatedRotation;
		if(accmulatedRotation < maxRotation) {
			System.out.println(location + " Tire ¼ö¸í : " + (maxRotation - accmulatedRotation) +"È¸");
			return true;
		}else {
			System.out.println("*** "+location + " Tire ÆãÅ© ***");
			return false;
		}
	}
}
