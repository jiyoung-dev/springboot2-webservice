# ๐Spring Boot Study
> [์คํ๋ง๋ถํธ์ AWS๋ก ํผ์ ๊ตฌํํ๋ ์น์๋น์ค](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788965402602) ๋ฅผ ์ฝ๊ณ  ์ ๋ฆฌํ ๋ด์ฉ์๋๋ค. 

## IntelliJ์์ ์๋์์ฑ๋๋ ํ์ผ ignore ์ฒ๋ฆฌ
๊น์์ ํน์  ํ์ผ์ด๋ ๋๋ ํ ๋ฆฌ๋ฅผ ๊ด๋ฆฌ ๋์์์ ์ ์ธํ๊ณ  ์ถ์๊ฒฝ์ฐ .gitignore ํ์ผ์ ์ฌ์ฉํ๋ค.
```
# Project exclude paths
/.gradle/
/.idea/
```

## ์์ฃผ ์ฌ์ฉํ๋ IntelliJ ๋จ์ถํค 
- ๊น ์ปค๋ฐ์ฐฝ ์ด๊ธฐ: ctrl + k
- ์๋ push: ctrl + shift + k
- ์๋ import: alt + enter
- ํ๋ฌ๊ทธ์ธ Action ์คํ: ctrl + shift + a

## TDD๋ Unit Test๊ฐ ์๋๋ค 
- TDD: ํ์คํธ๊ฐ ์ฃผ๋ํ๋ ๊ฐ๋ฐ 
- Unit Test: ๊ธฐ๋ฅ ๋จ์์ ํ์คํธ 
> <b>ํ์คํธ์ฝ๋๋ฅผ ์์ฑํ๋ฉด ์ข์์ </b>
> - ํฐ์บฃ ์คํ, ์ค์ง๋ฅผ ๋ฐ๋ณตํ์ง ์์๋ ๋๋ค. 
> - ์์ฒญ๊ฒฐ๊ณผ๋ฅผ System.out.println() ์ผ๋ก ๊ฒ์ฆํ์ง ์์๋๋๋ค. 
> - ์๋ก์ด ๊ธฐ๋ฅ์ด ์ถ๊ฐ๋ ๋, ๊ธฐ์กด์ ๊ธฐ๋ฅ์ด ์ ์๋๋๋ ๊ฒ์ ๋ณด์ฅํด์ค๋ค.
> - ๋ํ์ ์ผ๋ก xUnit ํ๋ ์์ํฌ๊ฐ ์กด์ฌ, Java์์๋ JUnit ์ฌ์ฉ.

## ๋ด์ฅ WAS ์ฌ์ฉํ๊ธฐ 
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
- SpringApplication.run
    - ๋ด์ฅ WAS๋ฅผ ์คํ์์ผ์ฃผ๋ ๋ฉ์๋. 
    - ์คํ๋ง๋ถํธ์์๋ ๋ด์ฅ WAS๋ฅผ ์ฌ์ฉํ๋๊ฑธ ๊ถ์ฅํ๋ค. Jarํ์ผ๋ก ์ธ์  ์ด๋์๋ ์คํ๋ง๋ถํธ๋ฅผ ๋ฐฐํฌํ  ์ ์๊ธฐ๋๋ฌธ.
    - Tomcat์ ๋ํ์ ์ธ WAS์ค ํ๋๋ก, ์๋ธ๋ฆฟ์ผ๋ก ์ด๋ฃจ์ด์ง ์๋ฐ ์ ํ๋ฆฌ์ผ์ด์์ด๋ค.   
    
- @SpringBootApplication
    - ์ด ์ด๋ธํ์ด์์ด ์๋ ์์น๋ถํฐ ์ค์ ์ ์ฝ์ด๊ฐ๋ค. (์คํ๋ง๋ถํธ ์๋์ค์ , ์คํ๋ง Bean ์ฝ๊ธฐ์ ์์ฑ)
    - ํด๋น ํด๋์ค๋ ํญ์ ํ๋ก์ ํธ ์ต์๋จ์ ์์นํจ. 

## ํ๋ก์ ํธ์ ๋กฌ๋ณต ์ถ๊ฐํ๊ธฐ 
๋กฌ๋ณต์ ์๋ฐ ๊ฐ๋ฐ์ ์์ฃผ ์ฌ์ฉํ๋ Getter, Setter, ์์ฑ์, toString ๋ฑ์ ์ด๋ธํ์ด์์ผ๋ก ์๋ ์์ฑํด์ค๋ค. 
<br>๋กฌ๋ณต์ ํ๋ก์ ํธ๋ง๋ค ์ค์ ํด์ค์ผํ๋ค.  
```
dependencies {
    compile('org.projectlombok:lombok')
}
```
- build.gradle์ ์์ ์ฝ๋ ์ถ๊ฐ ํ, Refresh(์๋ก๊ณ ์นจ)
- Marketplace์์ "lombok" install 
- Preferences์์ Enable annotation processing ์ฒดํฌ

## ํ์คํธ ์ฝ๋ ์์ฑ๋ฒ 
๋ด๊ฐ ๋ง๋  API๋ฅผ ํ์คํธ์ฝ๋๋ก ๊ฒ์ฆํด๋ณด๊ธฐ

1. API ์์ฑ 
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
  - JSON์ ๋ฐํํ๋ ์ปจํธ๋กค๋ฌ๋ก ๋ง๋ค์ด์ฃผ๋ ์ด๋ธํ์ด์. 
  - @ResponseBody๋ฅผ ๊ฐ ๋ฉ์๋๋ง๋ค ์ ์ธํด์ผํ๋ ๋ถํธํจ์ ์์ ์ค๋ค.
  
- @GetMapping
  - Get์์ฒญ์ ๋ฐ์ ์ ์๋ API๋ฅผ ์์ฑํ๋ ์ด๋ธํ์ด์. 
  
2. ํ์คํธ ํด๋์ค ์์ฑ
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
  public void hello๊ฐ_๋ฆฌํด๋๋ค() throws Exception {
    String hello = "hello";

    mvc.perform(get("/hello"))
            .andExpect(status().isOk()) 
            .andExpect(content().string(hello));  
  }
}
```
- @RunWith(SpringRunner.class)
  - ํ์คํธ๋ฅผ ์งํ์ํฌ ์คํ์๋ฅผ ์คํํ๋ ์ด๋ธํ์ด์. 
  - SpringRunner๋ ์คํ๋ง๋ถํธ ํ์คํธ์ JUnit ์ฌ์ด์ ์ฐ๊ฒฐ์ ์ญํ ์ ์ํํจ. 
  
- @WebMvcTest
  - Spring MVC์ ์ง์คํ  ์ ์๋ ์ด๋ธํ์ด์. 
  - @Controller, @ControllerAdvice ๋ฑ์ ์ฌ์ฉํ  ์ ์์ด, ์ปจํธ๋กค๋ฌ์์ ์ฃผ๋ก ์ฌ์ฉํจ. 
  
- @Autowired
  - ์คํ๋ง์ด ๊ด๋ฆฌํ๋ Bean์ ์ฃผ์ ๋ฐ๋๋ค. 
  
- private MockMvc mvc
  - ์น API (GET, POST)๋ฅผ ํ์คํธํ  ๋ ์ฌ์ฉํจ. 
  - ์ด๋ถ๋ถ์ด ์คํ๋ง MVC ํ์คํธ์ ์์์ ์ด๋ค. 

- mvc.perform(get("/hello"))
  - MockMvc๋ฅผ ํตํด /hello ์ฃผ์๋ก GET์์ฒญ ์ํ. 
  - ์ฒด์ด๋์ด ์ง์๋๊ธฐ ๋๋ฌธ์ ์ฌ๋ฌ ๊ฒ์ฆ๊ธฐ๋ฅ์ ์ด์ด์ ์ ์ธํ๋ฉด ํธ๋ฆฌํ๋ค. 
  
- andExpect(status().isOk()) 
  - mvc.perform์ ๊ฒฐ๊ณผ๋ฅผ ๊ฒ์ฆํจ. 
  - HTTP Header์ Status๋ฅผ ๊ฒ์ฆํ๋ฉฐ, isOK()๋ 200์ธ์ง ์๋์ง๋ฅผ ๊ฒ์ฆ.
  
- andExpect(content().string(hello))
  - ์๋ต ๋ณธ๋ฌธ์ ๋ด์ฉ์ ๊ฒ์ฆํจ.
  
