package chapter07;

public class Television implements RemoteControl{

	private int Volume;
	@Override
	public void turnOn() {
	System.out.println("TV�� �մϴ�.");
	
	}

	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
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
		System.out.println("���� TV ���� : " +Volume);
	}

	
	
	

}
