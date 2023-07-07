package com.study.elk.Service;

import com.study.elk.dao.PetitionMapper;
import com.study.elk.domain.dto.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetitionService {

    PetitionMapper petitionMapper;
//    PointService pointService;
//    ReadWriteService readWriteService;

    public PetitionService(PetitionMapper petitionMapper) {
        this.petitionMapper = petitionMapper;
    }

//    @Transactional
//   public int writePetition(Petitions petitions){
//
//        if (petitions.getTableId() != null){
//            return readWriteService.updatePetition(petitions);
//        }else {
//            pointService.UpdateWallet(petitions.getUserId());
//            pointService.WalletLog(petitions.getUserId());
//            return readWriteService.writePetition(petitions);
//            //여기서 포인트 사용 로그를 업데이트 해야함.
//
//        }
//   }

   public List<Comment> readComment(int idx){
        return petitionMapper.readComment(idx);
   }

   public int insertComment(Comment comment){
        return petitionMapper.insertComment(comment);
   }

   public int deleteComment(int commentId){return petitionMapper.deleteComment(commentId);}
}
