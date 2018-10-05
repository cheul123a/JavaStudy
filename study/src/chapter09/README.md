chapter09.

예외 처리
===========================

## 예외와 예외 클래스

컴퓨터 하드웨어의 오동작 또는 고장으로 인해 응용프로그램 실행 오류가 발생하는 것을 자바에서는 에러(error)라고 한다. 에러는 JVM 실행에 문제가 생겼다는 것이므로 JVM 위에서 실행되는 프로그램을 아무리 견고하게 만들어도 결국 실행 불능이 된다. 개발자는 이런 에러에 대처할 방법이 전혀 없다.

자바에서는 에러 이외에 예외(exception)라고 부르는 오류가 있다. 예외란 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류를 말한다. 예외가 발생되면 프로그램은 곧바로 종료된다는 점에서는 에러와 동일하다. 그러나 예외는 예외 처리(Exception Handling)를 통해 프로그램을 종료하지 않고 정상 실행 상태가 유지되도록 할 수 있다.

예외는 두 가지 종류가 있다. 하나는 일반 예외(Exception)이고, 다른 하나는 실행 예외(Runtime Exception)이다. 일반 예외는 컴파일러 체크 예외라고도 하는데, 자바 소스를 컴파일 하는 과정에서 예외 처리 코드가 필요한지 검사하기 때문이다. 만약 예외 처리 코드가 없다면 컴파일 오류가 발생한다. 실행 예외는 컴파일 하는 과정에서 예외 처리 코드를 검사하지 않는 예외를 말한다. 컴파일 시 예외 처리를 확인하는 차이일 뿐, 두 가지 예외는 모두 예외 처리가 필요하다.

자바에서는 예외를 클래스로 관리한다. JVM은 프로그램을 실행하는 도중에 예외가 발생하면 해당 예외 클래스로 객체를 생성한다. 그리고 나서 예외 처리 코드에서 예외 객체를 이용할 수 있도록 해준다. 모든 예외 클래스들은 java.lang.Exception 클래스를 상속받는다.


<img src ="http://mblogthumb4.phinf.naver.net/20160525_127/mals93_1464110192410HQNY8_JPEG/%BF%B9%BF%DC1.jpg?type=w800"></img>

일반 예외와 실행 예외 클래스를 구별하는 방법은 일반 예외는 Exception을 상속받지만 RuntimeException을 상속받지 않는 클래스들이고, 실행 예외는 다음과 같이 RunTimeException을 상속받은 클래스들이다. RuntimeException 역시 Exception을 상속받지만, JVM은 RuntimeException을 상속했는지 여부를 보고 실행 예외를 판단한다.

<img src="https://mblogthumb-phinf.pstatic.net/20160525_93/mals93_14641101922004y22y_JPEG/%BD%C7%C7%E0%BF%B9%BF%DC.jpg?type=w800"></img>


## 실행 예외

실행 예외는 자바 컴파일러가 체크를 하지 않기 때문에 오로지 개발자의 경험에 의해서 예외 처리 코드를 삽입해야 한다. 만약 개발자가 실행 예외에 대해 예외 처리 코드를 넣지 않았을 경우, 해당 예외가 발생하면 프로그램은 곧바로 종료된다.

### NullPointerException

자바 프로그램에서 가장 빈번하게 발생하는 실행 예외는 java.lang.NullPointerException일 것이다. 이것은 객체 참조가 없는 상태, 즉 null 값을 갖는 참조 변수로 객체 접근 연산자인 도트(.)를 사용했을 때 발생한다. 객체가 없는 상태에서 객체를 사용하려 했으니 예외가 발생하는 것이다.

		public class NullPointerExceptionExample{
			public static void main(String[] args){
				String data = null;
				system.out.println(data.toString());
			}
		}

data 변수는 null 값을 가지고 있기 때문에 String 객체를 참조하고 있지 않다. 하지만 String 객체의 toString() 메소드를 호출하고 있다. 여기서 NullPointerException이 발생한다.

### ArrayIndexOutOfBoundsException

배열에서 인덱스 범위를 초과하여 사용할 경우 실행 예외인 java.lang.ArrayIndexOutOf-BoundsException이 발생한다. 예를 들어 길이가 3인 int[] arr = new int[3] 배열을 선언했다면, 배열 항목을 지정하기 위해 arr[0]~arr[2]를 사용할 수 있다. 하지만 arr[3]을 사용하면 인덱스 범위를 초과했기 때문에 ArrayIndexOutOfBoundsException이 발생한다.

		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("args[0]: " + data1);
		System.out.println("args[1]: " + data2);

위 예제를 실행하면 ArrayIndexOutOfBoundsException이 발생한다. 그 이유는 두개의 실행 매개값을 주지 않았기 때문에 args[0], args[1]과 같이 인덱스를 사용할 수 없다.

이클립스의 메뉴에서 [Run] -> [Run Configurations]를 선택후, [Arguments] 탭의 [Program arguments] 입력란에 두 개의 매개값을 입력하고 실행하면 예외가 발생하지 않는다.

배열값을 읽기 전에 배열의 길이를 먼저 조사하여 실행 매개값이 없거나 부족 할 경우 조건문을 이용해서 사용자에게 실행 방법을 알려주면 ArrayIndexOutOfBoundsException을 예방할 수 있다.

### NumberFormatException

프로그램을 개발하다 보면 문자열로 되어 있는 데이터를 숫자로 변경하는 경우가 자주 발생한다. 문자열을 숫자로 변환하는 방법은 여러 가지가 있지만 가장 많이 사용되는 코드는 다음과 같다.

		Integer.parseInt(String s) 주어진 문자열을 정수로 변환해서 int 타입으로 리턴
		Double.parseDouble(String s) 주어진 문자열을 실수로 변환해서 double 타입으로 리턴

Integer와 Double은 포장(Wrapper) 클래스라고 하는데, 이 클래스의 정적 메소드인 parseXXX() 메소드를 이용하면 문자열을 숫자로 변환할 수 있다. 이 메소드들은 매개값인 문자열이 숫자로 변환될 수 있다면 숫자를 리턴하지만, 숫자로 변환될 수 없는 문자가 포함되어 있다면 java.lang.NumberFormatException을 발생시킨다.


### ClassCastException


































