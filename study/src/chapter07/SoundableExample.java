package chapter07;

public class SoundableExample {
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		Soundable cat = new Soundable() {
			
			@Override
			public String sound() {
				
				return "具克";
			}
		};
		
		Soundable dog = new Soundable() {
			
			@Override
			public String sound() {
				
				return "港港";
			}
		};
		
		printSound(cat);
		printSound(dog);
		
	}


}
