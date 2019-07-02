## JSP

#### 알게 된 것

##### @WebServlet(loadOnStartup = 1) 
-> loadOnStartup = 1 우선 매핑

#### 에러 해결 사랑
sendRedirect() 호출 전에 forward()를 호출해 버리면 "응답이 이미 커밋된 후에는, sendRedirect()를 호출할 수 없습니다"라는 오류를 볼 수 있다.
내가 알게 모르게 forward를 어디선가 선 호출하고 있는지 체크해 보자!
