package com.ssm.service;

import com.ssm.entity.SsmRoleMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Role and Menu Association Table(SsmRoleMenu)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmRoleMenuService {

    SsmRoleMenu queryById(Long roleId);

    Page<SsmRoleMenu> queryByPage(SsmRoleMenu ssmRoleMenu, PageRequest pageRequest);

    SsmRoleMenu insert(SsmRoleMenu ssmRoleMenu);

    SsmRoleMenu update(SsmRoleMenu ssmRoleMenu);

    boolean deleteById(Long roleId);

}
