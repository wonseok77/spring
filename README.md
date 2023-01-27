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


