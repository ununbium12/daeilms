package com.example.final_201930325.dao;

import com.example.final_201930325.entity.Board;

import java.util.List;

public interface BoardDAO {

    Board insertBoard(Board board);
    Board selectBoard(Long id);
    Board updateBoardContents(Long id, String contents) throws Exception ;
    void deleteBoard(Long id) throws Exception;

    List<Board> selectAllBoards();
    List<Board> selectAllBoardsOrderByCreatedAt();
    List<Board> selectBoardsByUserId(String userId);
}
