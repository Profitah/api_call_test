package com.example.pagenation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomPageResponse<T> {

    private List<T> content;
    private int size;
    private int totalPages;
    private long totalElements;
}
