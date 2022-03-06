package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexContoller {

    private final BoardService boardService;

    @RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model){
        List<BoardDto> allBoard = boardService.getAllBoard();
        model.addAttribute("board",allBoard);
        return "index";
    }

}
