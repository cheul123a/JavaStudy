package chapter07;

public class RemoteControllerExample {

	public static void main(String[] args) {
		RemoteControl rc = null;
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(7);
		rc.setMute(true);
		rc.setMute(false);
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(4);
		rc.setMute(true);
		rc.setMute(false);
		
	}

}
