package chapter07;

public class ImplementationC implements InterfaceC {

	@Override
	public void methodA() {
		System.out.println("ImplementationC-methodA() ����");
	}

	@Override
	public void methodB() {
		System.out.println("ImplementationB-methodB() ����");
	}

	@Override
	public void methodC() {
		System.out.println("ImplementationA-methodC() ����");
	}

}
