package com.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA에서 DB Layer접근자는 Repository라고 부르며, 인터페이스로 생성한다.
 * JpaRepository<Entity 클래스명, PK 타입> 을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
