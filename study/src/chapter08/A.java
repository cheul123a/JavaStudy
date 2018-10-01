package chapter08;

public class A {
	A(){ System.out.println("A 按眉啊 积己凳"); }
	
	class B{
		B() { System.out.println("B 按眉啊 积己凳"); }
		int field1;
		//static int field2; 	 牢胶畔胶 糕滚父 积己啊瓷
		void method1() { }
		//static void method2() { }
	}
	
	static class C {
		C() { System.out.println("C 按眉啊 积己凳"); }
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	void method() {
		class D{
			D() { System.out.println("D 按眉啊 积己凳"); }
			int field1;
			//static int field2;
			void method1() {System.out.println("D 按眉 皋家靛 角青 field1 = " + field1);}
			//static void method2 () {}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();		
	}
	
	
	
}
