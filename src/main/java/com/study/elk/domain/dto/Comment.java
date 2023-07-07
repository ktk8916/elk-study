package com.study.elk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private int commentId;
    private String name;
    private String comment;
    private int petitionId;
    private int userSeq;

    public Comment(int petitionId, int userSeq) {
        this.petitionId = petitionId;
        this.userSeq = userSeq;
    }

    public Comment(int userSeq, String comment, int petitionId) {
        this.userSeq = userSeq;
        this.comment = comment;
        this.petitionId = petitionId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPetitionId() {
        return petitionId;
    }

    public void setPetitionId(int petitionId) {
        this.petitionId = petitionId;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }
}
