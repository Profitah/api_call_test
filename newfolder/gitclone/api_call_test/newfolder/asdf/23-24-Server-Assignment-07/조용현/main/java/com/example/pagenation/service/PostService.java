package com.example.pagenation.service;

import com.example.pagenation.dto.CustomPageResponse;
import com.example.pagenation.dto.PostDTO;
import com.example.pagenation.dto.PostPagingDto;
import com.example.pagenation.entity.Post;
import com.example.pagenation.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(PostDTO postRequestDto) {
        Post post = Post.toEntity(postRequestDto);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public CustomPageResponse<PostDTO> findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);
        List<PostDTO> postDTOList = postPages.getContent().stream()
                .map(PostDTO::new)
                .toList();

        CustomPageResponse<PostDTO> customPageResponse = new CustomPageResponse<>();
        customPageResponse.setContent(postDTOList);
        customPageResponse.setSize(postPages.getSize());
        customPageResponse.setTotalPages(postPages.getTotalPages());
        customPageResponse.setTotalElements(postPages.getTotalElements());
        return customPageResponse;

    }
}
