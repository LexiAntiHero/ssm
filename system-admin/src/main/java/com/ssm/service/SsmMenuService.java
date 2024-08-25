package com.ssm.service;

import com.ssm.entity.SsmMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Menu Permissions Table(SsmMenu)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmMenuService {

    SsmMenu queryById(Long menuId);

    Page<SsmMenu> queryByPage(SsmMenu ssmMenu, PageRequest pageRequest);

    SsmMenu insert(SsmMenu ssmMenu);

    SsmMenu update(SsmMenu ssmMenu);

    boolean deleteById(Long menuId);

}
