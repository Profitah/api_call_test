package com.example.pagenation.controller;

import com.example.pagenation.dto.CustomPageResponse;
import com.example.pagenation.dto.PostDTO;
import com.example.pagenation.dto.PostPagingDto;
import com.example.pagenation.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void save (@RequestBody PostDTO postRequestDto){
        postService.save(postRequestDto);
    }

    @GetMapping
    public ResponseEntity<CustomPageResponse<PostDTO>> findAll(@RequestBody PostPagingDto postPagingDto){
        return ResponseEntity.ok(postService.findAllPosts(postPagingDto));
    }
}
