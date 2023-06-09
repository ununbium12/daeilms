package com.example.final_201930325.dto;

public class BoardDto {

    public String title;
    public String contents;
    public String userName;

    public BoardDto(String title, String contents, String userName) {
        this.title = title;
        this.contents = contents;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
