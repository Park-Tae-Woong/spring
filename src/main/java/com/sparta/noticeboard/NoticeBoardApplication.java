package com.sparta.noticeboard;

import com.sparta.noticeboard.domain.Board;
import com.sparta.noticeboard.domain.BoardRepository;
import com.sparta.noticeboard.domain.BoardRequestDto;
import com.sparta.noticeboard.service.BoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;


@SpringBootApplication
@EnableJpaAuditing
public class NoticeBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeBoardApplication.class, args);
    }

}
