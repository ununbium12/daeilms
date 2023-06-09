package com.example.final_201930325.controller;

import com.example.final_201930325.dto.BoardDto;
import com.example.final_201930325.dto.BoardResponseDto;
import com.example.final_201930325.dto.ChangeBoardDto;
import com.example.final_201930325.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public ResponseEntity<BoardResponseDto> getBoard(Long id) {
        BoardResponseDto boardResponseDto = boardService.getBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<BoardResponseDto> creatBoard(@RequestBody BoardDto boardDto) {
        BoardResponseDto boardResponseDto = boardService.saveBoard(boardDto);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PutMapping()
    public ResponseEntity<BoardResponseDto> changeBoardContents(@RequestParam ChangeBoardDto changeBoardDto) throws Exception {
        BoardResponseDto boardResponseDto = boardService.changeBoardContents(changeBoardDto.getId(), changeBoardDto.getContents());
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBoard(Long id) throws Exception {
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardResponseDto>> getBoardList() {
        List<BoardResponseDto> boardList = boardService.getAllBoards();
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @GetMapping("/listOrderByCreatedAt")
    public ResponseEntity<List<BoardResponseDto>> getBoardListOrderByCreatedAt() {
        List<BoardResponseDto> boardList = boardService.getAllBoardsOrderByCreatedAt();
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @GetMapping("/byUserId")
    public ResponseEntity<List<BoardResponseDto>> getBoardListByUserId(@RequestParam String userId) {
        List<BoardResponseDto> boardList = boardService.getBoardsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }
}
