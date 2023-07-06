package com.study.elk.dao;

import com.study.elk.domain.dto.Comment;
import com.study.elk.domain.dto.Likes;
import com.study.elk.domain.dto.Petitions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PetitionMapper {

    int writePetition(Petitions petitions);

    int updatePetition(Petitions petitions);

    Petitions readForEdit(int tid);


    int isTherebeing(Likes like);

    int likeTable(Likes likes);
    int updateLike(Likes likes);

    List<Comment> readComment(int tid);
}
