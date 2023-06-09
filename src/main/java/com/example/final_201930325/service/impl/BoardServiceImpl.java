package com.example.final_201930325.service.impl;

import com.example.final_201930325.dao.BoardDAO;
import com.example.final_201930325.dto.BoardDto;
import com.example.final_201930325.dto.BoardResponseDto;
import com.example.final_201930325.entity.Board;
import com.example.final_201930325.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    private String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName(); // userId가 사용자의 이름으로 저장되어 있는 경우

        return userId;
    }

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public BoardResponseDto getBoard(Long id) {
        Board board = boardDAO.selectBoard(id);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(board.getId());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContents(board.getContents());
        boardResponseDto.setUserId(board.getUserId());
        boardResponseDto.setUserName(board.getUserName());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto saveBoard(BoardDto boardDto) {
        Board board = new Board();
        String userId = getUserId(); // 로그인된 사용자의 userId를 얻어옴
        board.setTitle(boardDto.getTitle());
        board.setContents(boardDto.getContents());
        // 자동으로 로그인 되어 있는 유저의 uId를 읽어서 userId를 입력
        board.setUserId(userId);
        board.setUserName(boardDto.getUserName());
        board.setCreatedAt(LocalDateTime.now());
        board.setUpdatedAt(LocalDateTime.now());

        Board saveBoard = boardDAO.insertBoard(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(saveBoard.getId());
        boardResponseDto.setTitle(saveBoard.getTitle());
        boardResponseDto.setContents(saveBoard.getContents());
        boardResponseDto.setUserId(saveBoard.getUserId());
        boardResponseDto.setUserName(saveBoard.getUserName());
        return boardResponseDto;
    }

    @Override
    public BoardResponseDto changeBoardContents(Long id, String contents) throws Exception {
        Board changeBoard = boardDAO.updateBoardContents(id, contents);
        Board board = boardDAO.selectBoard(id);

        if (board == null) {
            throw new Exception("게시글이 존재하지 않습니다.");
        }

        String userId = getUserId(); // 로그인된 사용자의 userId를 얻어옴

        if (!board.getUserId().equals(userId)) {
            throw new Exception("게시글을 삭제할 권한이 없습니다.");
        }

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(changeBoard.getId());
        boardResponseDto.setContents(changeBoard.getContents());
        return boardResponseDto;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        Board board = boardDAO.selectBoard(id);

        if (board == null) {
            throw new Exception("게시글이 존재하지 않습니다.");
        }

        String userId = getUserId(); // 로그인된 사용자의 userId를 얻어옴

        if (!board.getUserId().equals(userId)) {
            throw new Exception("게시글을 삭제할 권한이 없습니다.");
        }
        boardDAO.deleteBoard(id);
    }

    @Override
    public List<BoardResponseDto> getAllBoards() {
        List<Board> boards = boardDAO.selectAllBoards();

        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();
        for(Board board : boards) {
            BoardResponseDto boardResponseDto = new BoardResponseDto();
            boardResponseDto.setId(board.getId());
            boardResponseDto.setTitle(board.getTitle());
            boardResponseDto.setContents(board.getContents());
            boardResponseDto.setUserId(board.getUserId());
            boardResponseDto.setUserName(board.getUserName());
            boardResponseDtos.add(boardResponseDto);
        }

        return boardResponseDtos;
    }

    @Override
    public List<BoardResponseDto> getAllBoardsOrderByCreatedAt() {
        List<Board> boards = boardDAO.selectAllBoardsOrderByCreatedAt();

        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();
        for(Board board : boards) {
            BoardResponseDto boardResponseDto = new BoardResponseDto();
            boardResponseDto.setId(board.getId());
            boardResponseDto.setTitle(board.getTitle());
            boardResponseDto.setContents(board.getContents());
            boardResponseDto.setUserId(board.getUserId());
            boardResponseDto.setUserName(board.getUserName());
            boardResponseDtos.add(boardResponseDto);
        }

        return boardResponseDtos;
    }

    @Override
    public List<BoardResponseDto> getBoardsByUserId(String userId) {
        List<Board> boards = boardDAO.selectBoardsByUserId(userId);

        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();
        for(Board board : boards) {
            BoardResponseDto boardResponseDto = new BoardResponseDto();
            boardResponseDto.setId(board.getId());
            boardResponseDto.setTitle(board.getTitle());
            boardResponseDto.setContents(board.getContents());
            boardResponseDto.setUserId(board.getUserId());
            boardResponseDto.setUserName(board.getUserName());
            boardResponseDtos.add(boardResponseDto);
        }

        return boardResponseDtos;
    }
}
