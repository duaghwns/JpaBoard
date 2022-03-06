package com.example.demo.service.impl;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.repository.BoardRepository;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<BoardDto> getAllBoard() {
        List<Board> all = boardRepository.findAll();
        List<BoardDto> result = new ArrayList<>();
        all.forEach(board -> result.add(board.entityToDto()));

        return result;
    }

    @Override
    public void save(BoardDto board) {
        Board entity = Board.builder()
                .content(board.getContent())
                .regDate(LocalDateTime.now())
                .title(board.getTitle())
                .author(new Member(1L, "ho1234" ,"염호준",27,"hojoon"))
                .build();
        boardRepository.save(entity);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void modify(BoardDto board) {

    }

    @Override
    public BoardDto findById(Long id) {
        return null;
    }
}
