package com.book.springboot.domain.posts;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity  //JPA의 어노테이션 (중요한 어노테이션을 클래스에 가깝게 둔다)
public class Posts {  //실제 DB테이블과 매칭될 Entity클래스
    /**
     * @Entity: 테이블과 링크될 클래스임을 나타냄. 테이블명은 클래스명을 언더스코어 네이밍으로 매칭하는것이 기본.
     * @Id: 해당 테이블의 PK필드를 나타냄.
     * @GeneratedValue: PK의 생성규칙을 나타냄.
     * @Column: 테이블의 컬럼을 나타냄. (클래스의 필드는 default가 모두 컬럼이다.)
     * @Builder: 해당 클래스의 빌더 패턴 클래스를 생성.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //spring-boot 2.0부터 auto_increment를 사용하려면 GenerationType.IDENTITY 옵션을 추가해야함.
    private Long id;

    @Column(length = 500, nullable = false )
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder  //@Builder를 이렇게 생성자 상단에 선언하는 경우, 생성자에 포함된 필드만 빌더에 포함시킴.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


}
