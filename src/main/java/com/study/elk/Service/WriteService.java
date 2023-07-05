package com.study.elk.Service;

import com.study.elk.domain.dto.Petitions;
import org.springframework.transaction.annotation.Transactional;

public class WriteService {

    PointService pointService;
    PetitionService petitionService;

    @Transactional
   public int writePetition(Petitions petitions){

        if (petitions.getTableId() != 0){
            return petitionService.updatePetition(petitions);
        }else {
            pointService.UpdateWallet();
            return petitionService.writePetition(petitions);
        }
        //여기서 포인트 사용 로그를 업데이트 해야함.
   }

}
