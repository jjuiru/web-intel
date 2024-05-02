package com.mohaji.dockertest.board.service;



import com.mohaji.dockertest.board.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
	
	List<BoardDto> selectBoardList();
	
	void insertBoard(BoardDto board);

}
