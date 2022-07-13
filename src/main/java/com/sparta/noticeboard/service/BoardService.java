package com.sparta.noticeboard.service;

import com.sparta.noticeboard.domain.Board;
import com.sparta.noticeboard.domain.BoardRepository;
import com.sparta.noticeboard.dto.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BoardService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final BoardRepository boardRepository;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, BoardRequestDto boardRequestDto) {

        Board board1 = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board1.update(boardRequestDto);
        return board1.getId();
    }

//    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
//    public Long delete(Long id, BoardRequestDto boardRequestDto) {
//
//        Board board1 = boardRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
//        );
//        board1.delete(boardRequestDto);
//        return board1.getId();
//    }

}