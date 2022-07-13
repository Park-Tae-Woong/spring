package com.sparta.noticeboard.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRequestDto {
    private final String title;
    private final String name;
    private final String password;
    private final String content;


}
