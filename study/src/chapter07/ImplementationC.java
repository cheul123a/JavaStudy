package chapter07;

public class ImplementationC implements InterfaceC {

	@Override
	public void methodA() {
		System.out.println("ImplementationC-methodA() 실행");
	}

	@Override
	public void methodB() {
		System.out.println("ImplementationB-methodB() 실행");
	}

	@Override
	public void methodC() {
		System.out.println("ImplementationA-methodC() 실행");
	}

}
