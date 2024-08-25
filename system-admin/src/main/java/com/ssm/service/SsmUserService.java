package com.ssm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssm.entity.SsmLoginUser;
import com.ssm.entity.SsmUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.HashMap;
import java.util.List;

/**
 * User Information Table(SsmUser)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmUserService {

    SsmUser queryById(Long userId);


    Page<SsmUser> queryByPage(SsmUser ssmUser, PageRequest pageRequest);

    SsmUser insert(SsmUser ssmUser);

    SsmUser update(SsmUser ssmUser);

    boolean deleteById(Long userId);

    SsmLoginUser login(String userName, String password) throws JsonProcessingException;

    void logout();

    HashMap<String, List<String>> getInfo();
}
