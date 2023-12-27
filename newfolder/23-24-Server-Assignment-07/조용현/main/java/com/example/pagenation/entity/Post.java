package com.example.pagenation.entity;

import com.example.pagenation.dto.PostDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;


    public static Post toEntity(PostDTO postRequestDto){
        return Post.builder()
                .author(postRequestDto.getAuthor())
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .build();
    }

}
