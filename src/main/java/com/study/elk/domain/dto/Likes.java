package com.study.elk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Likes {
    int tid;
    int uid;
    int likes;

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
