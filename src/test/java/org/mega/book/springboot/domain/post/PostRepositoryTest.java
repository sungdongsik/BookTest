package org.mega.book.springboot.domain.post;

import junit.framework.TestCase;
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
public class PostRepositoryTest{
    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void noticeBoardLoad(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Post.builder().
                title(title)
                .content(content)
                .author("dolphin@gmail.com")
                .build());

        List<Post> postsList = postRepository.findAll();
        Post post = postsList.get(0);

        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }
}