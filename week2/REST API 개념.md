<h3>REST API</h3>

<hr>

- REST (Representation State Transfer)
  - 자원을 이름으로 구분하여 해당 자원의 상태를 주고받는 모든 것
  
  - 자원의 표현에 의한 상태 전달
  
  - ROA (Resource Oriented Architecture)
  
  - REST CURD Operation
    
    - Create: POST
    
    - Read: GET
    - Update: PUT
    - Delete: DELETE
    
  - REST 특징
    - Server-Client
      
      자원이 있는 쪽이 Server, 자원을 요청하는 쪽이 Client
      
      REST Server: API를 제공, 비즈니스 로직 처리 및 저장을 책임
      
      Client: 사용자 인증이나 세션, 로그인 정보 등을 직접 관리하고 책임
      
      서로 간 의존성이 줄어듦
      
    - Stateless
      
      Client의 context (세션, 로그인 정보)를 Server에 저장하지 않음
      
      Server는 각각의 요청을 완전히 별개의 것으로 인식하고 처리
      
    - Cacheable
      
      웹 표준 HTTP Protocol을 그대로 사용하므로 웹에서 사용하는 기존의 인프라 그대로 활용 가능
      
      캐시 사용을 통해 응답시간이 빨라지고 REST Server 트랜젝션이 발생하지 않기 때문에 전체 응답시간, 성능, 서버의 자원 이용률을 향상시킬 수 있음
      
    - Layered System
    
      클라이언트는 REST API Server만 호출
    
      중간 서버는 로드 밸런싱 기능이나 공유 캐시 기능을 제공함으로써 시스템 규모 확장성을 향상시키는 데 유용
    
    - Code-on-Demand
      
      Server로부터 스크립트를 받아서 Client에서 실행
      
    - Uniform Interface
      URI로 지정한 Resource에 대한 조직을 통일되고 한정적인 인터페이스로 수행
      
      HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용 가능 (특정 언어나 기술에 종속X)



- REST API

  - REST 기반으로 서비스 API를 구현한 것

    - API: Application Programming Interface

      데이터와 기능의 집합을 제공하여 컴퓨터 프로그램 간 상호작용을 촉진, 서로 정보 교환 가능하도록 하는 것

  - OpenAPI, 마이크로 서비스 등을 제공

  - 언어에 구애받지 않으며 웹과 마찬가지로 HTTP를 통해 들어오고 나가는 정보를 처리 (JSON을 기본 메시지 형식으로 사용)

    - JSON: JavaScript Object Notation
  
      객체를 만들 때 사용하는 하나의 데이터 저장 방식
  
      객체 상태로 데이터를 전달할 수 없기 때문에 객체를 문자열로 변환해서 전달해야 함

      문자열을 받으려면 객체로 변환해서 웹 페이지에서 데이터를 사용자에게 출력

      Name-Value 형식의 쌍
  
  - REST API 특징
  
    - 확장성과 재사용성을 높여 유지보수 및 운용 편리
    - HTTP 표준을 기반으로 구현하므로 HTTP를 지원하는 프로그램 언어로 클라이언트, 서버를 구현 가능
    - 델파이 클라이언트뿐만 아니라 Java, C#, 웹 등을 이용해 클라이언트 제작 가능
    
  - REST API URL 패턴 (관례)
  
    - Query String 사용 X
  
      ex) http://localhost:8080/studentServer/api/student/3
  
      Request Method = GET
  
    - 동사 사용 X
  
      http://localhost:8080/studentServer/studentDelete?id-3 (X)
  
      http://localhost:8080/studentServer/api/student/3
  
      Request Method = DELETE (O)



- HTTP (Hypertext Transfer Protocol)

  - 웹 브라우저와 웹 서버 간의 표준 통신 규약

  - 클라이언트와 서버가 연결을 맺는 방법, 클라이언트가 서버에게 데이터를 요청하는 방법, 서버가 요청에 응답하는 방법, 연결을 종료하는 방법에 대해 명시

  - HTTP 1.0 통신 과정

    1. 클라이언트가 서버의 80 포트에 TCP 통신 연결 시도 (URL에 포트 번호가 포함되어 있다면 그 포트 번호를 사용)

    2. 클라이언트가 특정 경로에 위치한 리소스를 요청하는 메시지를 서버로 보냄

       요청의 내용: header + (blank line + body)

    3. 서버는 클라이언트에게 응답을 보냄

       응답의 내용: response code + header + blank line + body

       header의 내용: metadata

       body의 내용: html 문서, 이미지 파일, 다운로드 파일 등

    4. 서버는 클라이언트와 연결 종료

  - HTTP 1.1 이후 버전

    - 1.0 버전에서 2번과 3번 절차를 여러 번 반복 실행한 후 연결 종료
    - TCP 연결 후 요청과 응답을 여러 번 반복 가능
    - 서버에 한 번 연결하면 여러 파일을 전달받고서 연결을 끊을 수 있기 때문에 효율적



- 브라우저에 대해 URL 입력 후 요청하여 서버에서 응답하는 과정

  1. 웹 브라우저가 서버에 요청(HTTP Request)을 전달

     이 요청에는 요청 대상을 가리키는 URL이 담겨 있음

  2. 웹 브라우저로부터 서버에 전달된 요청을 Spring Web MVC 엔진이 받음

     Spring 엔진은 요청된 URL과 일치하는 Controller의 액션 메소드를 찾아서 호출

  3. Controller의 액션 메소드는 Java 객체 리턴

  4. 리턴된 Java 객체는 Spring Web MVC 엔진에 의해 JSON 형태의 문자열로 변경

  5. JSON 형태의 문자열이 웹 브라우저에 전송

     이 전송을 최초 웹 브라우저의 요청(HTTP Request)에 대한 응답(HTTP Response): View

  6. 웹 서버로부터 전송된 JSON 형태의 문자열이 웹 브라우저에 표시
