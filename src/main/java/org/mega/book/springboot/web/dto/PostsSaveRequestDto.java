package org.mega.book.springboot.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mega.book.springboot.domain.post.Post;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;

    private String content;

    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
