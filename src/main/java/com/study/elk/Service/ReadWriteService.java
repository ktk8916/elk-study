package com.study.elk.Service;

import com.study.elk.dao.PetitionMapper;
import com.study.elk.domain.dto.Likes;
import com.study.elk.domain.dto.Petitions;

public class ReadWriteService {

    PetitionMapper petitionMapper;

    public ReadWriteService(PetitionMapper petitionMapper) {
        this.petitionMapper = petitionMapper;
    }

    public int writePetition(Petitions petitions){
        // 여기서 petition에 기존 테이블 번호가 존재하는 지 체크
            return petitionMapper.writePetition(petitions);
    }

    public int updatePetition(Petitions petitions){
        return petitionMapper.updatePetition(petitions);
    }

    public Petitions readForEdit(int tid){
        return petitionMapper.readForEdit(tid);
    }

    public void like(Likes likes){ // 여기서 있는지 없는지 판단해야함
        // TODO likes -> tid uid likes 가 있는 상황
           int therebeing = petitionMapper.isTherebeing(likes); // 여기선 0 or 1이 나옴

            likes.setLikes(therebeing); // 그 값을 세팅함

            petitionMapper.likeTable(likes); // likes에 유저정보 + 테이블 정보 입력하는 곳
            petitionMapper.updateLike(likes); // 여기서 테이블 데이터 업데이트 예정.
    }

}
