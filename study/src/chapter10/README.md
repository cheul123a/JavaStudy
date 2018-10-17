chapter10.

기본 API 클래스
===============================

## 자바 API 도큐먼트

지금까지 자바 언어에 대해 학습했다면 이제 자바에서 제공하는 API(Application Programming Interface)를 배워야 할 차례다. API는 라이브러리(library)라고 부르기도 하는데, 프로그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음을 말한다. 우리가 사용해 왔던 String 클래스와 System 클래스도 모두 API에 속하는 클래스들이다. 이 API들은 JDK 설치 경로 \jre\lib\rt.jar 라는 암축 파일에 저장되어 있다.

API 도큐먼트는 쉽게 API를 찾아 이용할 수 있도록 문서화한 것을 말한다. API 도큐먼트는 HTML 페이지로 작성되어 있기 때문에 웹 브라우저를 열고 오라클에서 제공하는 다음 URL을 방문하면 볼 수 있다.

    http://docs.oracle.com/javase/8/docs/api/

## java.lang과 java.utill 패키지
자바 애플리케이션을 개발할 때 공통적으로 가장 많이 사용하는 패키지는 java.lang 패키지와 java.util, java.time 패키지일 것이다.

### java.lang 패키지
java.lang 패키지는 자바 프로그램의 기본적인 클래스를 담고 있는 패키지이다. 그렇기 때문에 java.lang 패키지에 있는 클래스와 인터페이스는 import 없이 사용할 수 있다. 지금까지 사용한 String과 System 클래스도 java.lang 패키지에 포함되어 있기 때문에 import하지 않고 사용했다.

다음은 java.lang 패키지에 속하는 주요 클래스와 간략한 용도에 대해 설명한 표이다.

<img src = "https://t1.daumcdn.net/cfile/tistory/2255EF495696F9372F"></img>

### java.util 패키지
java.util 패키지는 자바 프로그램 개발에 조미료 같은 역할을 하는 클래스를 담고 있다. java.util 패키지는 컬렉션 클래스들이 대부분을 차지하고 있다. 

<img src = "https://t1.daumcdn.net/cfile/tistory/234699495696F93807"></img>

## Object 클래스
클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Obejcet 클래스를 상속하게 된다. 따라서 자바의 모든 클래스는 Object 클래스의 자식이거나 자손 클래스이다. Object는 자바의 최상위 부모 클래스에 해당한다.

<img src = "https://t1.daumcdn.net/cfile/tistory/274E2D4A5697033327"></img>

Object 클래스는 필드가 없고, 메소드드로 구성되어 있다. 이 메소드들은 모든 클래스가 Object를 상속하기 때문에 모든 클래스에서 사용이 가능하다.

### 객체 비교(equals())
다음은 Object의 equals() 메소드이다.

		public boolean equals(Object obj) {...}

equals() 메소드의 매개 타입은 Object인데, 이것은 모든 객체가 매개값으로 대입될 수 있음을 말한다. 그 이유는 Object가 최상위 타입이므로 모든 객체는 Object 타입으로 자동 타입 변환될 수 있기 때문이다. Object 클래스의 equals() 메소드는 비교 연산자인 ==과 동일한 결과를 리턴한다. 두 객체가 동일한 객체라면 true를 리턴하고 그렇지 않으면 false를 리턴한다.

		Object obj1 = new Object();
		Object obj2 = new Object();
		
		boolean result = obj1.equals(obj2);
											↕결과가 동일하다. 
		boolean result = (obj == ojbj2)

자바에서는 두 객체를 동등 비교할 때 equals() 메소드를 흔히 사용한다. equals() 메소드는 두 객체를 비교해서 논리적으로 동등하면 true를 리턴하고, 그렇지 않으면 false를 리턴한다. 논리적으로 동등하다는 것은 같은 객체이건 다른 객체이건 상관없이 객체가 저장하고 있는 데이터가 동일함을 뜻한다.

예를 들어 String 객체의 equals() 메소드는 String 객체의 번지를 비교하는 것이 아니고, 문자열이 동일한지 조사해서 같다면 true를 리턴하고, 그렇지 않다면 false를 리턴한다. 이것이 가능한 이유는 String 클래스가 Object의 equals() 메소드를 재정의(오버라이딩)해서 번지 비교가 아닌 문자열 비교로 변경했기 때문이다.

Object의 equals() 메소드는 직접 사용되지 않고 하위 클래스에서 재정의하여 논리적으로 동등 비교할 때 이용된다. 예를 들어 Member 객체는 다르지만 id 필드값이 같으면 논리적으로 동등한 객체로 취급하고 싶을 경우 Object의 equals() 메소드를 재정의해서 id 필드값이 같음을 비교하면 된다.

equals() 메소드를 재정의할 때에는 매개값(비교 객체)이 기준 객체와 동일한 타입의 객체인지 먼저 확인해야 한다. Object 타입의 매개 변수는 모든 객체가 매개값으로 제공될 수 있기 때문에 instanceof 연산자로 기준 객체와 동일한 타입인지 제일 먼저 확인해야 한다. 만약 비교 객체가 다른 타입이라면 equals() 메소드는 false를 리턴해야 한다. 비교 객체가 동일한 타입이라면 기준 객체 타입으로 강제 타입 변환해서 필드값이 동일한지 검사하면 된다. 필드값이 모두 동일하다면 true를 리턴하고 그렇지 않으면 false를 리턴하도록 작성한다.


### 객체 해시코드(hashCode())
객체 해시코드란 객체를 식별할 하나의 정수값을 말한다. Object의 hashCode() 메소드는 객체의 메모리 번지를 이용해서 해시코드를 만들어 리턴하기 때문에 객체마다 다른 값을 가지고 있다. 논리적 동등 비교시 hashCode()를 오버라이딩할 필요성이 있는데, HashSet, HashMap,Hashtable은 다음과 같은 방법으로 두 객체가 동등한지 비교한다.

우선 hashCode() 메소드를 실행해서 리턴된 해시코드 값이 같은지를 본다. 해시코드 값이 다르면 다른 객체로 판단하고, 해시코드 값이 같으면 equals() 메소드로 다시 비교한다. 그렇기 때문에 hashCode() 메소드가 true가 나와도 equals()의 리턴값이 다르면 다른 객체가 된다.

<img src = "https://t1.daumcdn.net/cfile/tistory/231DCB4A569703352B"></img>


### 객체 문자 정보(toString())
Object 클래스의 toString() 메소드는 객체의 문자 정보를 리턴한다. 객체의 문자 정보란 객체를 문자열로 표현한 값을 말한다. 기본적으로 Object 클래스의 toString() 메소드는 "클래스명@16진수해시코드"로 구성된 문자 정보를 리턴한다.

		Object obj = new Object();
		System.out.println( obj.toString() );
		
		실행결과
		java.lang.Object@de6ced

Object의 toString() 메소드의 리턴값은 자바 애플리케이션에서는 별 값어치가 없는 정보이므로 Object 하위 클래스는 toString() 메소드를 재정의(오버라이딩)하여 간결하고 유익한 정보를 리턴하도록 되어 있다. 예를 들어 java.util 패키지의 Date 클래스는 toString() 메소드를 재정의하여 현재 시스템의 날짜와 시간 정보를 리턴한다. 그리고 String 클래스는 toString() 메소드를 재정의해서 저장하고 있는 문자열을 리턴한다.

우리는 지금까지 콘솔에 출력하기 위해 System.out.println() 메소드를 사용해 왔다. 이 메소드의 매개값은 콘솔에 출력할 내용인데, 매개값이 기본 타입(byte, double, boolean 등)일 경우, 해당 값을 그대로 출력한다. 만약 매개값으로 객체를 주면 객체의 toString() 메소드를 호출해서 리턴값을 받아 출력하도록 되어있다.

### 객체 복제(clone())
객체 복제는 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성하는 것을 말한다. 객체를 복제하는 이유는 원본 객체를 안전하게 보호하기 위해서이다. 신뢰하지 않는 영역으로 원본 객체를 넘겨 작업할 경우 원본 객체의 데이터가 훼손될 수 있기 때문에 복제된 객체를 만들어 신뢰하지 않는 영역으로 넘기는 것이 좋다. 복제된 객체의 데이터가 훼손되더라도 원본 객체는 아무런 영향을 받지 않기 때문에 안전하게 데이터를 보호할 수 있게 된다. 객체를 복제하는 방법에는 얕은 복제와 깊은 복제가 있다.

**얕은 복제(thin clone)**

얕은 복제(thin clone)란 단순히 필드값을 복사해서 객체를 복제하는 것을 말한다. 필드값만 복제하기 때문에 필드가 기본 타입일 경우 값 복사가 일어나고, 필드가 참조 타입일 경우에는 객체의 번지가 복사된다. 

예를 들어 원본 객체에 int 타입의 필드와 배열 타입의 필드가 있을 경우, 얕은복제된 객체의 필드값은 가음과 같다.

<img src = "https://t1.daumcdn.net/cfile/tistory/234F0D4F569725C104"></img>

Object의 clone() 메소드는 자신과 동일한 필드값을 가진 얕은 복제된 객체를 리턴한다. 이 메소드로 객체를 복제하려면 원본 객체는 반드시 java.lang.Cloneable 인터페이스를 구현하고 있어야한다. 메소드 선언이 없음에도 불구하고 Cloneable 인터페이스를 명시적으로 구현하는 이유는 클래스 설계자가 복제를 허용한다는 의도적인 표시를 하기 위해서이다. 클래스 설계자가 복제를 허용 하지 않는다면 Cloneable 인터페이스를 구현하지 않으면 된다. Cloneable 인터페이스를 구현하지 않으면 clone() 메소드를 호출할 때 CloneNotSupportedException 예외가 발생하여 복제가 실패된다. clone()은 CloneNotSupportedException 예외 처리가 필요한 메소드이기 때문에 try-catch 구문이 필요하다. 

		try {
			Object obj = clone();
		} catch(CloneNotSupportedException e) {  }



**깊은 복제(deep clone)**

얕은 복제(thin clone)의 경우 참조 타입 필드는 번지만 복제되기 때문에 원본 객체의 필드와 복제 객체의 필드는 같은 객체를 참조하게 된다. 만약 복제 객체에서 참조 객체를 변경하면 원본 객체도 변경된 객체를 가지게 된다. 이것이 얕은 복제의 단점이다.

얕은 복제의 반대 개념은 깊은 복제(deep clone)이다. 깊은 복제란 참조하고 있는 객체도 복제하는 것을 말한다. 다음 그림은 원본 객체를 깊은 복제했을 경우 참조하는 배열 객체도 복제된다는 것을 보여준다.

<image src = "https://t1.daumcdn.net/cfile/tistory/2674CF4F569725C333"></img>

깊은 복제를 하려면 Object의 clone() 메소드를 재정의해서 참조 객체를 복제하는 코드를 직접 작성해야 한다.

### 객체 소멸자(finalize())
참조하지 않는 배열이나 객체는 쓰레기 수집기(Garbage Collector)가 힙 영역에서 자동적으로 소멸시킨다. 쓰레기 수집기는 객체를 소멸하기 직전에 마지막으로 객체의 소멸자(finalize())를 실행시킨다. 

소멸자는 Object의 finalize() 메소드를 말하는데, 기본적으로 실행 내용이 없다. 만약 객체가 소멸되기 전에 마지막으로 사용했던 자원(데이터 연결, 파일 등)을 닫고 싶거나, 중요한 데이터를 저장하고 싶다면 Object의 finalize()를 재정의할 수 있다.

객체 소멸은 순서대로 일어나지 않고, 무작위로 일어난다. 그리고 전부 소멸시키는 것이 아니라 메모리의 상태를 보고 일부만 소멸시킨다. 쓰레기 수집기는 메모리가 부족할 때 그리고 CPU가 한가할 때에 JVM에 의해서 자동 실행된다. 그렇기 때문에 finalize()메소드가 호출되는 시점은 명확하지 않다.

프로그램이 종료될 때 즉시 자원을 해제하거나 즉시 데이터를 최종 저장해야 한다면, 일반 메소드에서 작성하고 프로그램이 종료될 때 명시적으로 메소드를 호출하는 것이 좋다.

## Objects 클래스
Object와 유사한 이름을 가진 java.util.Objects 클래스는 객체 비교, 해시코드 생성, null 여부, 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성된 Object의 유틸리티 클래스이다. 다음은 Objects 클래스가 가지고 있는 정적 메소드들이다.

<img src = "https://t1.daumcdn.net/cfile/tistory/2602984756972F8B14"></img>

### 객체비교(compare(T a, T b, Comparator<T>c))
Objects,compare(T a, T b, Comparator<T>c) 메소드는 두 객체를 비교자(Comparator)로 비교해서 int 값을 리턴한다. java.util.Comparator<T>는 제네릭 인터페이스 타입으로 두 객체를 비교하는 compare(T a, T b) 메소드가 정의되어 있다. compare() 메소드의 리턴 타입은 int인데, a가 b보다 작으면 음수, 같으면 0 크면 양수를 리턴하도록 구현 클래스를 만들어야 한다.
	
			public interface COmparator<T> {
					int compare(T a, T b)
			}

다음 예제는 학생 객체에서 학생 번호로 비교하는 StudentComparator 구현 클래스를 작성한 것이다. a의 sno가 작으면 -1, 같으면0, 크면 1을 리턴하도록 했다.

		public class StudentComparator implements Comparator<Student>{
			@Override
			public int compare(Student o1, Student o2) {
				return Integer.compare(o1.sno, o2.sno);
				}
		}

### 동등 비교(equals()와 deepEquals())
Objects.equals(Object a, Object b)는 두 객체의 동등을 비교한다. 특이한 점은 a와 b가 모드 null일 경우 true를 리턴한다는 점이다. a와 b가 null이 아닌 경우는 a.equals(b)의 결과를 리턴한다.

Objetcts.deepEquals(Object a, Objectb) 역시 두 객체의 동등을 비교하는데, a와 b가 서로 다른 배열일 경우, 항목 값이 모두 같다면 true를 리턴한다. 이것은 Arrays.deepEquals(Object[] a, Object[] b)와 동일하다.

<img src = "https://t1.daumcdn.net/cfile/tistory/26608F4756972F913F"></img>

### 해시코드 생성(hash(), hashCode())
Objects.hash(Object... values) 메소드는 매개값으로 주어진 값들을 이용해서 해시 코드를 생성하는 역할을 하는데, 주어진 매개값들로 배열을 생성하고 Arrays.hashCode(Object[])를 호출해서 해시코드를 얻고 이 값을 리턴한다. 

이 메소드는 클래스가 hashCode()를 재정의할 때 리턴값을 생성하기 위해 사용하면 좋다. 클래스가 여러 가지 필드를 가지고 있을 때 이 필드들로부터 해시코드를 생성하게 되면 동일한 필드값을 가지는 객체는 동일한 해시코드를 가질 수 있다.

		@Override
		public int hashCode(){
			return Objects.hash(field1,field2,field3);
		}

Objects.hashCode(Object o)는 매개값으로 주어진 객체의 해시코드를 리턴하기 때문에 o.hashCode()의 리턴값과 동일하다. 차이점은 매개값이 null이면 0을 리턴한다.

### 널 여부 조사(isNull(), nonNull(), requireNonNull())
Objects.isNull(Object obj)는 매개값이 null 일경우 true를 리턴한다. 반대로 nonNull(Object obj)는 매개값이 not null일 경우 true를 리턴한다. requireNonNull()는 다음 세가지로 오버로딩 되어있다.

<img src = "http://mblogthumb3.phinf.naver.net/20160529_202/mals93_14645321616517e5ba_PNG/requireNonNull.png?type=w800"></img>

첫 번째 매개값이 not null이면 첫 번째 매개값을 리턴하고, null이면 모두 NullPointerException을 발생시킨다. 두 번째 매개값은 NullPointerException의 예외 메시지를 제공한다.

### 객체 문자 정보(to String())
Objects.toString()은 객체의 문자 정보를 리턴하는데, 다음 두 가지로 오버로딩 되어있다.

<img src = "https://t1.daumcdn.net/cfile/tistory/23598D4756972F950C"></img>

첫 번째는 매개값이 not null 이면 toString()으로 얻은 값을 리턴하고, null이면 "null" 또는 두 번째 매개값인 nullDefault를 리턴한다.

## System 클래스
자바 프로그램은 운영체제상에서 바로 실행되는 것이 아니라 JVM 위에서 실행된다. 따라서 운영체제의 모든 기능을 자바 코드로 직접 접근하기란 어렵다. 하지만 java.lang 패키지에 속하는 System 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있다. 즉, 프로그램 종료, 키보드로부터 입력, 모니터로 출력, 메모리 정리, 현재 시간 읽기, 시스템 프로퍼티 읽기, 환경 변수 읽기 등이 가능하다. System 클래스의 모든 필드와 메소드는 정적(static) 필드와 정적(static) 메소드로 구성되어 있다.

### 프로그램 종료(exit())
경우에 따라서는 강제적으로 JVM을 종료시킬 때도 있다. 이때 System 클래스의 exit() 메소드를 호출하면 된다. exit() 메소드는 현재 실행하고 있는 프로세스를 강제 종료시키는 역할을 한다. exit() 메소드는 int 매개값을 지정하도록 되어 있는데, 이 값을 종료 상태값이라고 한다. 일반적으로 정상 종료일 경우 0으로 지정하고 비정상 종료일 경우 0 이외의 다른 값을 준다.

		System.exit(0);

어떤 값을 주더라도 종료가 되는데, 만약 특정 값이 입력되었을 경우에만 종료하고 싶다면 자바의 보안 관리자를 직접 설정해서 상태값을 확인하면 된다. System.exit()가 실행되면 보안 관리 자의 checkExit() 메소드가 자동 호출되는데, 이 메소드에서 종료 상태값을 조사해서 특정 값이 입력되지 않으면 SecurityException을 발생시켜 System.exit()를 호출한 곳에서 예외 처리를 할 수 있도록 해준다. checkExit()가 정상적으로 실행되면 JVM은 종료가 된다. 다음은 종료 상태 값으로 5가 입력되면 JVM을 종료하도록 보안 관리자를 설정한다.

		System.setSecurityManager(new SecurityManager(){
				@Override
				public void checkExit(int status) {
					if(status != 5) {
							throw new SecurityException();
					}
				}
		});

### 쓰레기 수집기 실행(gc())
자바는 개발자가 메모리를 직접 코드로 관리하지 않고 JVM이 알아서 자동으로 관리한다. JVM은 메모리가 부족할 때와 CPU가 한가할 때에 쓰레기 수집기(Garbage Collector)를 실행시켜 사용하지 않는 객체를 자동 제거한다.

쓰레기 수집기는 개발자가 직접 코드로 실행시킬 수 없고, JVM에게 가능한한 빨리 실행해 달라고 요청할 수는 있다. 이것이 System.gc() 메소드이다. System.gc() 메소드가 호출되면 쓰레기 수집기가 바로 실행되는 것은 아니고, JVM은 빠른 시간 내에 실행시키기 위해 노력한다.

		System.gc();

쓰레기가 생길 때마다 쓰레기 수집기가 동작한다면 정작 수행되어야 할 프로그램의 속도가 떨어지기 때문에 성능 측면에서 좋지 않다. 그리고 메모리가 충분하다면 굳이 쓰레기 수집기를 실행할 필요가 없다. gc() 메소드는 메모리가 열악하지 않은 환경이라면 거의 사용할 일이 없다. 스마트폰이 나오기 전에도 자바로 휴대폰 게임을 개발했는데, 그때에는 휴대폰의 메모리가 작았기 때문에 쓰레기 수집기의 실행 시기가 중요할 수도 있었다. 새로운 화면을 만들기 위해 이전 화면에서 생성한 객체를 빨리 메모리에서 제거해야 했는데, 이때 System.gc()가 호출되었다.

### 현재 시각 읽기(currentTimeMillis(), nanoTime())

























































