package com.example.final_201930325.dao.impl;

import com.example.final_201930325.dao.BoardDAO;
import com.example.final_201930325.entity.Board;
import com.example.final_201930325.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BoardDAOImpl implements BoardDAO {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board insertBoard(Board board) {
        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }

    @Override
    public Board selectBoard(Long id) {
        Board selectBoard = boardRepository.getReferenceById(id);
        return selectBoard;
    }

    @Override
    public Board updateBoardContents(Long id, String contents) throws Exception {
        Optional<Board> selectBoard = boardRepository.findById(id);

        Board updateBoard;
        if(selectBoard.isPresent()) {
            Board board = selectBoard.get();
            board.setContents(contents);
            board.setUpdatedAt(LocalDateTime.now());

            updateBoard = boardRepository.save(board);
        } else throw new Exception();
        return updateBoard;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(id);

        if (selectedBoard.isPresent()) {
            Board board = selectedBoard.get();
            boardRepository.delete(board);
        } else throw new Exception();
    }

    @Override
    public List<Board> selectAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public List<Board> selectAllBoardsOrderByCreatedAt() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Board> selectBoardsByUserId(String userId) {
        return boardRepository.findByUserId(userId);
    }
}
