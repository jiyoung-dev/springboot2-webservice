package com.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  //JUnit에서 단위테스트가 끝날때마다 수행되는 메소드를 지정
    public void cleanup() {
        postsRepository.deleteAll();  //테스트간의 데이터 침범을 막기위해 테스트 실행마다 리포지토리를 비워준다.
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()  //postsRepository.save(): posts 테이블에 insert/update 쿼리 실행
        .title(title)
        .content(content)
        .author("test@gmail.com")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();  //postsRepository.findAll(): posts 테이블에 있는 모든 데이터를 조회하는 메소드.

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}