# spring  
   
AOP => 모듈화 해서 관리, 비즈니스 문제 해결 관점에서 프로그래밍 함  
  공통관심사항  
  핵심관심사항  
    
  
  공통관심사항을 공유해서 핵심관심사항에서 관리  
  
1. Advice  
언제 어떠한 기능의 공통 관심로직을 핵심로직에 적용할지를 정의한다.  
spring AOP의 경우 5가지의 advice가 존재한다.  

2. Joinpoint
실행시의 처리 플로우에서 Advice를 위빙하는 포인트를 Joinpoint라고 한다.  
구체적으로는 '매서드 호출'이나 '예외 발생'이라는 포인트를 Joinpoint로 정의한다.  
대상이 되는 핵심 포인트가 joinpoint(어디)  
advice (언제)  

3. Pointcut  
하나 또는 복수의 Joinpoint를 하나로 묶은 것을 Pointcut이라고 한다.  
Advice의 위빙 정의는 Pointcut을 대상으로 설정한다  
하나의 Pointcut에는 복수 Advice를 연결할 수 있다. 반대로 하나의 Advice를 복수 Pointcut에 연결하는것도 가능하다  

4. Advisor  
Adive와 Pointcut을 하나로 묶어 다루는 것을 Advisor라고 한다.  
Advisor는 스프링 AOP에만 있는 것인데, 관점 지향에서 '관점'을 나타내는 개념이라고 할 수 있다.  

5. Aspect  
여러 객체에 공통으로 적용되는 공통 관심 사항을 Aspect 이라 한다.  
로깅, 트랜잭션 처리 등이 Aspect 의 좋은 예이다.  
Spring AOP는 Aspect를 일반적인 자바 클래스로 구현한다.  

6. Weaving  
Advice를 핵심 로직 코드에 적용하는 것   

** 시험 나옴 **  
MVC에서 원래는 controller가 요청을 다 받는데 ★☆dispatcher Servlet☆★이 spring framework에서는 client의 요청을 받는다    
  
advice(언제), joinpoint(어디) -여러개-> pointcut
  
Advisor(관점을 나타내는 개념) = advice + pointcut  
   
Aspect : 공통관심사항    
weaving : advice 적용  

# spring boot  
intelliJ community Edition 다운  
JDK 17다운  
https://start.spring.io 에서 gradle 로 project생성  
[File] - [Project structure]에서 JDK 17로 설정변경  
[File] - [Setting(나는 윈도우라 perferences아님)] - [Build, Execution, Deployment] - [Build Tools] 에서 JDK 17이랑, 다른 셋팅 intelliJ IDEA로 변경  


스프링 부트 라이브러리  
spring-boot-starter-web
- spring-boot-starter-tomcat: 톰캣 (웹서버)  
- spring-webmvc: 스프링 웹 MVC  
spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)  
spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
- spring-boot  
   -    spring-core  
- spring-boot-starter-logging  
   -    logback, slf4j
테스트 라이브러리  
spring-boot-starter-test  
- junit: 테스트 프레임워크
- mockito: 목 라이브러리  
- assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리  
- spring-test: 스프링 통합 테스트 지원  

- 명령 프롬프트에서 실행하기  
-  디렉터리 접근 후 설명 따라하기. 
  
 ===========================0131 
시작은 pom.xml, web.xml, tomcat add실행시 실행되는것 xml을 고치면 서버를 껏다켜야 한다  
context param을 통해 listner에 등록  
web application context, bean객체 ?  

  
data source설정 따로 mapper 에 mybatis를 사용하기위한 sqlsessionfactory생성  

시작은 HeidiSQL에서 MariaDB TABLE 생성  
dto 객체 생성 Member.java mapper의 orm에 매핑시킬 클래스로 사용, column이랑 똑같은 이름으로 객체 멤버 생성  
join.jsp input type과 같은 이름으로 생성, 기본생성자로 렛츠고  

member.xml, 회원가입과 로그인을 위한 SQL Query만 작성  
로그인 처리를 위한 Select member, 회원가입을 위한 insert into  join.jsp form에 "./join" post  
request 매핑 join으로 간다 (회원가입 버튼을 누르면 )  

MemberController생성  Join을 위한 GET, POST 각각만들기
그 전에, mapper(SQL)을 만들었다면 그것을 위한 DAO를 만들어 줘야한다  @Autowired @Repository활용하기  
(mapper 실행 메서드인것같음) SQLFACTORYSESSIONBEAN이 AUTOWIRED(주입) 된것  

MemberController에 memberDAO @Autowired로 불러온다 
class 명과 input tag의 name이 같아야한다

회원가입성공하면 로그인화면으로 실패했을땐 error페이지로  
로그인 화면은 id와 password를 가지고 넘어감
@RequestParam으로 Controller로 온다  INT를 쓰면 안된다 INTEGER?

1. DB 테이블 만들고  
2. board.java에 getter setter 만들고
3.  board.xml에 dtd 넣는다  그다음 SQL Query작성한다  
4.  dao 패키지 만들고 DAO interface생성 및 상속받은 Impl class  생성   
5. Model 은 DB접속을 포함한 Business로직 Service라는 표현을 많이 쓴다
6. com.kt.board.service 패키지 생성

5
6


1. lagacy project 생성
2. pom.xml에 dependency 붙혀넣기
3. 인코딩 처리 web.xml에 추가하기 filter 태그 부분
4. context.param web.xml에서 listener에 넘겨주기
5. sql session factory bean에다가 mapper라는 이름의 xml파일의 경로를 연결 dto class의 alias 설정이 root context.xml(DB와 mapper를 연결해주는 아이다)에 있다
6. root context.xml sqlsession factory 기존 코드에서 3,4번째줄 복사하기 db properties를 어디다가 넣을것인가 ? 경로 지정
7. mapper생성(board2.xml) 경로지정 신경쓰고, DOC type이랑 mapper 껍데기 만들기, SQL 쿼리 쓰기


servlet context 에서 component-scan 경로 잘 설정하기(어노테이션 불러오는 기능)
pojo 순수자바클래스(상속받지않은)
ioc 역제어컨테이너 beam객체의 생성 초기화 소멸 같은 기초적인 것들을 관리하는 아이다

Ajax는 ~~~  꼼꼼함 대강대강이아니라 꼼꼼함 설계를 대충하고 들어가면 큰일남 web은 다른페이지와 연동이되기때문에 설계연동이 이루어진다.
상호작용을 잘한다...
@
ajax Optional
webapp 안에 폴더에 image 넣으면 다이렉트로 읽어오기 가능하다
