package com.study.elk.Service;

import com.study.elk.dao.PetitionMapper;
import com.study.elk.domain.dto.Comment;
import com.study.elk.domain.dto.Petitions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PetitionService {

    PetitionMapper petitionMapper;
    PointService pointService;
    ReadWriteService readWriteService;

    public PetitionService(PetitionMapper petitionMapper) {
        this.petitionMapper = petitionMapper;
    }

    @Transactional
   public int writePetition(Petitions petitions){

        if (petitions.getTableId() != null){
            return readWriteService.updatePetition(petitions);
        }else {
            pointService.UpdateWallet(petitions.getUserId());
            pointService.WalletLog(petitions.getUserId());
            return readWriteService.writePetition(petitions);
            //여기서 포인트 사용 로그를 업데이트 해야함.

        }
   }

   public List<Comment> readComment(int tid){
        return petitionMapper.readComment(tid);
   }

}
