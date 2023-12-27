package com.example.pagenation.dto;

import lombok.Data;

@Data
public class PostPagingDto {

    private int page;
    private int size;
    private String sort;

}
