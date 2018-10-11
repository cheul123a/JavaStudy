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













































































































