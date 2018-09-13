package chapter06;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		// DmbCellPhone 객체 생성
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		//CellPhone으로부터 상속받은 필드
		System.out.println("모델: "+ dmbCellPhone.model);
		System.out.println("색상: "+ dmbCellPhone.color);
		
		//DmbCellPhone의 필드
		System.out.println("채널: "+ dmbCellPhone.channel);
		
		//CellPhone으로부터 상속받은 메소드 호출
		dmbCellPhone.powerOn();
		dmbCellPhone.powerOff();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요! 홍길동입니다.");
		dmbCellPhone.sendVoice("아~ 예 반값습니다.");
		dmbCellPhone.hangUp();
		
		//dmbCellPhone의 메소드 호출
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(77);
		dmbCellPhone.turnOffDmb();
	}

}
