package com.ssm.service;

import com.ssm.entity.SsmRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Role Information Table(SsmRole)表服务接口
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public interface SsmRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    SsmRole queryById(Long roleId);

    /**
     * 分页查询
     *
     * @param ssmRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SsmRole> queryByPage(SsmRole ssmRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ssmRole 实例对象
     * @return 实例对象
     */
    SsmRole insert(SsmRole ssmRole);

    /**
     * 修改数据
     *
     * @param ssmRole 实例对象
     * @return 实例对象
     */
    SsmRole update(SsmRole ssmRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Long roleId);

}
