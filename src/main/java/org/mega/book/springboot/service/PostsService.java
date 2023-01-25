package org.mega.book.springboot.service;


import lombok.RequiredArgsConstructor;
import org.mega.book.springboot.domain.post.Post;
import org.mega.book.springboot.domain.post.PostRepository;
import org.mega.book.springboot.web.dto.PostsResponseDto;
import org.mega.book.springboot.web.dto.PostsSaveRequestDto;
import org.mega.book.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }


    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        post.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Post entity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
