package com.study.elk.dao;

import com.study.elk.domain.dto.Likes;
import com.study.elk.domain.dto.Petitions;

public interface PetitionMapper {

    int writePetition(Petitions petitions);

    int updatePetition(Petitions petitions);

    Petitions readPetition();


    int isTherebeing(Likes like);

    int likeTable(Likes likes);
    int updateLike(Likes likes);
}
