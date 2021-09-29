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

## 프로젝트에 롬복 추가하기 
롬복은 자바 개발시 자주 사용하는 Getter, Setter, 생성자, toString 등을 어노테이션으로 자동 생성해준다. 
<br>롬복은 프로젝트마다 설정해줘야한다.  
```
dependencies {
    compile('org.projectlombok:lombok')
}
```
- build.gradle에 위의 코드 추가 후, Refresh(새로고침)
- Marketplace에서 "lombok" install 
- Preferences에서 Enable annotation processing 체크

## 테스트 코드 작성법 
내가 만든 API를 테스트코드로 검증해보기

1. API 생성 
```java
package com.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }
}
```
- @RestController 
  - JSON을 반환하는 컨트롤러로 만들어주는 어노테이션. 
  - @ResponseBody를 각 메소드마다 선언해야하는 불편함을 없애준다.
  
- @GetMapping
  - Get요청을 받을 수 있는 API를 생성하는 어노테이션. 
  
2. 테스트 클래스 생성
```java
package com.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)  
@WebMvcTest(controllers = HelloController.class) 
public class HelloControllerTest {

  @Autowired  
  private MockMvc mvc;  

  @Test
  public void hello가_리턴된다() throws Exception {
    String hello = "hello";

    mvc.perform(get("/hello"))
            .andExpect(status().isOk()) 
            .andExpect(content().string(hello));  
  }
}
```
- @RunWith(SpringRunner.class)
  - 테스트를 진행시킬 실행자를 실행하는 어노테이션. 
  - SpringRunner는 스프링부트 테스트와 JUnit 사이에 연결자 역할을 수행함. 
  
- @WebMvcTest
  - Spring MVC에 집중할 수 있는 어노테이션. 
  - @Controller, @ControllerAdvice 등을 사용할 수 있어, 컨트롤러에서 주로 사용함. 
  
- @Autowired
  - 스프링이 관리하는 Bean을 주입 받는다. 
  
- private MockMvc mvc
  - 웹 API (GET, POST)를 테스트할 때 사용함. 
  - 이부분이 스프링 MVC 테스트의 시작점이다. 

- mvc.perform(get("/hello"))
  - MockMvc를 통해 /hello 주소로 GET요청 수행. 
  - 체이닝이 지원되기 때문에 여러 검증기능을 이어서 선언하면 편리하다. 
  
- andExpect(status().isOk()) 
  - mvc.perform의 결과를 검증함. 
  - HTTP Header의 Status를 검증하며, isOK()는 200인지 아닌지를 검증.
  
- andExpect(content().string(hello))
  - 응답 본문의 내용을 검증함.
  
