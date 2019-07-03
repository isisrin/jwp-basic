## JSP

#### 알게 된 것

##### DispatcherServlet 패턴?
->DispatcherServlet 에서 servlect관련 중복 코드를 담당하고 있다. <br/>
 ex) servlet을 extends 한 곳에서 호출하는 httpResponse.sendRedirect()나 fortward() 함수 <br/>
 지금처럼 DispatcherServlet이 모든 controller로 가기전에 선 처리 하는 방식이 'front controller pattern' 프론트 컨트롤러 패턴이라고 한다!
 Spring MVC 프레임워크가 이와 비슷하게 동작한다고 한다.

##### @WebServlet(loadOnStartup = 1) 
-> loadOnStartup을 설정하지 않으면 서블릿 인스턴스를 생성하는 init() 메소드를 클라이언트 요청이 발생하는 시점에 실행된다.
loadOnStartup을 설정하면 서블릿 컨테이너가 시작하는 시점에 init() 메소드를 실행한다.
숫자가 낮을 수록 우선순위가 높다!

#### 에러 해결 사랑
sendRedirect() 호출 전에 forward()를 호출해 버리면 "응답이 이미 커밋된 후에는, sendRedirect()를 호출할 수 없습니다"라는 오류를 볼 수 있다.
내가 알게 모르게 forward를 어디선가 선 호출하고 있는지 체크해 보자!


#### 쿠키와 세션
HTTP는 상태를 저장하지 않는 프로토콜이다. 그렇지만 떄에 따라 인증을 해야할 필요가 있는데, 
상태를 효율적으로 저장하기 위해 '쿠키'와 '세션'을 이용해 상태를 저장하곤 한다.
 * 쿠키 : Request 헤더에 Cookie : 이름=값 형태로 보내는 정보.
    1. 웹 서버에서 인증하고 난 다음 Set-Cookie로 값을 세팅한 뒤 브라우저로 보낸다
    2. 브라우저가 Cookie 값을 읽어들여서 클라이언트 PC상에 저장한다.
    3. i.의 웹서버에 다시 요청할 일이 생기면 cookie 값을 header에 실어 보낸다. <br/>
    => 단점 : 쿠키는 개발자 도구로도 쉽게 확인해 볼 수 있다.
 * 세션 : session ID를 가지고 인증한다.
    1. 웹 서버에서 session ID를 발행하고, 쿠키에 담아 웹 브라우저에 보낸다.
    2. 웹 서버에 요청을 보내야 할 경우 session ID를 쿠키에 담아 웹 서버에 보낸다.
    3. 웹 서버는 session ID를 꺼내서 메모리의 data와 비교한다. <br/>
    => 쿠키를 이용하지만, session ID를 주고 받는 것이 큰 차이점!! (java에서는 JsessionID라는 것을 쓰는 것 같다.)
    
    
