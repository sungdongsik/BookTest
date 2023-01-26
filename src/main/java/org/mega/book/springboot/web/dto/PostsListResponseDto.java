package org.mega.book.springboot.web.dto;


import lombok.Getter;
import org.mega.book.springboot.domain.post.Post;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate =entity.getModifiedDate();
    }
}
