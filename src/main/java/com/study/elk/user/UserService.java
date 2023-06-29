package com.study.elk.user;

import com.study.elk.user.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(JoinDto dto){
        userRepository.save(dto.toEntity());
    }

}
