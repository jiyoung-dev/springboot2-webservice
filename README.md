# 📚Spring Boot Study
> [스프링부트와 AWS로 혼자 구현하는 웹서비스](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788965402602) 를 읽고 정리한 내용입니다. 

## IntelliJ에서 자동생성되는 파일 ignore 처리
깃에서 특정 파일이나 디렉토리를 관리 대상에서 제외하고 싶은경우 .gitignore 파일을 사용한다.
```
# Project exclude paths
/.gradle/
/.idea/
```

## 자주 사용하는 IntelliJ 단축키 
- 깃 커밋창 열기: ctrl + k
- 자동 push: ctrl + shift + k
- 자동 import: alt + enter
- 플러그인 Action 실행: ctrl + shift + a

## TDD는 Unit Test가 아니다 
- TDD: 테스트가 주도하는 개발 
- Unit Test: 기능 단위의 테스트 
> <b>테스트코드를 작성하면 좋은점</b>
> - 톰캣 실행, 중지를 반복하지 않아도 된다. 
> - 요청결과를 System.out.println() 으로 검증하지 않아도된다. 
> - 새로운 기능이 추가될때, 기존의 기능이 잘 작동되는 것을 보장해준다.
> - 대표적으로 xUnit 프레임워크가 존재, Java에서는 JUnit 사용.

## 내장 WAS 사용하기 
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
- SpringApplication.run
    - 내장 WAS를 실행시켜주는 메서드. 
    - 스프링부트에서는 내장 WAS를 사용하는걸 권장한다. Jar파일로 언제 어디서나 스프링부트를 배포할 수 있기때문.
    - Tomcat은 대표적인 WAS중 하나로, 서블릿으로 이루어진 자바 애플리케이션이다.   
    
- @SpringBootApplication
    - 이 어노테이션이 있는 위치부터 설정을 읽어간다. (스프링부트 자동설정, 스프링 Bean 읽기와 생성)
    - 해당 클래스는 항상 프로젝트 최상단에 위치함. 


