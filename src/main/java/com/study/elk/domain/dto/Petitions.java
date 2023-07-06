package com.study.elk.domain.dto;


import com.study.elk.request.NonIdPetition;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Petitions {
    private String title;
    private String content;
    private int likes;
    private int userId;
    private Integer tableId;

    public Petitions(NonIdPetition nonIdPetition, int userId,Integer tableId) {
        this.title = nonIdPetition.getTitle();
        this.content = nonIdPetition.getContent();
        this.likes = nonIdPetition.getLikes();
        this.tableId = tableId;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
}
