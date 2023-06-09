package com.example.final_201930325.dto;

public class ChangeBoardDto {

    private Long id;
    private String contents;

    public ChangeBoardDto(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }

    public ChangeBoardDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
