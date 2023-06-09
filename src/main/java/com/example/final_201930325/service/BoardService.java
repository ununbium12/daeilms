package com.example.final_201930325.service;

import com.example.final_201930325.dto.BoardDto;
import com.example.final_201930325.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {

    BoardResponseDto getBoard(Long id);
    BoardResponseDto saveBoard(BoardDto boardDto);
    BoardResponseDto changeBoardContents(Long id, String contents) throws Exception;

    List<BoardResponseDto> getAllBoards();
    List<BoardResponseDto> getAllBoardsOrderByCreatedAt();
    List<BoardResponseDto> getBoardsByUserId(String userId);

    void deleteBoard(Long id) throws Exception;



}
