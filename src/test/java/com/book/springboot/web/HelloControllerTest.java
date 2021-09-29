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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)  //SpringRunner: 스프링 실행자 역할로, 스프링부트 테스트와 JUnit 사이를 연결해준다.
@WebMvcTest(controllers = HelloController.class)  //Spring MVC에 집중하는 어노테이션.
public class HelloControllerTest {

    @Autowired  //스프링이 관리하는 Bean을 주입받음.
    private MockMvc mvc;  //Spring MVC 테스트의 시작지점, GET과 POST에 대한 API테스트를 담당함.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  //hello 주소로 GET 요청.
                //mvc.perform의 결과를 검증
                .andExpect(status().isOk())  //HTTP Header의 Status를 검증.
                .andExpect(content().string(hello));  //main에서 반환하는 문자열과 일치하는지 검증.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)  //param: API테스트에 사용될 요청 파라미터 설정 (String만 허용)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))  //jsonPath: JSON 응답값을 필드별로 검증하는 메소드. $를 기준으로 필드명을 명시함.
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}