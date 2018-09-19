package chapter07;

public class Television implements RemoteControl{

	private int Volume;
	@Override
	public void turnOn() {
	System.out.println("TV¸¦ ÄÕ´Ï´Ù.");
	
	}

	@Override
	public void turnOff() {
		System.out.println("TV¸¦ ²ü´Ï´Ù.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.Volume = RemoteControl.MAX_VOLUME;
		}else if ( volume < RemoteControl.MIN_VOLUME) {
			this.Volume = RemoteControl.MIN_VOLUME;
		}else {
			this.Volume = volume;
		}
		System.out.println("ÇöÀç TV º¼·ý : " +Volume);
	}

	
	
	

}
