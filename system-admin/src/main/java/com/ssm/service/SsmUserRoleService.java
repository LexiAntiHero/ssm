package com.ssm.service;

import com.ssm.entity.SsmUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * User and Role Association Table(SsmUserRole)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmUserRoleService {

    SsmUserRole queryById(Long userId);

    Page<SsmUserRole> queryByPage(SsmUserRole ssmUserRole, PageRequest pageRequest);

    SsmUserRole insert(SsmUserRole ssmUserRole);

    SsmUserRole update(SsmUserRole ssmUserRole);

    boolean deleteById(Long userId);

}
