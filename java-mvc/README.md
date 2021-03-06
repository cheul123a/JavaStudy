## 애플리케이션 전체 구조

### 계층형 아키텍처
계층형 아키텍처는 다음과 같이 애플리케이션의 구성 요소를 역할에 따라 계층별로 나누고 각 계층 사이에 소통을 통해서 작업을 처리하는 애플리케이션 구조이다. 계층형 아키텍처 기반으로 개발한 애플리케이션을 줄여서 계층형 애플리케이션이라고 할 수 있다.

<img src = "https://t1.daumcdn.net/cfile/tistory/2134664C592F695A38"></img>


Controller 계층이 사용자의 요청을 처음 접하게 된다. 웹 프라우저에서 사용자가 어떤 링크를 클릭하거나 폼 전송 버튼을 클릭하면, Controller 계층에 있는 객체가 그 요청을 받는다. 그럼 바로 밑에 있는 Service 계층의 객체가 요청을 받는다. 그럼 바로 밑에 있는 Service 계층의 객체를 사용해서 필요한 작업을 처리한 뒤 사용자에게 보여줄 최종적인 화면과 그 화면에서 보여줄 정보를 결정한다.

Service 계층은 애플리케이션의 주요 로직을 담당한다. DAO 계층을 사용해 사용자 정보를 관리 및 트랜잭션 처리를 하거나 접근 권한 확인을 하는 등 애플리케이션의 인프라성 서비스를 추가할 수 있습니다.

DAO(Data Access Object)는 데이터를 조작하는 역할을 담당하는 객체를 모아둡니다. Service 계층에서 로직을 처리할 때 필요한 데이터가 있거나, 로직 수행 결과를 저장해야 한다고 했을 때 이곳에 있는 객체를 사용해서 해당 작업을 위임합니다.

그런데 왜 Controller에서 모든 일을 처리하지 않을까? 객체지향 분석 설계 원칙 중에 '단일 책임 원칙'이라는 것이 있다. 한 객체가 한 가지 책임만 지닏록 설계하는 원칙이다. 모든 애플리케이션이 반드시 지켜야 하는 원칙은 아니지만, 이런 원칙을 지킬 때 비로소 객체지향의 장점을 잘 활용할 수 있는 구조가 된다. 이 원칙에 따라서 각 계층의 역할을 정리하면 다음과 같다.

+ 컨트롤러 계층: 요청 매개변수 바인딩, 검증, 응답 화면, 응답 화면에 담을 정보(모델)결정
+ 서비스 계층: 비즈니스 로직 수행, 트랜잭션 경계 설정, 접근 권한 확인 등
+ DAO 계층: 데이터 저장 및 조회

계층을 항상 이렇게 나누라는 규칙은 없다. 원하는 역할대로 계층을 나누면 된다. 만약 이렇게 각 계층별로 나눠둔 작업을 한곳에서 한다고 가정해 보면 코드는 점점 복잡해질 것이고, 요청 매개변수를 추가했을 때 소스 코드의 어느 부분을 손 봐야 할지 점점 찾기 힘들어질 것이다. 그리고 여러 명의 개발자와 동시에 개발을 진행할 때 서로 동일한 소스 코드를 손보느라 서로의 작업이 영향을 받을 수도 있다.

### 계층형 애플리케이션의 규칙
이러한 계층형 애플리케이션에는 몇 가지 규칙이 있다.

+ 바로 인접한 계층과 소통할 것
+ 위에서 아래로 소통할 것

이 두가지 규칙만 잘 지키면 계층형 아키텍처를 잘 유지할 수 있다.



























































