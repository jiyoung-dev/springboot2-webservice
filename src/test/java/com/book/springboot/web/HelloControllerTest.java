package com.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}