# spring  
   
AOP => 모듈화 해서 관리, 비즈니스 문제 해결 관점에서 프로그래밍 함  
  공통관심사항  
  핵심관심사항  

인프런 김영한
    
  
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
  
=================필기시험
spring boot 만이 가지고 있는 api가 있는데 starter가 붙어있다 build.gradle에 main이 있다는것과 같다(<-> lagacy)
test가 있다 단위 test  
SpringBootApplication (meta class라고 생각하면된다)
  
    
SpringBootConfiguration -> Configuration 설정정보
EnableAutoConfiguration -> 자동으로 객체를 생성시키는 설정파일  
ComponentScan  -> 특정 패키지 밑에있는 모든 annotation (Service, Controller, ...등)   
  
jar third party에서 제공하는 library API JAVA쓰는경우가 많으니까 API를 JAR형태로 제공    
starter가 있으니까 단위 test가 가능하다  

가장 큰 차이점  (SpringFrameWork, Spring lagacy project vs Spring boot)
tomcat을 내장하고있다(Spring boot)  

AOP와 관련된 정의  
Adivice  
joinpoint와 pointcut의 차이(joinpoint의 묶음을 pointcut)  
aspect   

transaction annotation은 (insert, delete, update)등을 할때 달아야한다  
  
  
commit rollback; 실제 transaction연산을 물리적으로 변경하는 명령어    
쿼리문 2개로 만들어놨다가 rollback시 나머지 하나 활용 JDBC는 connection에 autocommit  
transaction annotation만으로 자동 commit rollback이 된다  
하나라도 실패(exception) 하면 자동 rollback이 된다, 성공했을경우 자동 commit     
  
@Controller 골라서 할 수 있다  
@RestController(의 특징) 는 무조건 데이터를 반환한다  

@RestFramework url에 
<a href = "  /test/10">
   @GetMapping("/test/{n}")
   public   (@pathVariable Int~)
   restpull api는 pathvariable과 연결된다 !
   
   이것을 rest pull 요청이라고 한다  
   get put post delete 4가지 방식이 있다  
   post는 데이터를 넣어서 와서 url이 달라지지 않는다  
   ajax에 넣어서 보낼때도 body에 넣어서 보낸다 post는  
   foot은 변경하는것을 foot이라고 한다  
   무엇을 변경할거라고 해서 get put delete url에 path variable  
   put과 post는 body까지 같이 rest pull api형태는 프로젝트하다보면 공공데이터가 어마어마하게많다
   다 rest형태의 api를 이용하는 형태이다
   
   
   jpa는 DB에 의존적이다. ANSI 표준 SQL문 JOIN이런거 Oracle, MySQL 시험볼때 공무원시험볼때는 ANSI JOIN을 써야한다 표준 SQL문이라고 한다. 다 표준이기에 돌아간다 .  
   AUTO INCREMENT는 MYSQL, MARIADB but Oracle은 안된다 Sequence라는걸 써야한다 기본적으로 ANSI JOIN을 쓰지않는 한 DB에 의존적이라고 할 수 있다
   Direct로 갖다 쓸 수 있다 Application properties에  
      
      
   spring.jpa.database-platform=org.hibernate.dialect.MariaDB103Dialect   
   Dialect는 특정 DB에 종속적인 기능을 사용하는 것이다   
      
   file upload 할 때 반드시 inity file // enctype = "multipart/form-data"  
     
   가로채기(intercepter어쩌고)  
   내일은 timeleaf어 쩌고  
   
   dispatcher servlet spring영역  
   인터셉터의 메소드랑  
   AOP의 어노테이션 종류가 뭐가 있는지 시험에 나온다 !  
   AOP @AROUND @AfterReturning @AfterThrowing afterCompletion 등등  
   
   forward는 데이터를 공유한다
   타임리프 전체깜빡임 없이 일부분만 변경되게 하는 기능 ?? kt enterprise
   화면은 이쁜데 서비스의 접근성이 떨어진다

   타임리프는 프론트 쪽
   
   
   =======================================
   Annotation 정리
   @Controller  
   
   @Autowired  : 타입으로 의존성을 주입  
   @Resource : 이름으로 의존성을 주입  
   
   @RequestMapping(value = "/hello", method = RequestMethod.GET) value는 요청받을 url, method는 어떤 요청으로 받을지(GET, POST, PUT, DELETE등) : 
   특정 url로 요청을 보내면 Controller에서 어떠한 방식으로 처리할지 정의한다. 들어온 요청을 특정 메서드와 매핑하기위해 사용하는것
   
   @ResponseBody : 비동기통신을 하기위해서 클라이언트에서 서버로 요청을 보낼때 본문에 데이터를 담아서 보내는 방식(JSON, XML등)  
   @ModelAttribute : 메서드의 파라미터에 사용시에는 사용자가 요청시 전달하는 값을 오브젝트 형태로 매핑해주는 어노테이션이다  
   @RequestParam : @RequestParam 어노테이션은 사용자가 요청시 전달하는 값을 Handler(Controller)의 매개변수로 1:1 맵핑할때 사용되는 어노테이션이다  
   @Repository : @Repository, @service 어노테이션은 해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성해주는 어노테이션입니다  
   @Alias : @Alias는 mybatis에서 지원하는 어노테이션으로 TypeAlias, 즉 별칭을 지정할 때 사용합니다. setTypeAliasesPackage() 메서드를 통해 패키지 경로를 정해두면 패키지 내에
               @Alias("별칭") 어노테이션이 지정된 클래스는 매퍼파일에서 별칭으로 해당 클래스를 매핑해줍니다.
   
   @Transactioanl : @Transactional을 사용하여 트랜잭션에 대한 전파, 격리, 시간 초과, 읽기 전용 및 롤백 조건을 설정할 수 있다     
   @Service : @Repository, @service 어노테이션은 해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성해주는 어노테이션입니다  
     
     
   spring spel $를 통해 데이터를 처리하는것(EL 표기법 spring EL을 타임리프는 지원한다)    
   EL이 데이터만 조작할수있는것이아니라 태그와 함께 반복적인 조건을 넣을수 있다 each를 가지고 있다    
   JSP는 껍데기를 만들어서 고정된 화면을 include하고있었다  
   thymeleaf는 layout이다 thymeleaf를 사용하면 백앤드가 편하다  
   header와 body를 다 갖고있다 head태그와 body태그를 따로 가지고있을 필요가 없이 layout태그를 가지고 있어야 한다  
   javascript나 css는 head태그에 보통 써준다 layout fragment 이름을 지정해두고 다른거에서 가져다가 쓸 수 있게 한다  
   폴더명 파일명
     
