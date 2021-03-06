chapter07.

인터페이스
===================

## 인터페이스의 역할

자바에서 인터페이스(interface)는 객체의 사용 방법을 정의한 타입이다. 인터페이스는 객체의 교환성을 높여주기 때문에
다형성을 구현하는 매우 중요한 역할을 한다.

인터페이스는 개발 코드와 객체가 서로 통신하는 접점 역할을 한다. 개발 코드가 인터페이스의 메소드를 호출하면 인터페이스는 객체의 메소드를 호출시킨다. 그렇게 때문에 개발 코드는 객체의 내부 구조를 알 필요가 없고 인터페이스의 메소드만 알고 있으면 된다.

개발 코드가 직접 개체의 메소드를 호출하면 간단한데, 왜 중간에 인터페이스를 두는지 의문점이 생긴다. 그 이유는 개발 코드를 수정하지 않고, 사용하는 객체를 변경할 수 있도록 하기 위해서이다. 인터페이스는 하나의 객체가 아니라 여러 객체들과 사용이 가능하므로 어떤 객체를 사용하느냐에 따라서 실행 내용과 리턴값이 다를 수 있다.

## 인터페이스 선언
인터페이스 선언은 class 키워드 대신에 interface 키워드를 사용한다.

    public interface 인터페이스명 {...}

클래스는 필드, 생성자, 메소드를 구성 멤버로 가지는데 비해, 인터페이스는 상수와 메소드만을 구성 멤버로 가진다. 인터페이스는 객체로 생성할 수 없기 때문이다.

    interface 인터페이스명 {
      //상수
      타입 상수명 = 값;
      //추상 메소드
      타입 메소드명(매개변수,...);
      //디폴트 메소드
      default 타입 메소드명(매개변수,...){...}
      //정적 메소드     
      static 타입 메소드명(매개변수) {...}
    
    }

**상수 필드(Constant Field)***
인터페이스는 객체 사용 설명서이므로 런타임 시 데이터를 저장할 수 있는 필드를 선언할 수 없다. 그러나 상수 필드는 선언이 가능하다. 상수는 인터페이스에 고정된 값으로 런타임 시에 데이터를 바꿀 수 없다. 상수를 선언할 때에는 반드시 초기값을 대입해야 한다.

**추상 메소드(Abstract Method)**
추상 메소드는 객체가 가지고 있는 메소드를 설명한 것으로 호출할 때 어떤 매개값이 필요하고, 리턴 타입이 무엇인지만 알려준다. 실제 실행부는 객체(구현 객체)가 가지고 있다.

**디폴트 메소드(Default Method)**
디폴트 메소드는 인터페이스에 선언되지만 사실은 객체(구현 객체)가 가지고 있는 인스턴스 메소드라고 생각해야 한다.

**정적 메소드(Static Method)**
디폴트 메소드와는 달리 객체가 없어도 인터페이스만으로 호출이 가능하다.

### 상수 필드 선언
인터페이스는 데이터를 저장할 수 없기 때문에 데이터를 저장할 인스턴스 또는 정적 필드를 선언할 수 없다. 상수 필드만 선언할 수 있다. 상수는 public static final로 선언한다. 인터페이스에 모든 필드는 public static final의 특성을 갖는다.

    public static final 타입 변수명 = 값;
    
인터페이스 상수는 static {} 블록으로 초기화할 수 없기 때문에 반드시 선언과 동시에 초기값을 지정해야 한다. public, static, final을 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.

    public interface RemoteControl {
      public int MAX_VOLUME = 10;
      public int MIN_VOLUME = 0 ;
    }



### 추상 메소드 선언
인터페이스를 통해 호출된 메소드는 최종적으로 객체에서 실행된다. 그렇기 때문에 인터페이스의 메소드는 실행 블록이 필요 없는 추상 메소드로 선언한다. 추상 메소드는 리턴 타입, 메소드명, 매개 변수만 기술되고 중괄호 {}를 붙이지 않는 메소드를 말한다.

    public interface RemoteControl{
      public void turnOn();
      public void turnOff();
    }

public abstract를 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.


### 디폴트 메소드 선언
디폴트 메소드의 형태는 클래스의 인스턴스 메소드와 동일한데, default 키워드가 리턴 타입 앞에 붙는다. 디폴트 메소드는 public 특성을 갖기 때문에 public 을 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.

    default void setMute(...){
      ...
    }

### 정적 메소드 선언
정적 메소드의 형태는 클래스의 정적 메소드와 완전 동일하다. 정적 메소드는 public 특성을 갖기 때문에 public을 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.

    static void changeBattery(){
    system.out.println("건전지를 교환합니다.");
    }
    
## 인터페이스 구현
개발 코드가 인터페이스 메소드를 호출하면 인터페이스는 객체의 메소드를 호출한다. 객체는 인터페이스에서 정의된 추상 메소드와 동일한 메소드 이름, 매개 타입, 리턴 타입을 가진 실체 메소드를 가지고 있어야 한다. 이러한 객체를 인터페이스의 구현(implement) 객체라고 하고, 구현 객체를 생성하는 클래스를 구현 클래스라고 한다.


### 구현 클래스
구현 클래스는 보통의 클래스와 동일한데, 인터페이스 타입으로 사용할 수 있음을 알려주기 위해 클래스 선언부에 implements 키워드를 추가하고 인터페이스명을 명시해야 한다.

    public class 구현클래스명 implements 인터페이스명 {
        //인터페이스에 선언된 추상 메소드의 실체 메소드 선언
    }

그리고 인터페이스에 선언된 추상 메소드의 실체 메소드를 선언해야 한다. 

구현 클래스에서 인터페이스의 추상 메소드들에 대한 실체 메소드를 작성할 때 주의할 점은 인터페이스의 모든 메소드는 기본적으로 public 접근 제한을 갖기 때문에 public보다 더 낮은 접근 제한으로 작성할 수 없다. 만약 인터페이스에 선언된 추상 메소드에 대응하는 실체 메소드를 구현 클래스가 작성하지 않으면 구현 클래스는 자동적으로 추상 클래스가 된다. 그렇기 때문에 클래스 선언부에 abstract 키워드를 추가해야 한다.

    public abstract class Television implements RemoteControl{
      public void turnOn() {...}
      public void turnOff() {...}   //(setVolume() 실체 메소드가 없다. (일부만 구현)
    }


구현 클래스가 작성되면 new 연산자로 객체를 생성할 수 있다. 문제는 어떤 타입의 변수에 대입하느냐이다. 다음과 같이 Television 변수에 대입한다고 인터페이스를 사용하는 것이 아니다.

    Television tv = new Television();
    

인터페이스로 구현 객체를 사용하려면 다음과 같이 인터페이스 변수를 선언하고 구현 객체를 대입해야 한다. 인터페이스 변수는 참조 타입이기 때문에 구현 객체가 대입될 경우 구현 객체의 번지를 저장한다.

    인터페이스 변수 = 구현객체;

RemoteControl 인터페이스로 구현 객체인 Television과 Audio를 사용하려면 다음과 같이 RemoteControl 타입 변수를 선언하고 구현 객체를 대입해야 한다.

    public static void main(String[] args) {
		  RemoteControl rc;
		  rc = new Television();
		  rc = new Audio();
	  }


### 익명 구현 객체

구현 클래스를 만들어 사용하는 것이 일반적이고, 클래스를 재사용할 수 있기 때문에 편리하지만, 일회성의 구현 객체를 만들기 위해 소스 파일을 만들고 클래스를 선언하는 것은 비효율적이다.

자바는 소스 파일을 만들지 않고도 구현 객체를 만들 수 있는 방법을 제공하는데, 그것이 익명 구현 객체이다. 자바는 UI 프로그래밍에서 이벤트를 처리하기 위해, 그리고 임시 작업 스레드를 만들기 위해 익명 구현 객체를 많이 활용한다.

    인터페이스 변수 = new 인터페이스() {
    //인터페이스에 선언된 추상 메소드의 실체 메소드 선언
    };

new 연산자 뒤에는 클래스 이름이 와야하는데, 이름이 없다. 인터페이스() {}는 인터페이스를 구현해서 중괄호 {}와 같이 클래스를 선언하라는 뜻이고, new 연산자는 이렇게 선언된 클래스를 객체로 생성한다. 중괄호 {}에는 인터페이스에 선언된 모든 추상 메소드들의 실체 메소드를 작성해야 한다.   
추가적으로 필드와 메소드를 선언할 수 있지만, 익명 객체 안에서만 사용할 수 있고 인터페이스 변수로 접근할 수 없다.

### 다중 인터페이스 구현 클래스

객체는 다음과 같이 다수의 인터페이스 타입으로 사용할 수 있다.

    public class 구현클래스명 implements 인터페이스A, 인터페이스B{
        //인터페이스 A에 선언된 추상 메소드의 실체 메소드 선언
        //인터페이스 B에 선언된 추상 메소드의 실체 메소드 선언
    }

인터페이스 A와 인터페이스 B가 객체의 메소드를 호출할 수 있으려면 객체는 이 두 인터페이스를 모두 구현해야 한다. 만약 하나라도 없으면 추상 클래스로 선언해야 한다.


## 인터페이스 사용

인터페이스로 구현 객체를 사용하려면 다음과 같이 인터페이스 변수를 선언하고 구현 객체를 대입해야 한다. 인터페이스 변수는 참조 타입이기 때문에 구현 객체가 대입될 경우 구현 객체의 번지를 저장한다.

    인터페이스 변수 = 구현객체;

RemoteControl 인터페이스로 구현 객체인 Television과 Audio를 사용하려면 다음과 같이 RemoteControl 타입 변수를 선언하고 구현 객체를 대입해야 한다.

    public static void main(String[] args) {
		  RemoteControl rc;
		  rc = new Television();
		  rc = new Audio();
	  }

개발 코드에서 인터페이스는 클래스의 필드, 생성자 또는 메소드의 매개 변수, 생성자 또는 메소드의 로컬 변수로 선언될 수 있다.

    public class MyClass {
        //필드
        RemoteControl rc = new Television();
        
        //생성자
        MyClass(RemoteControl rc) {
        this.rc = rc;
        }
        
        //메소드
        void methodA(){
          //로컬변수
          RemoteControl rc = new Audio();
        }
        void methodB(RemoteControl rc) {...}
    }

### 추상 메소드 사용
구현 객체가 인터페이스 타입에 대입되면 인터페이스에 선언된 추상 메소드를 개발 코드에서 호출할 수 있게 된다. 

    RemoteControl rc = new Television();
    rc.turnOn();    //Television의 turnOn() 실행
    rc.turnOff();   //Television의 turnOff() 실행


### 디폴트 메소드 사용
디폴트 메소드는 인터페이스에 선언되지만, 인터페이스에서 바로 사용할 수 없다. 디폴트 메소드는 추상 메소드가 아닌 인스턴스 메소드이므로 구현 객체가있어야 할수있다. 예를 들어 RemoteControl 인터페이스는 setMute()라는 디폴트 메소드를 가지고 있지만, 이 메소드를 다음과 같이 호출할 수는 없다.
    
    RemoteControl.setMute(true);

setMute() 메소드를 호출하려면 RemotedControl의 구현 객체가 필요한데, 다음과 같이 Television 객체를 인터페이스 변수에 대입하고 나서 setMute()를 호출할 수 있다.

    RemoteControl rc = new Television();
    rc.setMute(true);
    
디폴트 메소드는 인터페이스의 모든 구현 객체가 가지고 있는 기본 메소드라고 생각하면 된다. 그러나 어떤 구현 객체는 디폴트 메소드의 내용이 맞지 않아 수정이 필요할 수도 있다. 구현 클래스를 작성할 때 디폴트 메소드를 재정의해서 자신에게 맞게 수정하면 디폴트 메소드가 호출될 때 자신을 재정의한 메소드가 호출된다.


### 정적 메소드 사용

인터페이스의 정적 메소드는 인터페이스로 바로 호출이 가능하다.

    RemoteControl.changeBattery();


## 타입 변환과 다형성

인터페이스도 다형성을 구현하는 기술이 사용된다. 다형성은 하나의 타입에 대입되는 객체에 따라서 실행 결과가 다양한 형태로 나오는 성질을 말한다.
부모 타입에 어떤 자식 객체를 대입하느냐에 따라 실행 결과가 달라지듯이, 인터페이스 타입에 어떤 구현 객체를 대입하느냐에 따라 실행 결과가 달라진다.

프로그램을 개발할 때 인터페이스를 사용해서 메소드를 호출하도록 코딩을 했다면, 구현 객체를 교체하는 것은 매우 손쉽고 빠르게 할 수 있다. 프로그램 소스 코드는 변함이 없는데, 구현 객체를 교체함으로써 프로그램의 실행 결과가 다양해진다.

A 클래스를 이용해서 프로그램을 개발한다고 가정해보자. 개발 완료 후, 전체 프로그램을 테스트해보니 A 클래스에 문제가 있어 원하는 실행 결과가 나오지 않는다. 그래서 B 클래스로 바꾸기고 했다. 하지만 B 클래스의 메소드는 A 클래스의 메소드와 이름, 매개 변수가 다르다. 어쩔 수 없이 A 클래스의 메소드가 사용된 곳을 찾아서 B클래스의 메소드로 변경해야 한다. 만약 A 클래스와 B 클래스의 메소드 선언부(리턴타입, 메소드명, 매개변수)가 동일하다면 어떻게 될까? 메소드 호출 방법이 동일하므로 메소드 호출 코드는 수정할 필요 없이 객체 생성 부분만 A 클래스에서 B 클래스로 바꾸기만 하면 된다. 문제는 A, B 클래스를 설계할 때 메소드 선언부를 완전히 동일하게 설계할 수 있느냐이다. 이 문제를 해결하려면 인터페이스를 작성하고 A, B 클래스는 구현 클래스로 작성하면 된다.

인터페이스는 메소드의 매개 변수로 많이 등장한다. 인터페이스 타입으로 매개 변수를 선언하면 메소드 호출 시 매개 값으로 여러 가지 종류의 구현 객체를 줄 수 있기 때문에 메소드 실행 결과가 다양하게 나온다.

### 자동 타입 변환(Promotion)

구현 객체가 인터페이스 타입으로 변환되는 것은 자동 타입 변환에 해당한다. 자동 타입 변환은 프로그램 실행 도중에 자동적으로 타입 변환이 일어나는 것을 말한다. 인터페이스 구현 클래스를 상속해서 자식 클래스를 만들었다면 자식 객체 역시 인터페이스 타입으로 자동타입 변환시킬 수 있다.

### 필드의 다형성

<img src = "https://t1.daumcdn.net/cfile/tistory/2535B84F55E3DAAD2B"></img>

한국 타이어와 금호 타이어는 공통적으로 타이어 인터페이스를 구현했기 때문에 모두 타이어 인터페이스에 있는 메소드를 가지고 있다. 따라서 타이어 인터페이스로 동일하게 사용할 수 있는 교체 가능한 객체에 해당한다.

자동차를 설계할 때 다음과 같이 필드 타입으로 타이어 인터페이스를 선언하게 되면 필드값으로 한국 타이어 또는 금호 타이어 객체를 대입할 수 있다.

    public class Car{
      Tire frontLeftTire = new HankookTire();
      Tire frontRightTire = new HankookTire();
      Tire backLeftTire = new HankookTire();
      Tire backRightTire = new HankookTire();
    }

자동 타입 변환이 일어나기 때문에 아무런 문제가 없다. Car 객체를 생성한 후, 초기값으로 대입한 구현 객체 대신 다른 구현 객체를 대입할 수도 있다. 이것이 타이어 교체에 해당한다.

    Car myCar = new Car();
    myCar.frontLeftTire = new KumhoTire();
    myCar.frontRightTire = new KumhoTire();
    
frontLeftTire와 frontRightTire에 어떠한 타이어 구현 객체가 저장되어도 Car 객체는 타이어 인터페이스에 선언된 메소드만 사용하므로 전혀 문제가 되지 않는다.


### 인터페이스 배열로 구현 객체 관리
이전 예쩨에서는 Car 클래스에서 4개의 타이어 필드를 인터페이스로 각각 선언했지만 다음과 같이 인터페이스 배열로 관리할 수도 있다.

    Tire[] tires = {
      new HankookTire(),
      new HankookTire(),
      new HankookTire(),
      new HankookTire()
    };

frontLeftTire는 tire[0], frontRightTire는 tires[1], backLeftTire는 tires[2], backRightTire는 tires[3]과 같이 인덱스로 표현되므로 대입이나 제어문에서 활용하기 매우 쉽다. 예를 들어 인덱스 1을  이용해서 앞오른쪽 타이어를 KumhoTire로 교체하기 위해 다음과 같이 작성할 수 있다.

    tires[1] = new KumhoTire();

tires 배열의 각 항목은 Tire 인터페이스 타입이므로, 구현 객체인 KumhoTire를 대입하면 자동 타입 변환이 발생하기 때문에 아무런 문제가 없다.
구현 객체들을 배열로 관리하면 제어문에서 가장 많은 혜택을 본다.


    void run() {
      for(Tire tire : tires){
        tire.roll();
      }
    }

### 매개 변수의 다형성
자동 타입 변환은 필드의 값을 대입할 때에도 발생하지만, 주로 메소드를 호출할 때 많이 발생한다. 매개값을 다양화하기 위해서 상속에서는 매개 변수를 부모 타입으로 선언하고 호출할 때에는 자식 객체를 대입했었다. 이번에는 매개 변수를 인터페이스 타입으로 선언하고 호출할 때에는 구현 객체를 대입한다.   

예를 들어 Driver 클래스에는 drive() 메소드가 정의되어 있는데 Vehicle 타입의 매개 변수가 선언되어 있다.

    public class Driver {
        public void drive(Vehicle vehicle) {
          vehicle.run();
        }
    }

Vehicle을 다음과 같이 인터페이스 타입이라고 가정해보자.

    public interface Vehicle {
        public void run();
    }

만약 Bus가 구현 클래스라면 다음과 같이 Driver의 drive() 메소드를 호출할 때 Bus 객체를 생성해서 매개값으로 줄 수 있다.

    driver.drive(bus);     //자동 타입 변환 발생

drive() 메소드는 Vehicle 타입을 매개 변수로 선언했지만, Vehicle을 구현한 Bus 객체가 매개값으로 사용되면 자동 타입 변환이 발생한다.

매개 변수의 타입이 인터페이스일 경우, 어떠한 구현 객체도 매개값으로 사용할 수 있고, 어떤 구현 객체가 제공되느냐에 따라 메소드의 실행 결과는 다양해질 수 있다.

### 강제 타입 변환(Casting)
구현 객체가 인터페이스 타입으로 자동 변환하면, 인터페이스에 선언된 메소드만 사용 가능하다는 제약 사항이 따른다. 예를 들어 인터페이스에는 세 개의 메소드가 선언되어 있고, 클래스에는 다섯개의 메소드가 선언되어 있다면, 인터페이스로 호출 가능한 메소드는 세 개뿐이다.   

하지만 경우에 따라서 구현 클래스에 선언된 필드와 메소드를 사용해야 할 경우도 발생한다. 이때 강제 타입 변환을 해서 다시 구현 클래스 타입으로 변환한 다음, 구현 클래스의 필드와 메소드를 사용할 수 있다.


		interface Vehicle {
			void run();
		}
		
		class Bus implements Vehicle {
			void run() {...}
			voidr checkFare() {...}
		}
		
		Vehicle vehicle = new Bus();
		vehicle.run();					//가능
		vehicle.checkFare();				//불가능
		
		Bus bus = (bus)vehicle;
		bus.run();							//가능
		bus.checkFare();						//가능


### 객체 타입 확인(instanceof)
강제 타입 변환은 구현 객체가 인터페이스 타입으로 변환되어 있는 상태에서 가능하다. 그러나 어떤 구현 객체가 변환되어 있는지 알 수 없는 상태에서 무작정 변환을 할 경우 예외가 발생할 수도 있다.

		Vehicle vehicle = new Taxi();
		Bus bus = (Bus)vehicle;
		//구현 클래스 타입이 다르므로 ClassCastException이 발생

메소드의 매개 변수가 인터페이스로 선언된 경우, 메소드를 호출할 때 다양한 구현 객체들을 매개값으로 지정할 수 있다. 어떤 구현 객체가 지정될지 모르는 상황에서 다음과 같이 매개값을 Bus로 강제 타입 변환하면 ClassCastException이 발생할 수 있다.

		public void drive(Vehicle vehicle){
			Bus bus = (Bus)vehicle;
			bus.checkFare();
			vehicle.run();
		}

이 경우 상속에서 객체 타입을 확인하기 위해 instanceof 연산자를 사용했던거와 같이 인터페이스 타입에서도 instanceof 연산자를 사용하면 된다.

		if(vehicle instanceof Bus) {
			Bus bus = (Bus)vehicle
		}

인터페이스 타입으로 자동 변환된 매개값을 메소드 내에서 다시 구현 클래스 타입으로 강제 타입 변환해야 한다면 반드시 매개값이 어떤 객체인지 instanceof 연산자로 확인하고 안전하게 강제 타입 변환을 해야한다.


## 인터페이스 상속

인터페이스도 다른 인터페이스를 상속할 수 있다. 인터페이스는 클래스와는 달리 다중 상속을 허용한다.

		public interface 하위인터페이스 extends 상위인터페이스1, 상위인터페이스2 {...}

하위 인터페이스를 구현하는 클래스는 하위 인터페이스의 메소드뿐만 아니라 상위 인터페이스의 모든 추상 메소드에 대한 실체 메소드를 가지고 있어야 한다.그렇기 때문에 구현 클래스로부터 객체를 생성하고 나서 다음과 같이 하위 및 상위 인터페이스 타입으로 변환이 가능하다.

		 하위인터페이스 변수 = new 구현클래스(...);
		 하위인터페이스1 변수 = new 구현클래스(...);
		 하위인터페이스2 변수 = new 구현클래스(...);

하위 인터페이스로 타입 변환이 되면 상, 하위 인터페이스에 선언된 모든 메소드를 사용할 수 있으나, 상위 인터페이스로 타입 변환되면ㅁ 상위 인터페이스에 선언된 메소드만 사용 가능하고 하위인터페이스에 선언된 메소드는 사용할 수 없다.


## 디폴트 메소드와 인터페이스 확장

디폴트 메소드는 인터페이스에 선언된 인스턴스 메소드이기 때문에 구현 객체가 있어야 사용할 수 있다. 선언은 인터페이스에서 하고, 사용은 구현 객체를 통해 한다는 것이 어색해 보인다. 디폴트 메소드는 모든 구현 객체에서 공유하는 기본 메소드처럼 보이지만, 사실은 인터페이스에서 디폴트 메소드를 허용한 다른 이유가 있다.


### 디폴트 메소드의 필요성

인터페이스에서 디폴트 메소드를 허용한 이유는 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해서이다. 기존 인터페이스의 이름과 추상 메소드의 변경 없이 디폴트 메소드만 추가할 수 있기 때문에 이전에 개발한 구현 클래스를 그대로 사용할 수 있으면서 새롭게 개발하는 클래스는 디폴트 메소드를 활용할 수 있다.


### 디폴트 메소드가 있는 인터페이스 상속

부모 인터페이스에 디폴트 메소드가 정의되어 있을 경우, 자식 인터페이스에서 디폴트 메소드를 활용하는 방법은 다음 세가지가 있다.   

+ 디폴트 메소드를 단순히 상속만 받는다.
+ 디폴트 메소드를 재정의해서 실행 내용을 변경한다.
+ 디폴트 메소드를 추상 메소드로 재선언한다.

다음과 같이 추상 메소드와 디폴트 메소드가 선언된 ParentInterface가 있다고 가정해보자.

		public interface ParentInterface{
			public void method1();
			public default void method2() {실행문}
		}

다음 ChildInterface1은 ParentInterface를 상속하고 자신의 추상 메소드인 method3()을 선언한다.

		public interface ChildInterface1 extends ParentInterface{
			public void method3();
		}

이 경우 ChildInterface1 인터페이스를 구현하는 클래스는 method1()과 method3()의 실체 메소드를 가지고 있어야 하며 ParentInterface의 method2()를 호출할 수 있다.

		ChildInterface c1 = new ChildInterface1() {
				@Override
				public void method1() {실행문}
				@Override
				public void method3() {실행문}
		};
		
		c1.method1();
		c1.method2();
		c1.method3();
		}

다음 ChildInterface2는 ParentInterface를 상속하고 ParentInterface의 디폴트 메소드인 method2()를 재정의한다. 그리고 자신의 추상 메소드인 method3()을 선언한다.

		public interface ChildInterface2 extends ParentInterface {
				@Override
				public default void method2() {실행문}		//재정의
				
				public void method3();
		}

이 경우도 ChildInterface2 인터페이스를 구현하는 클래스는 method1()과 method3()의 실체 메소드를 가지고 있어야 하며, ChildInterface2에서 재정의한 method2()를 호출할 수 있다.


		ChildInterface2 ci2 = new ChildInterface2(){
				@Override
				public void method1() {실행문}
				@Override
				public void method3() {실행문}
		};
	  
		ci2.method1();
		ci2.mehotd2();			//ChildInterface2의 method2() 호출
		ci2.method3();

다음 childInterface3은 ParentInterface를 상속하고 ParentInterface의 디폴트 메소드인 mehtod2()를 추상 메소드로 재선언한다. 그리고 자신의 추상 메소드인 method3()을 선언한다.

		public interface ChildInterface3 extends ParentInterface {
				@Override
				public void method2();
				public void method3();
		}

이 경우 ChildInterface3 인터페이스를 구현하는 클래스는 method1()과 method2(), method3()의 실체 메소드를 모두 가지고 있어야 한다.

		ChildInterface3 ci3 = new ChildInterface3(){
				@Override
				public void method1() {실행문}
				@Override
				public void method2() {실행문}
				@Override
				public void method3() {실행문}
		};
		
		ci3.method1();
		ci3.method2();					//ChildInterface3 구현 객체의 method2()호출
		ci3.method3();




































