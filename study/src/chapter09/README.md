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

타입 변환(Casting)은 상위 클래스와 하위 클래스 간에 발생하고 구현 클래스와 인터페이스 간에도 발생한다. 이러한 관계가 아니라면 클래스는 다른 클래스로 타입 변환할 수 없다. 억지로 타입 변환을 시도할 경우 ClassCastException이 발생한다.

다음은 올바른 타입 변환을 보여준다.

		Animal animal = new Dog();
		Dog dog = (Dog)animal;
		
		RemoteControl rc = new Television();
		Television tv = (Television)rc;
		
그러나 다음과 같이 타입 변환을 하면 ClassCastException이 발생한다. 대입된 객체가 아닌 다른 클래스 타입으로 타입 변환했기 때문이다.

		Animal animal = new Dog();
		Cat cat = (Cat) animal;
		
		RemoteControl rc = new Television();
		Audio audio = (Audio)rc;

ClassCastException을 발생시키지 않으려면 타입 변환 전에 타입 변환이 가능한지 instanceof 연산자로 확인하는 것이 좋다. instanceof 연산의 결가가 true 이면 좌항 객체를 우향 타입으로 변환이 가능하다는 뜻이다.

		
		if(animal instanceof Dog){
				Dog dog = (Dog)animal;
		}else if(animal instanceof Cat){
				Cat cat = (Cat)animal;
		}
		

## 예외 처리 코드
프로그램에서 예외가 발생했을 경우 프로그램의 갑작스러운 종료를 막고, 정상 실행을 유지할 수 있도록 처리하는 코드를 예오이 처리 코드라고 한다. 자바 컴파일러는 소스 파일을 컴파일할 때 일반 예외가 발생할 가능성이 있는 코드를 발견하면 컴파일 오류를 발생시켜 개발자로 하여금 강제적으로 예외 처리 코드를 작성하도록 요구한다.

그러나 실행 예외는 컴파일러가 체크해주지 않기 때문에 예외 처리 코드를 개발자의 경험을 바탕으로 작성해야 한다. 예외 처리 코드는 try-catch-finally 블록을 이용한다. try-catch-finally 블록은 생성자 내부와 메소드 내부에서 작성되어 일반 예외와 실행예외가 발생할 경우 에외 처리를 할 수 있도록 해준다.

<img src="http://postfiles15.naver.net/20160525_158/mals93_1464112743040YNCp5_PNG/trycatch.png?type=w773"></img>

try 블록에는 예외 발생 가능 코드가 위치한다. try 블록의 코드가 예외 발생 없이 정상 실행되면 catch 블록의 코드는 실행되지 않고 finally 블록의 코드를 실행한다. 만약 try 블록의 코드에서 예외가 발생하면 즉시 실행을 멈추고 catch 블록으로 이동하여 예외 처리 코드를 실행한다. 그리고 finally 블록의 코드를 실행한다. 

finally 부분은 옵션으로 생략 가능하다. 예외 발생 여부와 상관없이 항상 실행할 내용이 있을 경우에만 finally 블록을 작성해 주면 된다. try 블록과 catch 블록에서 return 문을 사용하더라도 finally 블록은 항상 실행된다.

class.forName() 메소드는 매개값으로 주어진 클래스가 존재하면 Class 객체를 리턴하지만, 존재하지 않으면 ClassNotFoundException 예외를 발생시킨다. ClassNotFoundException 예외는 일반 예외이므로 컴파일러는 개발자로 하여금 예외 처리 코드를 다음과 같이 작성하도록 요구한다.

		try {
			Class clazz = Class.forName("java.lang.String2");
		}catch(ClassNotFoundException e){
			System.out.println("클래스가 존재하지 않습니다.");
		}

위 예제를 실행시키면 try 블록에서 ClassNotFoundException이 발생하는데, 이것은 java.lang.String2 클래스가 존재하지 않기 때문이다. 예외가 발생하면 catch 블록을 실행해서 예외 처리를 하게 된다. ArrayIndexOutOfBoundsException이나, NumberFormatException과 같은 실행 예외는 컴파일러가 예외 처리 코드를 체크하지 않기 때문에 개발자의 경험에 의해 예외 처리를 작성해주어야 한다.

## 예외 종류에 따른 처리 코드

### 다중 catch
try 블록 내부는 다양한 종류의 예외가 발생할 수 있다. 이 경우, 발생되는 예외별로 예외 처리 코드를 다르게 하려면 다중 catch 블록을 작성하여 처리할 수 있다. catch 블록의 예외 클래스 타입은 try 블록에서 발생된 예외의 종류를 말하는데, try 블록에서 해당 타입의 예외가 발생하면 catch 블록을 실행하도록 되어 있다.

		try{
			ArrayIndexOutOfBoundsException 발생  -> 예외 처리1 실행
			
			NumberFormatException 발생 -> 예외 처리2 실행
			
		} catch(ArrayIndexOutOfBoundsException e){
			 예외 처리1
		} catch(NumberFormatException e) {
			 예외 처리2
		}

catch 블록이 여러 개라 할지라도 단 하나의 catch 블록만 실행된다. 그 이유는 try 블록에서 동시 다발적으로 예외가 발생하지 않고, 하나의 예외가 발생하면 즉시 실행을 멈추고 해당 catch 블록으로 이동하기 때문이다.

### catch 순서
다중 catch 블록을 작성할 때 주의할 점은 상위 예외 클래스가 하위 예외 클래스보다 아래쪽에 위치 해야 한다. try 블록에서 예외가 발생했을 때, 예외를 처리해줄 catch 블록은 위에서부터 차례대로 검색된다. 만약 상위 예외 클래스의 catch 블록이 위에 있다면, 하위 에외 클래스의 catch 블록은 실행되지 않는다. 왜냐하면 하위 예외는 상위 예외를 상속 했기 때문에 상위 예외 타입도 되기 때문이다.

		try{
			ArrayIndexOutOfBoundsException 발생 -> 예외 처리1 실행
			
			 NumberFormatException  발생 -> 예외 처리1 실행
		
		} catch(Exception e){
			 예외 처리1
		} catch(ArrayIndexOutOfBoundsException e) {
			 예외 처리2 
		}

ArrayIndexOutOfBoundsException과 NumberFormatException은 모두 Exception을 상속받기 때문에 첫 번째 catch 블록만 선택되어 실행된다. 두 번째 catch 블록은 어떤 경우에라도 실행되지 않는다. 위 코드는 다음과 같이 수정해야 한다.

		try{
				ArrayIndexOutOfBoundsException 발생  -> 예외 처리1 실행
				 다른 Exception 발생 -> 예외처리2
			
			} catch(ArrayIndexOutOfBoundsException e){
				 예외 처리1
			} catch(Exception e) {
				 예외 처리2
			}

try 블록에서 ArrayIndexOutOfBoundsException이 발생하면 첫 번째 catch 블록을 실행하고, 그 밖의 다른 예외가 발생하면 두 번째 catch 블록을 실행한다.

### 멀티 catch
자바 7부터 하나의 catch 블록에서 여러 개의 예외를 처리할 수 있도록 멀티(multi) catch 기능을 추가했다. 다음은 멀티 catch 블록을 작성하는 방법을 보여준다. catch 괄호() 안에 동일하게 처리하고 싶은 예외를 |로 연결하면 된다.

		try{
			ArrayIndexOutOfBoundsException 또는 NumberFormatException 발생  ->  예외 처리1
			
			Exception 발생  ->  예외 처리2
			
		} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			 예외 처리1
		} catch(Exception e){
			 예외 처리2
		}

## 자동 리소스 닫기
자바 7에서 새로 추가된 try-with-resources를 사용하면 예외 발생 여부와 상관없이 사용했던 리소스 객체(각종 입출력 스트림, 서버 소켓, 소켓, 각종 채널)의 close() 메소드를 호출해서 안전하게 리소스를 닫아준다. 리소스란 여러 가지 의미가 있겠지만 여기서는 데이터를 읽고 쓰는 객체라고 생각해 두자.

다음은 리소스 객체를 안전하게 닫기 위해 자바6 이전까지 사용해 왔던 코드이다.

	 FileInputStream fis = null;
	 try {
	 		fis = newFileInputStream("file.txt");
			...
	 } catch(IOException e){
	 		...
	 } finally {
	 		if(fis != null){
					try{
						fis.close();
						}catch(IOException e){ }
			}
	 }

finally 블록에서 다시 try-catch를 사용해서 close() 메소드를 예외 처리해야 하므로 다소 복잡 하게 보인다. 자바 7에서 추가된 try-with-resources를 사용하면 다음과 같이 간단해진다.

	try(FileInputStream fis = new FileInputStream("file.txt")){
		...
	} catch(IOException e){
		...
	}

close()를 명시적으로 호출한 곳이 없다. try 블록이 정상적으로 실행을 완료했거나 도중에 예외가 발생하게 되면 자동으로 FileOutputStream의 close() 메소드가 호출된다. try {} 에서 예외가 발생하면 우선 close()로 리소스를 닫고 catch 블록을 실행한다. 만약 복수 개의 리소스를 사용해야 한다면 다음과 같이 작성할 수 있다.

		try(
					FileInputStream fis = new FileInputStream("file1.txt");
					FileOutputStream fos = new FileOutputStream("file2.txt");
		) {
				...
			} catch(IOException e){
				...
			}

try-with-resources를 사용하기 위해서는 조건이 있는데, 리소스 객체는 java.lang.AutoCloseable 인터페이스를 구현하고 있어야 한다. AutoCloseable에는 close() 메소드가 정의되어 있는데 try-with-resources는 바로 이 close() 메소드를 자동 호출한다. API 도큐먼트에서 AutoCloseable 인터페이스를 찾아 "All Known Implementing Classes:"를 보면 try-with-resources와 함께 사용할 수 있는 리소스가 어떤 것이 있는지 알 수 있다.

## 예외 떠넘기기
메소드 내부에서 예외가 발생할 수 있는 코드를 작성할 때 try-catch 블록으로 예외를 처리하는 것이 기본이지만, 경우에 따라서는 메소드를 호출한 곳으로 예외를 떠넘길 수도 있다. 이때 사용하는 키워드가 throws이다. throws 키워드는 메소드 선언부 끝에 작성되어 메소드에서 처리하지 않은 예외를 호출한 곳으로 떠넘기는 역할을 한다. throws 키워드 뒤에는 떠넘길 예외 클래스를 쉼표로 구분해서 나열해주면 된다.

		리턴타입 메소드명(매개변수,...) throws 예외클래스1, 예외클래스2, ...{ }

발생할 수 있는 예외의 종류별로 throws 뒤에 나열하는 것이 일반적이지만, 다음과 같이 throws Exception만으로 모든 예외를 간단히 떠넘길 수도 있다.

		리턴타입 메소드명(매개변수,...) throws Exception { }

throws 키워드가 붙어있는 메소드는 반드시 try 블록 내에서 호출되어야 한다. 그리고 catch 블록에서 떠넘겨 받은 예외를 처리해야 한다. 다음 코드는 throws 키워드가 있는 method2()를 method1()에서 호출하는 방법을 보여준다.

		public void method1(){
			try{
				method2();
				 } catch(ClassNotFoundException e){
				system.out.println("클래스가 존재하지 않습니다.");
			}
		}
		public void method2() throws ClassNotFoundException {
			Class clazz = Class.forName("java.lang.String2");
		}

method1()에서도 try-catch 블록으로 예외를 처리하지 않고 throws 키워드로 다시 예외를 떠넘길 수 있다. 그러면 method1()을 호출하는 곳에서 결국 try-catch 블록을 사용해서 예외를 처리해야 한다.

		public void method1() throws ClassNotFoundException {
			method2();
		}

자바 API 도큐먼트를 보면 클래스 생성자와 메소드 선언부에 throws 키워드가 붙어있는 것을 흔히 볼 수 있다. 이러한 생성자와 메소드를 사용하고 싶다면, 반드시 try-catch 블록으로 예외 처리를 해야 한다. 아니면 throws를 다시 사용해서 예외를 호출한 곳으로 떠넘겨야 한다. 그렇지 않으면 컴파일 오류가 발생한다.

main() 메소드에서도 throws 키워드를 사용해서 예외를 떠넘길 수 있는데, 결국 JVM이 최종적으로 예외 처리를 하게 된다. jVM은 예외의 내용을 콘솔(Console)에 출력하는 것으로 예외 처리를 한다.

		public static void main(String[] args) throws ClassNotFoundException{
			findClass();
		}
main() 메소드에서 throws Exception을 붙이는 것은 좋지 못한 예외 처리 방법이다. 프로그램 사용자는 프로그램이 알수 없는 예외 내용을 출력하고 종료되는 것을 좋아하지 않는다. 그렇기 때문에 main()에서 try-catch 블록으로 예외를 최종 처리하는 것이 바람직하다.

## 사용자 정의 예외와 예외 발생
















































































































