package com.ssm.service;

import com.ssm.entity.SsmRoleMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Role and Menu Association Table(SsmRoleMenu)表服务接口
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public interface SsmRoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    SsmRoleMenu queryById(Long roleId);

    /**
     * 分页查询
     *
     * @param ssmRoleMenu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SsmRoleMenu> queryByPage(SsmRoleMenu ssmRoleMenu, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ssmRoleMenu 实例对象
     * @return 实例对象
     */
    SsmRoleMenu insert(SsmRoleMenu ssmRoleMenu);

    /**
     * 修改数据
     *
     * @param ssmRoleMenu 实例对象
     * @return 实例对象
     */
    SsmRoleMenu update(SsmRoleMenu ssmRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Long roleId);

}
