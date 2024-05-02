package com.mohaji.dockertest.board.controller;

import com.mohaji.dockertest.board.dto.BoardDto; // BoardDto를 임포트합니다.
import com.mohaji.dockertest.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/")
    public String openBoardList(Model model){

        List<BoardDto> list = boardService.selectBoardList();
        model.addAttribute("list", list);

        return "index";
    }

    @RequestMapping("/index")
    public String mainList(Model model){

        List<BoardDto> list = boardService.selectBoardList();
        System.out.println("이건 셀렉트"+list);
        model.addAttribute("list", list);

        return "index";
    }

    @RequestMapping("/write")
    public String write(){
        return "write";
    }

    @RequestMapping("/save")
    public String insertBoard(BoardDto board) throws Exception{
        System.out.println("이건 세이브"+board);
        boardService.insertBoard(board);
        return "/index";
    }
}
