package com.example.demo.service;

import com.example.demo.dto.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> getAllBoard();
    void save(BoardDto board);
    void delete(Long id );
    void modify(BoardDto board);
    BoardDto findById(Long id);

}
