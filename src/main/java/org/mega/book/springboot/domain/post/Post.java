package org.mega.book.springboot.domain.post;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder /*
        해당 클래스의 빌더 패턴 클래스 생성(보안을 향상을 위해 디자인 패턴)
        생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
        객체를 생성하는 클래스와 표현하는 클래스를 분리 서로 다른 표현로 제공
    */
    public Post(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
