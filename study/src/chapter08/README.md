chapter08.

중첩 클래스와 중첩 인터페이스
====================================

## 중첩 클래스와 중첩 인터페이스란?
클래스가 여러 클래스와 관계를 맺는 경우에는 독립적으로 선언하는 것이 좋으나. 특정 클래스와 관계를 맺을 경우에는 관계 클래스를 클래스 내부에 선언하는 것이 좋다.

중첩 클래스(Nested Class)란 클래스 내부에 선언한 클래스를 말하는데, 중첩 클래스를 사용하면 두 클래스의 멤버들을 서로 쉽게 접근할 수 있다는 장점과 외부에는 불필요한 관계 클래스를 감춤으로써 코드의 복잡성을 줄일 수 있다.

    class ClassName{
      class NestedClassName{
      }
    }

인터페이스도 클래스 내부에 선언할 수 있다. 이런 인터페이스를 중첩 인터페이스라고 한다. 인터페이스를 클래스 내부에 선언하는 이유는 해당 클래스와 긴밀한 관계를 맺는 구현 클래스를 만들기 위해서이다.

		class ClassName{
			interface NestedInterfaceName{
			}
		}

중첩 인터페이스는 주로 UI 프로그래밍에서 이벤트를 처리할 목적으로 많이 활용된다. 예를 들어 안드로이드에서는 다음과 같이 View 클래스의 클릭 이벤트를 처리하는 구현 클래스를 만들 수 있도록 View 클래스 내부에 OnClickListener라는 중첩 인터페이스가 있다.

		public class View{
			public interface OnclickListener{
				public void onClick(View v);
			}
		}


## 중첩 클래스

중첩 클래스는 클래스 내부에 선언되는 위치에 따라서 두 가지로 분류된다. 클래스의 멤버로서 선언되는 중첩 클래스를 멤버 클래스라고 하고, 메소드 내부에서 선언되는 중첩 클래스를 로컬 클래스라고 한다.   
멤버 클래스는 클래스나 객체가 사용중이라면 언제든지 재사용이 가능하지만, 로컬 클래스는 메소드 실행 시에만 사용되고, 메소드가 실행 종료되면 없어진다.

멤버 클래스도 하나의 클래스이기 때문에 컴파일하면 바이트 코드 파일(.class)이 별도로 생성된다. 마이트 코드 파일의 이름은 다음과 같이 결정된다.

		A $ B .class		A = 바깥클래스  B = 멤버 클래스
		
로컬 클래스일 경우에는 다음과 같이 $1이 포함된 바이트 코드 파일이 생성된다.

		A $1 B .class

### 인스턴스 멤버 클래스

인스턴스 멤버 클래스는 static 키워드 없이 선언된 클래스를 말한다. 인스턴스 멤버 클래스는 인스턴스 필드와 메소드만 선언이 가능하고 정적 필드와 메소드는 선언할 수 없다.

		class A {
				class B {
						B() {}					//생성자
						int field1;				//인스턴스 필드
						//static int field2;		//정적 필드 (x)
						void method1(){}		//인스턴스 메소드
						//static void method2(){}	//정적 메소드 (x)
				}
		}
A 클래스 외부에서 인스턴스 멤버 클래스 B의 객체를 생성하려면 먼저 A 객체를 생성하고 B 객체를 생성해야 한다.

		A a = new A();
		A.B b = a.new B();
		b.field1 = 3;
		b.method1();

### 정적 멤버 클래스

정적 멤버 클래스는 static 키워드로 선언된 클래스를 말한다. 정적 멤버 클래스는 모든 종류의 필드와 메소드를 선언할 수 있다.

		
		class A{
			static class C {
				C(){}						//생성자
				int field1;				//인스턴스 필드
				static int field2;		//정적 필드
				void method1(){}			//인스턴스 메소드
				static void method2(){}			//정적 메소드
			}
		}

A 클래스 외부에서 정적 멤버 클래스 C의 객체를 생성하기 위해서는 A 객체를 생성할 필요가 없고, 다음과 같이 C 객체를 생성하면 된다.

		A.C c = new A.C();
		c.field1 = 3;						//인스턴스 필드 사용
		c.method1();						//인스턴스 메소드 호출
		A.C.field2 = 3;					//정적 필드 사용
		A.C.method2();					//정적 메소드 호출

### 로컬 클래스

중첩 클래스는 메소드 내에서도 선언할 수 있다. 이것을 로컬(local) 클래스라고 한다. 로컬 클래스는 접근 제한자(public, private) 및 static을 붙일 수 없다. 로컬 클래스는 메소드 내부에서만 사용되므로 접근을 제한할 필요가 없기 때문이다. 로컬 클래스 내부에는 인스턴스 필드와 메소드만 선언이 가능하고 정적 필드와 메소드는 선언할 수 없다.

		void method() {
			
			class D {
				D() {}						//생성자
				int field1;					//인스턴스 필드
				//static int field2;		//정적 필드 (x)
				void method1(){}				//인스턴스 메소드
				//static void method2(){}		//정적 메소드(x)
			}
			D d = new D();
			d.field1 = 3;
			d.method1();
		}

로컬 클래스는 메소드가 실행될 때 메소드 내에서 객체를 생성하고 사용해야 한다. 주로 다음과 같이 비동기 처리를 위해 스레드 객체를 만들 때 사용한다.

		void method() {
				class DownloadThread extends Thread {...}
				DownloadThread thread = new DownloadThread();
				thread.start();
		}
		

## 중첩 클래스의 접근 제한

### 바깥 필드와 메소드에서 사용 제한

멤버 클래스가 인스턴스 또는 정적으로 선언됨에 따라 바깥 클래스의 필드와 메소드에 사용 제한이 생긴다. 

	public class A {
		//인스턴스 필드
		B field1 = new B();
		C field2 = new C();
		
		//인스턴스 메소드
		void method2(){
			B var1 = new B();
			C var2 = new C();
		}
		
		//정적 필드 초기화
		static B field3 = new B();   //(x)
		static C field4 = new C();
		
		//정적 메소드
		static void method2(){
			B var1 = new B();					//(x)
			C var2 = new C();
		}
		
		//인스턴스 멤버 클래스
		class B{}
		//정적 멤버 클래스
		class C{}
		}
























