package com.example.final_201930325.dto;

public class BoardResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String userId;
    private String userName;

    public BoardResponseDto(){}

    public BoardResponseDto(Long id, String title, String contents, String userId, String userName) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
