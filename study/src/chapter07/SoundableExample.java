package chapter07;

public class SoundableExample {
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		Soundable cat = new Soundable() {
			
			@Override
			public String sound() {
				
				return "�߿�";
			}
		};
		
		Soundable dog = new Soundable() {
			
			@Override
			public String sound() {
				
				return "�۸�";
			}
		};
		
		printSound(cat);
		printSound(dog);
		
	}


}
