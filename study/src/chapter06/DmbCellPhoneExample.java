package chapter06;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		// DmbCellPhone ��ü ����
		DmbCellPhone dmbCellPhone = new DmbCellPhone("�ڹ���", "����", 10);
		
		//CellPhone���κ��� ��ӹ��� �ʵ�
		System.out.println("��: "+ dmbCellPhone.model);
		System.out.println("����: "+ dmbCellPhone.color);
		
		//DmbCellPhone�� �ʵ�
		System.out.println("ä��: "+ dmbCellPhone.channel);
		
		//CellPhone���κ��� ��ӹ��� �޼ҵ� ȣ��
		dmbCellPhone.powerOn();
		dmbCellPhone.powerOff();
		dmbCellPhone.sendVoice("��������");
		dmbCellPhone.receiveVoice("�ȳ��ϼ���! ȫ�浿�Դϴ�.");
		dmbCellPhone.sendVoice("��~ �� �ݰ����ϴ�.");
		dmbCellPhone.hangUp();
		
		//dmbCellPhone�� �޼ҵ� ȣ��
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(77);
		dmbCellPhone.turnOffDmb();
	}

}
