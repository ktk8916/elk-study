package com.study.elk.search.service;

import com.study.elk.search.dao.AdminMapper;
import com.study.elk.search.dto.UserConvertList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private AdminMapper adminMapper;

    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public List<UserConvertList> userConvertList() {
        return adminMapper.userConvertList();
    };
}
