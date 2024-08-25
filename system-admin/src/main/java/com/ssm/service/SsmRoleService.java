package com.ssm.service;

import com.ssm.entity.SsmRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Role Information Table(SsmRole)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmRoleService {

    SsmRole queryById(Long roleId);


    Page<SsmRole> queryByPage(SsmRole ssmRole, PageRequest pageRequest);

    SsmRole insert(SsmRole ssmRole);


    SsmRole update(SsmRole ssmRole);

    boolean deleteById(Long roleId);

}
