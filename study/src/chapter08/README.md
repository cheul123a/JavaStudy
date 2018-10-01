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


인스턴스 멤버 클래스(B)는 바깥 클래스의 인스턴스 필드(field1)의 초기값이나 인스턴스 메소드(method1())에서 객체를 생성할 수 있으나, 정적 필드(field3)의 초기값이나 정적 메소드(method2())에서는 객체를 생성할 수 없다. 반면 정적 멤버 클래스(C)는 모든 필드의 초기값이나 모든 메소드에서 객체를 생성할 수 있다.

### 멤버 클래스에서 사용 제한

멤버 클래스가 인스턴스 또는 정적으로 선언됨에 따라 멤버 클래스 내부에서 바깥 클래스의 필드와 메소드를 접근할 때에도 제한이 따른다. 

		public class A{
			int field1;
			void method1(){ }
			
			static int field2;
			static void method2(){ }
			
			class B {
				void method() {
					field1 = 10;
					method1();
					
					field2 = 10;
					method2();
					//모든 필드와 메소드에 접근가능
				}
			}
			
			static class C(){
				void method() {
					field1 = 10;		//(x)
					method1();			//(x)
					//인스턴스 필드와 메소드는 접근 불가
					
					field2 = 10;
					method2();
				}
			}
			
		}

### 로컬 클래스에서 사용 제한

로컬 클래스 내부에서는 바깥 클래스의 필드나 메소드를 제한 없이 사용할 수 있다. 문제는 메소드의 매개 변수나 로컬 변수를 로컬 클래스에서 사용할 때이다. 로컬 클래스의 객체는 메소드 실행이 끝나도 힙 메모리에 존재해서 계속 사용될 수 있다. 매개 변수나 로컬 변수는 메소드 실행이 끝나면 스택 메모리에서 사라지기 때문에 로컬 객체에서 사용할 경우 문제가 생긴다.	

자바는 이 문제를 해결하기 위해 컴파일 시 로컬 클래스에서 사용하는 매개 변수나 로컬 변수의 값을 로컬 클래스 내부에 복사해 두고 사용한다. 그리고 매개 변수나 로컬 변수가 수정되어 값이 변경되면 로컬 클래스에 복사해 둔 값과 달라지는 문제를 해결하기 위해 매개 변수나 로컬 변수를 final로 선언해서 수정을 막는다.

결론적으로 로컬 클래스에서 사용 가능한 것은 final로 선언된 매개 변수와 로컬 변수뿐이라는 것이다. 자바 7 이전까지는 final 키워드 없이 선언된 매개 변수나 로컬 변수를 로컬 클래스에서 사용하면 컴파일 에러가 발생했다. 하지만 자바 8 부터는 final 키워드 없이 선언할 경우 로컬 클래스의 필드로 복사되고 final 키워드가 존재 하면 로컬 클래스의 메소드 내부에 지역 변수로 복사된다.

		public class Outter {
			//자바 7 이전
			public void method1(final int arg){
				final int localVariable = 1;
				//arg = 100 ; (x)
				//localVariable = 100; (x)
				class Inner {
					public void method(){
						int result = arg + localVariable;
					}
				}
			}
			
			//자바 8 이후
			public void method2(int arg){
				int localVariable = 1;
				//arg = 100;
				// localVariable = 100;
				class Inner{
					public void method() {
						int result = arg + localVariable;
					}
				}
			}
		}


### 중첩 클래스에서 바깥 클래스 참조 얻기

클래스 내부에서 this는 객체 자신의 참조이다. 중첩 클래스에서 this 키워드를 사용하면 바깥 클래스의 객체 참조가 아니라, 중첩 클래스의 객체 참조가 된다. 따라서 중첩 클래스 내부에서 this.필드, this.메소드()로 호출하면 중첩 클래스의 필드와 메소드가 사용된다. 중첩 클래스 내부에서 바깥 클래스의 객체 참조를 얻으려면 바깥 클래스의 이름을 this 앞에 붙여주면 된다.

		바깥클래스.this.필드
		바깥클래스.this.필드
		

## 중첩 인터페이스

중첩 인터페이스는 클래스의 멤버로 선언된 인터페이스를 말한다. 인터페이스를 클래스 내부에 선언하는 이유는 해당 클래스와 긴밀한 관계를 맺는 구현 클래스를 만들기 위해서이다. 특히 UI 프로그래밍에서 이벤트를 처리할 목적으로 많이 활용된다.

		class A {
			interface I{
				void method();
			}
		}

예를 들어 Button을 클릭했을 때 이벤트를 처리하는 객체를 받고 싶다고 가정해보자. 그렇다고 아무 객체나 받으면 안되고, Button 내부에 선언된 중첩 인터페이스를 구현한 객체만 받아야 한다면 다음과 같이 Button 클래스를 선언하면 된다.

		public class Button{
			OnClickListener listener;
			
			void setOnClickListener(OnClickListener listener) {
				this.listener = listener;
			}
			
			void touch(){
				listener.onClick();
			}
			
			interface OnClickListener{
				void onClick();
			}
		}

Button 클래스 내용을 보면 중첩 인터페이스 타입으로 필드를 선언하고 Setter 메소드로 구현 객체를 받아 필드에 대입한다. 버튼 이벤트가 발생했을 때 인터페이스를 통해 구현 객체의 메소드를 호출한다.

		public class CallListener implements Button.OnClickListener {
			@Override
			public void onClick(){
				system.out.println("전화를 겁니다.");
			}
		}

		public class ButtonExample{
			public static void main(String[] args){
				Button btn = new Button();
				
				btn.setOnClickListener(new CallListener());
				btn.touch();
			}
		}

## 익명 객체
익명(anonymous) 객체는 이름이 없는 객체를 말한다. 익명 객체는 단독으로 생성할 수 없고 클래스를 상속하거나 인터페이스를 구현해야만 생성할 수 있다. 익명 객체는 필드의 초기값이나 로컬 변수의 초기값, 매개 변수의 매개값으로 주로 대입된다. UI 이벤트 처리 객체나 스레드 객체를 간편하게 생성할 목적으로 익명 객체가 많이 활용된다.

### 익명 자식 객체 생성
부모 타입으로 필드나 변수를 선언하고, 자식 객체를 초기값으로 대입할 경우를 생각해보자. 우선 부모 클래스를 상속해서 자식 클래스를 선언하고, new 연산자를 이용해서 자식 객체를 생성한 후, 필드나 로컬 변수에 대입하는 것이 기본이다.

		class Child extends Parent { }  ---자식 클래스 선언
		
		class A{
			Parent field = new Child();		---필드에 자식 객체를 대입
			void method(){
				Parent localVar = new Child(); ---로컬 변수에 자식 객체를 대입
			}
		}

그러나 자식 클래스가 재사용되지 않고, 오로지 해당 필드와 변수의 초기값으로만 사용할 경우라면 익명 자식 객체를 생성해서 초기값으로 대입하는 것이 좋은 방법이다. 익명 자식 객체를 생성하는 방법은 다음과 같다. 주의할 점은 하나의 실행문이므로 끝에는 세미콜론(;)을 반드시 붙여야 한다.

    부모클래스 [필드 | 변수] = new 부모클래스(매개값, ...){
			//필드
			//메소드
		};

부모 클래스(매개값, ...){}은 부모 클래스를 상속해서 중괄호 {}와 같이 자식 클래스를 선언하라는 뜻이고, new 연산자는 이렇게 선언된 자식 클래스를 객체로 생성한다. 부모 클래스(매개값, ...)은 부모 생성자를 호출하는 코드로, 매개값은 부모 생성자의 매개 변수에 맞게 입력하면 된다. 중괄호 {} 내부에는 필드나 메소드를 선언하거나 부모 클래스의 메소드를 재정의 하는 내용이 온다. 일반 클래스와의 차이점은 생성자를 선언할 수 없다는 것이다. 

다음 코드는 필드를 선언할 때 초기값으로 익명 자식 객체를 생성해서 대입한다.

		class A {
			Parent field = new Parent(){
				int childField;
				void childMethod(){ }
				@Override
				void parentMethod(){ }
			};
		}

다음 코드는 메소드 내에서 로컬 변수를 선언할 때 초기값으로 익명 자식 객체를 생성해서 대입한다.

		class A {
			void method(){
				Parent localVar = new Parent(){
					int childField;
					void childMethod() { }
					@Override
					void parentMethod() { }
				};
			}
		}

메소드의 매개 변수가 부모 타입일 경우 메소드 호출 코드에서 익명 자식 객체를 생성해서 매개값으로 대입할 수도 있다.

    class A {
			void method1(Parent parent){}
			void method2(){
				method1(
					new Parent() {
						int childField;
						void childMethod(){}
						@Override
						void parent Method(){}
					}
				);
			}
		}

익명 자식 객체에 새롭게 정의된 필드와 메소드는 익명 자식 객체 내부에서만 사용되고, 외부에서는 필드와 메소드에 접근할 수 없다. 왜냐하면 익명 자식 객체는 부모 타입 변수에 대입되므로 부모 타입에 선언된 것만 사용할 수 있기 때문이다. 

		class A {
			Parent field = new Parent(){
				int childField;
				void childMethod() {}
				@Override
				void parentMethod(){
					childField = 3;
					childMethod();
				}
			};
			
			void method(){
				field.childField = 3;
				field.childMethod();
				field.parentMethod();
			}
		}


### 익명 구현 객체 생성
이번에는 인터페이스 타입으로 필드나 변수를 선언하고, 구현 객체를 초기값으로 대입하는 경우를 생각해보자. 우선 구현 클래스를 선언하고, new 연산자를 이용해서 구현 객체를 생성한 후, 필드나 로컬 변수에 대입하는 것이 기본이다.

		class TV implements RemoteControl {  }
		
		class A {
			RemoteControl field = new TV();  --------- 필드에 구현 객체를 대입
			void method(){
				RemoteControl localVar = new TV(); ----- 로컬 변수에 구현 객체를 대입
			}
		}

그러나 구현 클래스가 재사용되지 않고, 오로지 해당 필드와 변수의 초기값으로만 사용하는 경우라면 익명 구현 객체를 초기값으로 대입하는 것이 좋다.

		 인터페이스 [필드|변수] = new 인터페이스() {
		 		//인터페이스에 선언된 추상 메소드의 실체 메소드 선언
				//필드
				//메소드
		 }

인터페이스() {}는 인터페이스를 구현해서 중괄호 {}와 같이 클래스를 선언하라는 뜻이고, new 연산자는 이렇게 선언된 클래스를 객체로 생성한다. 중괄호 {}에는 인터페이스에 선언된 모든 추상 메소드들의 실체 메소드를 작성해야 한다. 그렇지 않으면 컴파일 에러가 발생한다. 추가적으로 필드와 메소드를 선언할 수 있지만, 실체 메소드에서만 사용이 가능하고 외부에서는 사용하지 못한다.

다음은 필드를 선언할 때 초기값으로 익명 구현 객체를 생성해서 대입하는 예이다.

		class A {
			RemoteControl field = new RemoteControl() {
				@Override
				void turnOn() { }
			};
		}
		
다음은 메소드 내에서 로컬 변수를 선언할 때 초기값으로 익명 구현 객체를 생성해서 대입하는 예이다.
		
		void method(){
			RemoteControl localVar = new RemoteControl(){
				@Override
				void turnOn(){}
			};
		}
		
메소드의 매개 변수가 인터페이스 타입일 경우, 메소드 호출 코드에서 익명 구현 객체를 생성해서 매개값으로 대입할 수도 있다.

		class A {
			void method1(RemoteControl rc){ }
			
			void method2(){
				method1(
				new RemoteControl(){
					@Override
					void turnOn(){}
					}
				);
			}
		}
		






































