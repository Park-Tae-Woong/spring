package com.sparta.noticeboard.controller;

import com.sparta.noticeboard.domain.Board;
import com.sparta.noticeboard.domain.BoardRepository;
import com.sparta.noticeboard.dto.BoardRequestDto;
import com.sparta.noticeboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;

    private final BoardService boardService;


    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards")
    public List<Board> getboards() {
        return boardRepository.findAll();
    }


    @GetMapping("/api/boards/{id}")
    public Optional<Board> getOneBoard(@PathVariable Long id) {
        return boardRepository.findById(id);
    }

    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        Optional<Board> board = boardRepository.findById(id);
        if (requestDto.getPassword().equals(board.get().getPassword())) {
            boardService.update(id, requestDto);
        } else {
            System.out.println("비밀번호 오류");
        } return id;
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        Optional<Board> board = boardRepository.findById(id);
        if (requestDto.getPassword().equals(board.get().getPassword())) {
            boardRepository.deleteById(id);
        } else {
            System.out.println("비밀번호 오류");
        }
        return id;
    }


}