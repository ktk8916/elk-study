package com.study.elk.user;

import com.study.elk.user.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<String> home(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("111111");
        arrayList.add("222222");
        return arrayList;
    }
    @PostMapping("/user")
    public void join(@RequestBody JoinDto dto){
        userService.join(dto);
    }
}
